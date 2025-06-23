package br.ufc.quixada.poo;

public class Veiculo {
  private String identificador;
  private TipoVaga tipoVaga;

  public Veiculo(String identificador, TipoVaga tipoVaga) {
    this.identificador = identificador;
    this.tipoVaga = tipoVaga;
  }

  public String getIdentificador() {
    return identificador;
  }

  public TipoVaga getTipoVaga() {
    return tipoVaga;
  }
}
