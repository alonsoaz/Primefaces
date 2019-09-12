package pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;

public interface UsuarioDAO extends GenericoDAO<UsuarioBean>{

	public UsuarioBean validarAcceso(UsuarioBean usuarioBean)throws PersistenciaException;
	
}
