import java.util.*;

class FuncionarioAutenticavel extends Funcionario implements Autenticavel {
    private String senha;
    private boolean logado = false;

    public FuncionarioAutenticavel(String nome) {
        super(nome);
    
        this.senha = "indefinida";
        this.logado = false;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return this.senha;
    }
    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    public String getLogado() {
        return this.logado ? "online" : "offline";
    }

   public void logar( String senha ) {
        if (!this.senha.equals(senha)) {
            throw new MsgException("fail: senha invalida");
        }
            this.logado = true;
    }


    public void deslogar() {
        this.logado = false;
    }

}

