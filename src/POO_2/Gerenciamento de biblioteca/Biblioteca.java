import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Biblioteca {
    
    private Livro[] livros;
    private List<Leitor> filaLeitores;

    public Biblioteca(int capacidade) {
      this.livros = new Livro[capacidade]; 
      this.filaLeitores = new ArrayList<>(); 
    }

    public void adicionarLivro(Livro livro) {
        for(int i = 0; i < livros.length; i++) {
            if(livros[i] == null) {
                livros[i] = livro;
                return;
       }
    }
    
    IO.println("Falha: a biblioteca está cheia");
}

    public void registrarLeitor(Leitor leitor) {
        if(leitor != null) {
            this.filaLeitores.add(leitor);
        }
    }

    public void emprestarLivro(int indiceLivro) {
        if(this.filaLeitores.isEmpty()) {
            IO.println("Falha: fila de leitores vazia");
            return;
        }
        
        Leitor proximoLeitor = this.filaLeitores.get(0);
        
        if(proximoLeitor.possuiLivroEmprestado()) {
            IO.println("Falha: leitor só pode estar com um livro emprestado por vez");
            return;
        }
        
        if(indiceLivro < 0 || indiceLivro >= this.livros.length || this.livros[indiceLivro] == null) {
            IO.println("Falha: livro indisponível");
            return;
        }
        
        proximoLeitor = this.filaLeitores.remove(0);
        
        
        Livro livroParaEmprestar = this.livros[indiceLivro];
        this.livros[indiceLivro] = null;
        
        proximoLeitor.realizarEmprestimo(livroParaEmprestar);
        this.filaLeitores.add(proximoLeitor);
    }

    public void receberLivro() {
        if (this.filaLeitores.isEmpty()) {
            IO.println("Falha: fila de leitores vazia");
            return;
        }
        
        Leitor proximoLeitor = this.filaLeitores.get(0);
        
        if(!proximoLeitor.possuiLivroEmprestado()) {
            IO.println("Falha: leitor não possui um livro para devolver");
            return;
        }
        
         proximoLeitor = this.filaLeitores.remove(0);
         
        Livro livroDevolvido = proximoLeitor.realizarDevolucao();
        this.adicionarLivro(livroDevolvido);
        
        this.filaLeitores.add(proximoLeitor);
    }

    @Override
    public String toString() {
        String str = "Livros: {";
        for(int i = 0; i < livros.length; i++) {
            str += " ";
            if(livros[i] == null) {
                str += "[-----]";
            } else {
                str += livros[i].toString();
            }
        }
        
        str += " }\nFila de Leitores: {";
        
        for(Leitor leitor : filaLeitores) {
            str += " " + leitor.toString();
            
        }
        str += " }";
        return str;
    }
}
