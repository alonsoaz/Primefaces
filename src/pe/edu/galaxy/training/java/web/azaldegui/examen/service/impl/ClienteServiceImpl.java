package pe.edu.galaxy.training.java.web.azaldegui.examen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ClienteBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf.ClienteDAO;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.ClienteService;

@Transactional
@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public List<ClienteBean> listar(ClienteBean clienteBean) throws ServicioException {
		try {
			return this.getClienteDAO().listar(clienteBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	@Override
	public ClienteBean buscarXCodigo(ClienteBean clienteBean) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(ClienteBean clienteBean) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ClienteBean clienteBean) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ClienteBean clienteBean) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteBean buscarXRuc(String ruc) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

}
