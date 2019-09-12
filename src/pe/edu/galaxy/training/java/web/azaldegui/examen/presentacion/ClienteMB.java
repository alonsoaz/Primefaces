package pe.edu.galaxy.training.java.web.azaldegui.examen.presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ClienteBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.ClienteService;

@Controller("clienteMB")
@Scope(value="session")
public class ClienteMB extends GenericoMB {

	private List<ClienteBean> lstClienteBeans;
	private ClienteBean clienteBean;
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostConstruct
	public void init() {
		this.setClienteBean(new ClienteBean());
		this.setLstClienteBeans(new ArrayList<ClienteBean>());
		this.buscar();
	}
	
	public void buscar() {
		try {

			this.lstClienteBeans = this.getClienteService().listar(this.clienteBean);

		} catch (ServicioException e) {
			e.printStackTrace();
		}
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<ClienteBean> getLstClienteBeans() {
		return lstClienteBeans;
	}

	public void setLstClienteBeans(List<ClienteBean> lstClienteBeans) {
		this.lstClienteBeans = lstClienteBeans;
	}
	
	

}
