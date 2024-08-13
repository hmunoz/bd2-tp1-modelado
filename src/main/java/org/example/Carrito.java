package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.promocion.PromocionCompra;
import org.example.promocion.PromocionProducto;
import org.example.tarjeta.Tarjeta;

public class Carrito {
  private final Cliente cliente;
  private final List<Producto> productos;
  

  public Carrito(Cliente cliente) {
    this.cliente = cliente;
    this.productos = new ArrayList<>();
  }

  public void agregarProducto(Producto producto) {
    this.productos.add(Producto.crearProducto(producto));
  }

  public double calcularMontoTotalConDescuento(
    PromocionProducto promocionProducto,
    PromocionCompra promocionCompra,
    Tarjeta tarjeta
  ) {
    double total = 0;

    for (Producto producto : productos) {
      total +=
        producto.getPrecio() -
        (producto.getPrecio() * promocionProducto.calcularDescuento(producto));
    }
    return total - (total * promocionCompra.calcularDescuento(tarjeta));
  }

  public Venta realizarCompra(
    PromocionProducto promocionProducto,
    PromocionCompra promocionCompra,
    Tarjeta tarjeta
  ) {
    double totalCompra = calcularMontoTotalConDescuento(
      promocionProducto,
      promocionCompra,
      tarjeta
    );

    try {
      tarjeta.realizarPago(totalCompra);
      return new Venta(LocalDate.now(), this.cliente, productos, totalCompra);
    } catch (RuntimeException e) {
      throw e;
    }
  }
}
