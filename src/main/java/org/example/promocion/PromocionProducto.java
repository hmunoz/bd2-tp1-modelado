package org.example.promocion;

import java.time.LocalDate;
import org.example.Marca;
import org.example.Producto;
import org.example.tarjeta.Tarjeta;

public class PromocionProducto extends Promocion {
  private static final double SIN_DESCUENTO = 0.0;
  private final Marca marca;

  public PromocionProducto(
    LocalDate fechaInicio,
    LocalDate fechaFin,
    double descuento,
    Marca marca
  ) {
    super(fechaInicio, fechaFin, descuento);
    this.marca = marca;
  }

  @Override
  public double calcularDescuento(Producto producto) {
    LocalDate fechaActual = LocalDate.now();

    if (aplicaDescuento(producto)) {
      return this.descuento;
    }

    return SIN_DESCUENTO;
  }

  private boolean aplicaDescuento(Producto producto) {
    LocalDate fechaActual = LocalDate.now();

    if (producto.esMarca(this.marca)) {
      return fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(fechaFin);
    }

    return false;
  }

  @Override
  public double calcularDescuento(Tarjeta tarjeta) {
    return 0;
  }
}
