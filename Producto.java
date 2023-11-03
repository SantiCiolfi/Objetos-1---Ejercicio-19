package objetos1.Ejercicio_19;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantidad;
	private Persona vendedor;
	
	public Producto(String nombre, String descripcion, double precio, int cantidad, Persona vendedor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
	}
	
	public boolean compararNombre(String unNombre) {
		return this.nombre == unNombre;
	}
	
	public boolean compararCantidades(int unaCantidad) {
		return this.cantidad >= unaCantidad;
	}
	
	public double calcularCosto(int cantidad) {
		return this.precio * cantidad;
	}
	
	/*public String getDireccionVendedor(){
	 * return this.vendedor.getDireccion();
	 * }
	*/
}
