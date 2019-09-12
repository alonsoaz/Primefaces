package pe.edu.galaxy.training.java.web.azaldegui.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="producto.listar", 
					procedureName="PKG_PRODUCTO.SP_LISTAR",
					resultClasses= ProductoEntity.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_DESCRIPCION", type=String.class)	
						}					
				),
				@NamedStoredProcedureQuery(
						name="producto.listarPrecios", 
						procedureName="PKG_PRODUCTO.SP_LISTAR_PRECIOS",
						resultClasses= ProductoPrecioEntity.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_DESCRIPCION", type=String.class)	
							}					
					),
				@NamedStoredProcedureQuery(
						name="producto.listarPreciosxCodigo", 
						procedureName="PKG_PRODUCTO.SP_LISTAR_PRECIOS_X_CODIGO",
						resultClasses= ProductoPrecioEntity.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_CODIGO", type=Long.class)	
							}					
					),
				@NamedStoredProcedureQuery(
						name="producto.buscarXCodigo", 
						procedureName="PKG_PRODUCTO.SP_BUSCAR_X_ID",
						resultClasses= ProductoEntity.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_CODIGO", type=Long.class)	
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="producto.insertar", 
						procedureName="PKG_PRODUCTO.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_CODIGO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_SERIE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_DESCRIPCION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_PRECIO", type=Float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_MARCA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_MODELO", type=String.class),
									// Auditoria
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IDUSUARIO", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class)
									
									
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="producto.actualizar", 
						procedureName="PKG_PRODUCTO.SP_ACTUALIZAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_CODIGO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_SERIE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_DESCRIPCION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_PRECIO", type=Float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_MARCA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_MODELO", type=String.class),
									//Auditoria
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IDUSUARIO", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class)
									
									
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="producto.eliminar", 
						procedureName="PKG_PRODUCTO.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_CODIGO", type=Long.class ),
									
									// Auditoria
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IDUSUARIO", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class)
									
									
							}					
					)
		}
	)


@Entity(name="PRODUCTO")
public class ProductoEntity extends GenericoEntity{

	@Id
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="SERIE")
	private String serie;
	
	@Column(name="DESCRIPCION")
	private String descripicion;
	
	@Column(name="PRECIO")
	private float precio;
	
	@Column(name="MARCA")
	private String marca;
	
	@Column(name="MODELO")
	private String modelo;

	public ProductoEntity() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescripicion() {
		return descripicion;
	}

	public void setDescripicion(String descripicion) {
		this.descripicion = descripicion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "ProductoEntity [codigo=" + codigo + ", serie=" + serie + ", descripicion=" + descripicion + ", precio="
				+ precio + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
