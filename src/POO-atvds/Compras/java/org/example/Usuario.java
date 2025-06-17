package org.example;

import java.util.*;

public class Usuario {

  private Collection<Pedido> pedidos = new HashSet<>();

  public boolean add(Pedido pedido) {
    return pedidos.add(pedido);
  }

  public Collection<Pedido> getPedidos() {
    return pedidos;
  }
}
