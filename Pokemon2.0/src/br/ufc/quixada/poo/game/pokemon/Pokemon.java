package br.ufc.quixada.poo.game.pokemon;

public class Pokemon {
    private String nome;
    private String tipo;
    private int nivel;
    private int pontosDeVida;
    private int ataque;
    private int defesa;
    private int velocidade;
    private int experiencia;

    public Pokemon(String nome) {
        super();
        this.nome = nome;
        System.out.println("Iniciando...");
    }

    public String getNome() {
        return nome;
    }

    public String falar() {
        return nome + " " + nome;
    }

    public int curar(int pontosDeVida) {
        this.pontosDeVida += pontosDeVida;
        return this.pontosDeVida;
    }

    public void atacar(int movimento, Pokemon alvo) {
        if (taVivo()) {
            //ataque!
            System.out.println("Atacando o " + alvo + " com ataque" + movimento);
        } else {
            System.out.println("to morto :/");
        }
    }

    public boolean taVivo() {
        return this.pontosDeVida > 0;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nome='" + nome + '\'' +
                ", pontosDeVida=" + pontosDeVida +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                ", velocidade=" + velocidade  +
                '}';
    }
}