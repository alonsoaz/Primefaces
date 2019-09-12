package pe.edu.galaxy.training.java.web.azaldegui.examen.bean;


public class ProductoBean extends GenericoBean{

	private String serie, descripcion;
	
	private float precio;
	
	private String marca, modelo;

	public ProductoBean() {
		super();
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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
		return "ProductoBean [serie=" + serie + ", descripcion=" + descripcion + ", precio=" + precio + ", marca="
				+ marca + ", modelo=" + modelo + "]";
	}

}
