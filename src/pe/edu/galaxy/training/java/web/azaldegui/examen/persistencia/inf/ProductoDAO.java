package pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf;

import java.util.List;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoPrecioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;

public interface ProductoDAO extends GenericoDAO<ProductoBean>{

	public boolean actualizarStock(ProductoBean productoBean) 
			throws PersistenciaException;
	
	public List<ProductoPrecioBean> listarPrecios(ProductoBean productoBean)
			throws PersistenciaException;
	
	public List<ProductoPrecioBean> listarPreciosxCodigo(ProductoBean productoBean)
			throws PersistenciaException;
}
