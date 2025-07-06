package com.ejemplo;

/**
 * Representa un pedido realizado por un cliente.
 */
public class Pedido {
  private final String nombreCliente;
  private final String producto;

  /**
   * Construye un Pedido con el nombre del cliente y el producto especificados.
   *
   * @param nombreCliente el nombre del cliente
   * @param producto el producto solicitado
   */
  public Pedido(String nombreCliente, String producto) {
    this.nombreCliente = nombreCliente;
    this.producto = producto;
  }

  /**
   * Obtiene el nombre del cliente para este pedido.
   *
   * @return el nombre del cliente
   */
  public String getNombreCliente() {
    return nombreCliente;
  }

  /**
   * Obtiene el producto para este pedido.
   *
   * @return el producto
   */
  public String getProducto() {
    return producto;
  }

  @Override
  public String toString() {
    return "Pedido{"
            + "nombreCliente='" + nombreCliente + '\''
            + ", producto='" + producto + '\''
            + '}';
  }
}