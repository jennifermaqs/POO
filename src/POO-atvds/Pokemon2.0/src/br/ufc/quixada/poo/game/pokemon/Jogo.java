package br.ufc.quixada.poo.game.pokemon;

import br.ufc.quixada.poo.game.pokemon.Mapa;
import br.ufc.quixada.poo.game.pokemon.Treinador;
public class Jogo {
    Mapa mapa;
    Treinador treinador;

    public Jogo(String treinador) {
        this.treinador = new Treinador(treinador);
        this.mapa = new Mapa(4, 4);
    }

    public void iniciar() {

        treinador.setPosicao(2, 3);
        treinador.mover("esquerda");
        if(mapa.posicaoValida(treinador.getX(), treinador.getY())) {
            mapa.exibirMapa(treinador.getX(), treinador.getY());
        }else{
            System.out.println("Posicao Invalida");
        }
    }
}
