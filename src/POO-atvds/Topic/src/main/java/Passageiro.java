public class Passageiro {
    private String nome;
    private int idade;

    public Passageiro(String nome, int idade) {
        if (nome == null || nome.isEmpty()) {
            this.nome = "Desconhecido";
        } else {
            this.nome = nome;
        }
            if (idade < 0) {
            this.idade = 0;
        } else {
            this.idade = idade;
        }
    }
    
    String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean ePrioritario() {
        return idade >= 65;
    }
    
    @Override
    public String toString() {
        return nome + ":" + idade;
    }
}