package br.ufc.quixada.poo.game.pokemon;

public class Mapa {
    private char[][] layout;
    private final int largura; //final é pra sinalizar que é uma constante
    private final int altura;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;//como a altura é tipo final é exigido que seja inicializado com algum valor
        layout = new char[largura][altura];
    }

    private void inicializarMapa(){
        for(int i = 0; i < largura; i++){
            for(int j = 0; j < altura; j++){
                layout[i][j] = '.';
            }
        }
    }

    public void exibirMapa(int x, int y){
        inicializarMapa();
        for(int i = 0; i < largura; i++){
            for(int j = 0; j < altura; j++){
                if(x == i && y == j){
                    layout[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < largura; i++){
            for(int j = 0; j < altura; j++){
                System.out.print(layout[i][j]);
            }
            System.out.println();
        }
    }

    public boolean posicaoValida(int x, int y){
        return !(x >= largura || y >= altura || x < 0 || y < 0);
    }

}
