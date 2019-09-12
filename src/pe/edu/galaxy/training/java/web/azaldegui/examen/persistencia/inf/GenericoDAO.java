package pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.inf;

import java.util.List;

import pe.edu.galaxy.training.java.web.azaldegui.examen.persistencia.exception.PersistenciaException;

public interface GenericoDAO<T> {

	public List<T> listar(T t) throws PersistenciaException;

	public T buscarXCodigo(T t) throws PersistenciaException;

	public boolean insertar(T t) throws PersistenciaException;

	public boolean actualizar(T t) throws PersistenciaException;

	public boolean eliminar(T t) throws PersistenciaException;

}
