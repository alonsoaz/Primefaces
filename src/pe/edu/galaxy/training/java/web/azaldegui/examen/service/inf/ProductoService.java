package pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf;

import java.util.List;

import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.ProductoPrecioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;

public interface ProductoService extends GenericoService<ProductoBean>{

	public List<ProductoPrecioBean> listarPrecios
	(ProductoBean productoBean)	throws ServicioException;
	
	public List<ProductoPrecioBean> listarPreciosxCodigo
	(ProductoBean productoBean) throws ServicioException;
}
