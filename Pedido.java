package objetos1.Ejercicio_19;

public Pedido(Cliente cliente, Producto producto, int cantidad, String pago, String envio) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.pago = pago;
		this.envio = envio;
	}
	
	public double calcularCosto() {
		return this.calcularCostoDelProducto() + this.calcularFormaDePago() + this.calcularCostoEnvio();
	}
	
	private double calcularCostoEnvio() {
		double monto = 0;
			if(this.envio == "retirar en sucursal del correo") {
				monto = 50;
			}
			else {
				if(this.envio == "express a domicilio") {
					//monto = Mapa.distanciaEntre(this.Producto.getDireccionVendedor, this.cliente.getDireccion)
					monto = 100 * 0.50;
				}
			}
		return monto;
	}

	private double calcularFormaDePago() {
		double monto = 0;
		if(this.pago == "6 cuotas") {
			monto = (this.calcularCostoDelProducto() * 0.20);
		}
		return monto;
	}
	
	private double calcularCostoDelProducto() {
		return this.producto.calcularCosto(cantidad);
	}

}
