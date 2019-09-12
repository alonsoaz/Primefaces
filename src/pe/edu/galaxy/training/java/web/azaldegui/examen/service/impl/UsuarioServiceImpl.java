package pe.edu.galaxy.training.java.web.azaldegui.examen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf.UsuarioDAO;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired //DI/IoC
	private UsuarioDAO usuarioDAO;

	public UsuarioServiceImpl() {

	}

	public List<UsuarioBean> listar(UsuarioBean usuarioBean) throws ServicioException {
		try {
			return this.getUsuarioDAO().listar(usuarioBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}
	@Override
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean) throws ServicioException {
		try {
			return this.getUsuarioDAO().validarAcceso(usuarioBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public UsuarioBean buscarXCodigo(UsuarioBean usuarioBean) throws ServicioException {
		try {
			return this.getUsuarioDAO().buscarXCodigo(usuarioBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public boolean insertar(UsuarioBean t) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean actualizar(UsuarioBean t) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eliminar(UsuarioBean t) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
