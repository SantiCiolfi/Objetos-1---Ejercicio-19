package objetos1.Ejercicio_19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMercadoDeObjetos {
	
	MercadoDeObjetos m;
	Persona persona;
	Producto producto;
	Pedido pedido;
	
	@BeforeEach
	public void setUp() {
		m = new MercadoDeObjetos();
	}
	
	@Test
	public void testRegistrosDePersonasYProductos() {
		persona = m.registrarCliente("Compra", "calle 2");
		assertTrue(m.getClientes().contains(persona));
		persona = m.registrarVendedor("Vende", "calle 1");
		assertTrue(m.getVendedores().contains(persona));
		producto = m.ponerProductoEnVenta("lata", "aluminio", 2000, 25, persona);
		assertTrue(m.getProductos().contains(producto));
	}
	
	@Test
	public void testBusquedas() {
		persona = m.registrarVendedor("Vende", "calle 1");
		assertEquals(persona, m.buscarVendedor("Vende"));
		persona = m.registrarCliente("Compra", "calle 2");
		assertEquals(persona, m.buscarCliente("Compra"));
		producto = m.ponerProductoEnVenta("lata", "aluminio", 2000, 25, persona);
		assertTrue(m.buscarProductos("lata").contains(producto));
	}
	
	@Test
	public void testPedido() {
		persona = m.registrarCliente("Compra", "calle 2");
		producto = m.ponerProductoEnVenta("lata", "aluminio", 2000, 25, persona);
		pedido = m.crearPedido(persona, producto, 10, "al contado", "retirar en comercio");
		assertEquals(20000, m.calcularCosto(pedido));
		assertNull(m.crearPedido(persona, producto, 35, "al contado", "retirar en comercio"));
		pedido = m.crearPedido(persona, producto, 10, "6 cuotas", "retirar en sucursal del correo");
		assertEquals(24050, m.calcularCosto(pedido));
		pedido = m.crearPedido(persona, producto, 10, "al contado", "express a domicilio");
		assertEquals(20050, m.calcularCosto(pedido));
	}
}
