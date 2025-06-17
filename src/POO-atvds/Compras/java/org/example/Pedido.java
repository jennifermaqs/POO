package org.example;

import java.util.*;

public class Pedido {

  private int id;
  private Map<Item, Integer> itens = new HashMap<>();
  private double valor = 0;

  public Pedido(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public boolean add(Item item) {
    valor += item.getPreco();
    if(!itens.containsKey(item)) {
      itens.put(item, 1);
    } else {
      itens.put(item, itens.get(item) + 1);
    }
    return true;
  }

  public Collection<Item> getItems() {
    List<Item> items = new ArrayList<>(itens.keySet());
    Collections.sort(items);
    return items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pedido pedido = (Pedido) o;
    return id == pedido.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(Map.Entry<Item, Integer> entry : itens.entrySet()) {
      builder.append(entry.getKey() + ": quatidade " + entry.getValue() + "\n");
    }
    builder.append("Valor total: " + valor);
    builder.append("\n");
    return builder.toString();
  }
}
