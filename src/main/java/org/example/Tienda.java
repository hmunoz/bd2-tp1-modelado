package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
  private final List<Producto> productos;
  private final List<Venta> ventas;

  public Tienda() {
    productos = new ArrayList<>();
    ventas = new ArrayList<>();
  }

  public void agregarProducto(Producto producto) {
    productos.add(Producto.crearProducto(producto));
  }

  public void agregarVenta(Venta venta) {
    ventas.add(venta);
  }

  public boolean estadoDeVentas() {
    return this.ventas != null && !this.ventas.isEmpty();
  }
}
