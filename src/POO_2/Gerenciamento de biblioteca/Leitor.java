class Leitor {
    private String nome;
    private Livro livroEmprestado;
    private int quantidadeEmprestimos;

    public Leitor(String nome) {
        this.nome = nome;
        this.livroEmprestado = null;
        this.quantidadeEmprestimos = 0;
    }
    
    public boolean possuiLivroEmprestado() {
        return this.livroEmprestado != null;
    }
    
    public void realizarEmprestimo(Livro livro) {
        this.livroEmprestado = livro;
        this.quantidadeEmprestimos++;
        
        IO.println("Sucesso! Total de empréstimos realizados por " + this.nome + ": " + this.quantidadeEmprestimos);
        
    }
    
    public Livro realizarDevolucao() {
        Livro livroParaDevolver = this.livroEmprestado;
        this.livroEmprestado = null;
        return livroParaDevolver;
        
    }

    @Override
    public String toString() {
        String str = possuiLivroEmprestado() ? "+" : "-";
        return String.format("[%s%s, %d]", this.nome, str, this.quantidadeEmprestimos);
    }
}
