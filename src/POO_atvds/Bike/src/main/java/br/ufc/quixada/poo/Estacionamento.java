package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
  private int vagasCarro;
  private int vagasMotoBike;
  private List<Ticket> tickets;

  public Estacionamento(int vagasCarro, int vagasMotoBike) {
    this.vagasCarro = vagasCarro;
    this.vagasMotoBike = vagasMotoBike;
    this.tickets = new ArrayList<>();
  }

  public boolean registrarEntrada(Veiculo veiculo) {
   Ticket ticketExistente = getTicketBy(veiculo.getIdentificador());
    
   if (ticketExistente != null && ticketExistente.isPago() && ticketExistente.getHoraSaida() != null) {
       return registrarEntradaNovoVeiculo(veiculo);
   } else if (ticketExistente == null) {
       return registrarEntradaNovoVeiculo(veiculo);
   }
   return false;
  }
    private boolean registrarEntradaNovoVeiculo(Veiculo veiculo) {
      if(veiculo.getTipoVaga() == TipoVaga.CARRO) { 
        if(vagasCarro > 0) {
          vagasCarro--;
          tickets.add(new Ticket(veiculo));
          System.out.println("Entrada registrada para: " + veiculo.getIdentificador());
          return true;
      } else {
          System.out.println("Sem vagas para carros.");
          return false;
      }
  } else {
      if (vagasMotoBike > 0) {
          vagasMotoBike--;
          tickets.add(new Ticket(veiculo));
          System.out.println("Entrada registrada para: " + veiculo.getIdentificador());
          return true;
      } else {
          System.out.println("Sem vagas para motos/bikes.");
          return false;
      }
   }
}

  public boolean registrarSaida(String identificador, LocalDateTime horaDeSaida) {
    Ticket ticket = getTicketBy(identificador);
    if (ticket != null && !ticket.isPago()) {
      ticket.setHoraSaida(horaDeSaida);
      ticket.calcularValor();
      ticket.setPago(true);

      if(ticket.getVeiculo().getTipoVaga() == TipoVaga.CARRO) {
        vagasCarro++;
      } else {
        vagasMotoBike++;
      }
      System.out.println("Saída registrada. Valor a pagar: r$ " + ticket.getValorPago());
      return true;
    } 
    
    System.out.println("Ticket não encontrado ou já foi pago.");
    return false;
  }


  public Ticket getTicketBy(String identificador) {
    for(int i = 0; i < tickets.size(); i++) {
      if(tickets.get(i).getVeiculo().getIdentificador().equals(identificador)) {
        return tickets.get(i);
      }
    }
    return null;
  }

  public Veiculo[] listarVeiculosEstacionados() {
    Veiculo[] veiculosEstacionados = new Veiculo[tickets.size()];
    int count = 0;
    for (int i = 0; i < tickets.size(); i++) {
      Ticket ticket = tickets.get(i);
      if(!ticket.isPago()) {
        veiculosEstacionados[count] = ticket.getVeiculo();
        count++;
      }
    }
    Veiculo[] resultado = new Veiculo[count];
    for (int i = 0; i < count; i++) {
        resultado[i] = veiculosEstacionados[i];
    }

    return resultado;
}

  public int vagasDisponiveisPara(TipoVaga tipo) {
    if (tipo == TipoVaga.CARRO) {
      return vagasCarro;
    } else {
      return vagasMotoBike;
    }
  }
}




