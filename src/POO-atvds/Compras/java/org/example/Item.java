package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Item implements Compravel, Comparable<Item> {

  private String descricao;
  private double valor;

  public Item(String descricao, double preco) {
    this.descricao = descricao;
    this.valor = preco;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Double.compare(valor, item.valor) == 0 && Objects.equals(descricao, item.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descricao, valor);
  }

  @Override
  public double getPreco() {
    return valor;
  }

  @Override
  public String toString() {
    return "Item{" +
            "descricao='" + descricao + '\'' +
            ", valor=" + valor +
            '}';
  }

  @Override
  public int compareTo(Item o) {
    return this.descricao.compareTo(o.descricao);
  }
}
