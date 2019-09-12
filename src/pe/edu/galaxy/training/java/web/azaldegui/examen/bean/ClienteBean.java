package pe.edu.galaxy.training.java.web.azaldegui.examen.bean;


public class ClienteBean extends GenericoBean{

	private String razonSocial;
	
	private String ruc;
	
	private String direccion;

	public ClienteBean() {
		super();
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
