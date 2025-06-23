package org.example;

public class Main {
  public static void main(String[] args) {
    Usuario eu = new Usuario();
    Item item1 = new Item("Shampoo", 40);
    Item item2 = new Item("Condicionador", 23);
    Item item3 = new Item("Shampoo", 40);

    Pedido p1 = new Pedido(1);
    p1.add(item1);
    p1.add(item2);
    p1.add(item3);

    Pedido p2 = new Pedido(2);

    eu.add(p1);
    eu.add(p2);
    eu.add(p2);

    for(Pedido p: eu.getPedidos()) {
      System.out.println(p);
    }
    System.out.println(eu.getPedidos().size());
  }
}