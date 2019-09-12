package pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;

public interface UsuarioService extends GenericoService<UsuarioBean>{
	
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean)throws ServicioException;

}
