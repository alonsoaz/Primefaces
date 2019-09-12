package pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ClienteBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;

public interface ClienteService extends GenericoService<ClienteBean>{

	public ClienteBean buscarXRuc(String ruc) throws ServicioException;
	
}
