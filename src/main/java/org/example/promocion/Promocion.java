package org.example.promocion;

import java.time.LocalDate;
import org.example.Producto;
import org.example.tarjeta.Tarjeta;

public abstract class Promocion {
  protected LocalDate fechaInicio;
  protected LocalDate fechaFin;
  protected double descuento;

  public Promocion(
    LocalDate fechaInicio,
    LocalDate fechaFin,
    double descuento
  ) {
    if (fechaInicio.isEqual(fechaFin)) {
      throw new RuntimeException(
        "Las fechas de inicio y fin no pueden ser iguales"
      );
    }
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descuento = descuento;
  }

  public abstract double calcularDescuento(Tarjeta tarjeta);

  public abstract double calcularDescuento(Producto producto);
}
