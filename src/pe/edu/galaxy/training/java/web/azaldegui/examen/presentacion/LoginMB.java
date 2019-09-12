package pe.edu.galaxy.training.java.web.azaldegui.examen.presentacion;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.UsuarioService;
import pe.edu.galaxy.training.java.web.azaldegui.examen.util.Encrypt;

@Controller(value="loginMB")
@Scope(value="session")
public class LoginMB extends GenericoMB{
	
	private UsuarioBean usuarioBean;

	@Autowired
	protected  UsuarioService usuarioService;


	public LoginMB() {
		
	}
	
	@PostConstruct
	public void init(){
		
		this.setUsuarioBean(new UsuarioBean());	
	
	}
	
	public String validarAcceso(){
		String page="index";
		
		String key=super.getStringJSF("Encrypt.key");
		Encrypt.init(key);
		
		try {
			String claveEncripatada=Encrypt.encrypt(this.getUsuarioBean().getClave());
			
			System.err.println("claveEncripatada "+claveEncripatada);
			
			this.getUsuarioBean().setClave(claveEncripatada);
			try {
				UsuarioBean oUsuario=this.getUsuarioService().validarAcceso(this.getUsuarioBean());
				System.out.println("oUsuario "+oUsuario);
				if (oUsuario!=null){
					
						HttpSession session = super.getRequest().getSession(true);
						session.setAttribute("ID", session.getId());
						session.setAttribute("usuario",oUsuario);
						page="panel";
					}else{
						
				        super.alerta("Usuario y/o clave incorrecto");
					}		

			} catch (Exception e) {
				this.error("Error al validar usuario " + e.getMessage());
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return page;
	}
	
	
	public void cerrarSesion() {
		try {
			HttpSession session = super.getRequest().getSession();
			session.removeAttribute("ID");
			session.removeAttribute("usuario");
			session.invalidate();
			FacesContext.getCurrentInstance().responseComplete();
			super.getResponse().sendRedirect("index");
		} catch (Exception e) {
			System.out.println("exception cerrarSesion");
			//e.printStackTrace();
		}

	}
	

	
	public UsuarioBean getUsuarioActivo(){
		UsuarioBean oUsuarioBean=new UsuarioBean();
		HttpSession session= super.getRequest().getSession();
		if (session!=null) {
			Object obj=session.getAttribute("usuario");
			if (obj!=null) {
				oUsuarioBean=(UsuarioBean)obj; 
			}
		}
		return oUsuarioBean;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}
