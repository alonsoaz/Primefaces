package pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ClienteBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;

public interface ClienteDAO extends GenericoDAO<ClienteBean>{

	public ClienteBean buscarXRuc(String ruc) throws PersistenciaException;
	
	
}
