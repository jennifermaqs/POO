class Livro {
    private String titulo;
    private int anoPublicacao;

    public Livro(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.setAnoPublicacao(anoPublicacao);
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int ano) {
        int anoAtual = 2025;
        int anoMinimo = 1440;
        
        if(ano < anoMinimo) {
            IO.println("Falha: ano de publicação inválido");
            this. anoPublicacao = anoMinimo;
        } else if (ano > anoAtual) {
            IO.println("Falha: ano de publicação inválido");
            this.anoPublicacao = anoAtual;
        } else {
            this.anoPublicacao = ano;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s, %d]", this.titulo, this.anoPublicacao);
    }
}
