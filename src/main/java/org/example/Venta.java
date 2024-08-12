package org.example;

import java.time.LocalDate;
import java.util.List;

public class Venta {
  private final LocalDate fechaHora;
  private final Cliente cliente;
  private final List<Producto> productosComprados;
  private final double montoTotal;

  public Venta(
    LocalDate fechaHora,
    Cliente cliente,
    List<Producto> productosComprados,
    double montoTotal
  ) {
    this.fechaHora = fechaHora;
    this.cliente = cliente;
    this.productosComprados = productosComprados;
    this.montoTotal = montoTotal;
  }
}
