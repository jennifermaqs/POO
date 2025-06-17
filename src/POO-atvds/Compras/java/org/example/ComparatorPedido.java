package org.example;

import java.util.Comparator;

public class ComparatorPedido implements Comparator<Pedido> {
  @Override
  public int compare(Pedido o1, Pedido o2) {
    return o1.getId() - o2.getId();
  }
}
