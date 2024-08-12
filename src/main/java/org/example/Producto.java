package org.example;

public class Producto {
  private final String codigo;
  private final String descripcion;
  private final Categoria categoria;
  private final double precio;
  private final Marca marca;

  public Producto(
    String codigo,
    String descripcion,
    Categoria categoria,
    double precio,
    Marca marca
  )
    throws RuntimeException {
    if (categoria == null || descripcion == null || codigo == null) {
      throw new RuntimeException("Los datos proporcionados no son válidos");
    }

    this.codigo = codigo;
    this.descripcion = descripcion;
    this.categoria = categoria;
    this.precio = precio;
    this.marca = marca;
  }

  public static Producto crearProducto(Producto producto) {
    return new Producto(
      producto.codigo,
      producto.descripcion,
      producto.categoria,
      producto.precio,
      producto.marca
    );
  }

  public boolean esMarca(Marca marca) {
    return this.marca.equals(marca);
  }

  public double getPrecio() {
    return this.precio;
  }

  public Marca getMarca() {
    return this.marca;
  }
}
