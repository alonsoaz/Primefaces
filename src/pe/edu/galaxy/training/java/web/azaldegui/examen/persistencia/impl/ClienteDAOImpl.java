package pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ClienteBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.entity.ClienteEntity;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf.ClienteDAO;

@Repository("clienteDAO")
public class ClienteDAOImpl implements ClienteDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ClienteBean> listar(ClienteBean clienteBean) throws PersistenciaException {
		
		List<ClienteBean> lstClienteBeans = new ArrayList<ClienteBean>();
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.listar");
			// IN
			spq.setParameter("P_RAZON_SOCIAL", clienteBean.getRazonSocial());

			if (spq.execute()) {
				
				Object ret= spq.getOutputParameterValue("P_CURSOR");
				if (ret!=null) {
					@SuppressWarnings("unchecked")
					List<ClienteEntity> lstClienteEntity =(List<ClienteEntity>) ret;
					lstClienteEntity.forEach( clienteEntity->{
						ClienteBean oClienteBean = new ClienteBean();
						try {
							BeanUtils.copyProperties(oClienteBean, clienteEntity);
						} catch (IllegalAccessException | InvocationTargetException e) {
							e.printStackTrace();
						}
						lstClienteBeans.add(oClienteBean);
					});
				}
				
			}
			em.close();

			return lstClienteBeans;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	@Override
	public ClienteBean buscarXCodigo(ClienteBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(ClienteBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ClienteBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ClienteBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteBean buscarXRuc(String ruc) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
