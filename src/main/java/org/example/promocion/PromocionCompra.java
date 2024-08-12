package org.example.promocion;

import java.time.LocalDate;
import org.example.Producto;
import org.example.tarjeta.Tarjeta;

public class PromocionCompra extends Promocion {
  private static final double SIN_DESCUENTO = 0.0;
  private final Tarjeta tarjeta;

  public PromocionCompra(
    LocalDate fechaInicio,
    LocalDate fechaFin,
    double descuento,
    Tarjeta tarjeta
  ) {
    super(fechaInicio, fechaFin, descuento);
    this.tarjeta = tarjeta;
  }

  @Override
  public double calcularDescuento(Tarjeta tarjeta) {
    if (aplicaDescuento(tarjeta)) {
      return this.descuento;
    }

    return SIN_DESCUENTO;
  }

  private boolean aplicaDescuento(Tarjeta tarjeta) {
    LocalDate fechaActual = LocalDate.now();

    if (tarjeta.aplica(this.tarjeta)) {
      return (
        fechaActual.isAfter(fechaInicio) &&
        fechaActual.isBefore(fechaFin) &&
        this.tarjeta.aplica(tarjeta)
      );
    }

    return false;
  }

  @Override
  public double calcularDescuento(Producto producto) {
    return 0;
  }
}
