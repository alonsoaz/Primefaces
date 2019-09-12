package pe.edu.galaxy.training.java.web.azaldegui.examen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoPrecioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf.ProductoDAO;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired //DI/IoC
	private ProductoDAO productoDAO;

	public ProductoServiceImpl() {

	}

	public List<ProductoBean> listar(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().listar(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public ProductoBean buscarXCodigo(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().buscarXCodigo(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public boolean insertar(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().insertar(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public boolean actualizar(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().actualizar(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public boolean eliminar(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().eliminar(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}


	@Override
	public List<ProductoPrecioBean> listarPrecios(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().listarPrecios(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	@Override
	public List<ProductoPrecioBean> listarPreciosxCodigo(ProductoBean productoBean) throws ServicioException {
		try {
			return this.getProductoDAO().listarPreciosxCodigo(productoBean);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}
}
