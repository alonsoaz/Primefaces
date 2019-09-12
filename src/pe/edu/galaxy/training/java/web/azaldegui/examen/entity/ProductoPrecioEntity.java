package pe.edu.galaxy.training.java.web.azaldegui.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="V_PRODUCTO_PRECIO")
public class ProductoPrecioEntity {

	@Id
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PRECIO")
	private float precio;
	
	@Column(name="FECHA")
	private String fecha;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	public ProductoPrecioEntity() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
