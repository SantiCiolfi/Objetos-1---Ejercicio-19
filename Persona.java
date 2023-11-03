package objetos1.Ejercicio_19;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Persona {

	private String nombre;
	private String direccion;
	
	public Persona(String nombre, String direccion) {
		this.direccion=direccion;
		this.nombre=nombre;
	}
	
	public boolean compararNombre(String unNombre) {
		return this.nombre == unNombre;
	}
	
	/*public String getDireccion(){
	 * return this.direccion;
	 *}  
	 */
}
