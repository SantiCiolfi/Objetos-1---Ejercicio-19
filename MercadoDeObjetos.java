package objetos1.Ejercicio_19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MercadoDeObjetos {
	
	private List<Persona> clientes;
	private List<Persona> vendedores;
	private List<Producto> productos;
	private List<Pedido> pedidos;
	
	public MercadoDeObjetos() {
		this.clientes = new ArrayList<>();
		this.vendedores = new ArrayList<>();
		this.productos = new ArrayList<>();
		this.pedidos =new ArrayList<>();
	}
	
	public Persona registrarCliente(String nombre, String direccion) {
		Persona unaPersona = new Persona (nombre, direccion);
		this.clientes.add(unaPersona);
		return unaPersona;
	}
	
	public Persona registrarVendedor(String nombre, String direccion) {
		Persona unaPersona = new Persona (nombre, direccion);
		this.vendedores.add(unaPersona);
		return unaPersona;
	}
	
	public Persona buscarCliente(String nombre) {
		return this.clientes.stream().filter(cliente -> cliente.compararNombre(nombre)).findFirst().orElse(null);
	}
	
	public Persona buscarVendedor(String nombre) {
		return this.vendedores.stream().filter(vendedor -> vendedor.compararNombre(nombre)).findFirst().orElse(null);
	}
	
	public Producto ponerProductoEnVenta(String nombre, String descripcion, double precio, int cantidad, Persona vendedor) {
		Producto producto = new Producto(nombre, descripcion, precio, cantidad,  vendedor);
		this.productos.add(producto);
		return producto;
	}
	
	public List<Producto> buscarProductos(String nombre){
		return this.productos.stream().filter(producto -> producto.compararNombre(nombre)).collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Persona unCliente, Producto unProducto, int cantidad, String pago, String envio) {
		Pedido pedido = null;
		if(unProducto.compararCantidades(cantidad)) {
			pedido = new Pedido( unCliente,  unProducto,  cantidad,  pago,  envio);
			this.pedidos.add(pedido);
		}
		return pedido;
	}
	
	public double calcularCosto(Pedido unPedido) {
		return unPedido.calcularCosto();
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public List<Persona> getVendedores() {
		return vendedores;
	}

	public List<Producto> getProductos() {
		return productos;
	}

}
