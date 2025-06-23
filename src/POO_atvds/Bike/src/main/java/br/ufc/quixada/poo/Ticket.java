package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
  private Veiculo veiculo;
  private LocalDateTime horaEntrada;
  private LocalDateTime horaSaida;
  private double valorPago;
  private boolean pago;
  

  public Ticket(Veiculo veiculo) {
    this.veiculo = veiculo;
    this.horaEntrada = LocalDateTime.now();
    this.pago = false;
    this.valorPago = 0.0;

  }

  public double getValorPago() {
    return valorPago;
  }

  public void setValorPago(double valorPago) {
    this.valorPago = valorPago;
  }

  public boolean isPago() {
    return pago;
  }

  public void setPago(boolean pago) {
    this.pago = pago;
  }

  public LocalDateTime getHoraEntrada() {
    return horaEntrada;
  }

  public LocalDateTime getHoraSaida() {
    return horaSaida;
  }

  public void setHoraSaida(LocalDateTime horaSaida) {
    this.horaSaida = horaSaida;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public long getDuracaoEmMinutos() {
    if (horaSaida != null) {
      return Duration.between(horaEntrada, horaSaida).toMinutes();
    }
    return 0;
  }

  public void calcularValor() {
    long duracaoEmMinutos = getDuracaoEmMinutos();
    if (duracaoEmMinutos <= 0) {
      this.valorPago = 0.0;
      return;
    }
    if(veiculo instanceof Bike) {
      this.valorPago = 3.0;
    } 
    else if (veiculo instanceof Moto) {
      if (duracaoEmMinutos <= 60) {
        this.valorPago = 3.0;
      } else {
        this.valorPago = 3.0 + (duracaoEmMinutos - 60) * 0.1;
      }
    } 
    else if (veiculo instanceof Carro) {
      if (duracaoEmMinutos <= 60) {
        this.valorPago = 5.0; 
      } else {
        this.valorPago = 5.0 + (duracaoEmMinutos - 60) * 0.1;
        if(duracaoEmMinutos == 300) {
          this.valorPago = 30.0;
        }
      }
    }
  }
}