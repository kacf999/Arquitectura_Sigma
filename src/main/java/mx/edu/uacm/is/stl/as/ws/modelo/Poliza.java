package mx.edu.uacm.is.stl.as.ws.modelo;


@Entity
public class Poliza {
	private String clave;
	private int tipo;
	private float monto;
	private String descripcion;

	public Poliza(String clave, int tipo, float monto, String descripcion) {
		super();
		this.clave = clave;
		this.tipo = tipo;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public void agregarBeneficiario() {}
	
	public void comprobarPorcentaje() {}
	
	public void eliminarBeneficiario() {}
	
	
}
