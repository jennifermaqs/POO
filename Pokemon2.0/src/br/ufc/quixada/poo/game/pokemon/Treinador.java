package br.ufc.quixada.poo.game.pokemon;

public class Treinador {
    private String nome;
    private int x;
    private int y;
    private Pokemon[] pokemons;

    public Treinador(String nome){
        this.nome = nome;
        this.x = 0;
        this.y = 0;
        this.pokemons = new Pokemon[11];
    }

    public String getNome() {
        return nome;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosicao(int x, int y){
        this.x = x;
        this.y = y;
    }

    //nesse caso a melhor solução é usar switch case
    public String mover(String direcao){
        if(direcao.equals("cima")){
            this.y -= 1;
        }else if(direcao.equals("baixo")) {
            this.y += 1;
        }else if (direcao.equals("esquerda")) {
            this.x += 1;
        }else if (direcao.equals("direita") ){
            this.x -= 1;
        }
        return "Posição: " + this.x + " e " + this.y;
    }

    public void listarPokemons(){
        for(int i = 0; i < pokemons.length; i++){
            if(pokemons[i] != null){
                System.out.println(this.pokemons[i].getNome());
            }else {
                break;
            }
        }
    }

    public boolean capturar(Pokemon p){
        int cont = 0;
        for(int i = 0; i < pokemons.length; i++){
            if(pokemons[i] == null){
                pokemons[i] = p;
                break;
            }else{
                cont++;
            }
        }
        if(cont == pokemons.length){
            return false;
        }else{
            return true;
        }
    }
}


