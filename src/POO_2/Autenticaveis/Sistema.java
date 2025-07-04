import java.util.*;
class Sistema {
    private UFC ufc;
    private Map<String, Autenticavel> usuarios;

    public Sistema() {
        this.ufc = new UFC();
        this.usuarios = new TreeMap<>();
    }

    public UFC getUFC() {
         return this.ufc;
   }

    public Autenticavel getUsuario(String nome) {
          return this.usuarios.get(nome);
  }

  public void addUsuario(String nome, String senha) {
        if (this.usuarios.containsKey(nome)) {
            throw new MsgException("fail: usuario " + nome + " ja existe");
        }

        Funcionario func = this.getUFC().getFuncionario(nome);

        if (func instanceof Terceirizado) {
            throw new MsgException("fail: terc nao pode ser cadastrado no sistema");
        }
        
        Autenticavel usuario = null;
        if (func != null) {
            usuario = (Autenticavel) func;
        } else {
            usuario = this.getUFC().getAluno(nome);
        }

        if (usuario == null) {
            throw new MsgException("fail: " + nome + " nao encontrado");
        }

        usuario.setSenha(senha); 
        this.usuarios.put(nome, usuario); 
    }
    

    public void rmUsuario(String nome) {
         if(!this.usuarios.containsKey(nome)){
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        }


        this.usuarios.remove(nome);
    }
    
     public void logar(String nome, String senha) {
        if (!this.usuarios.containsKey(nome)) {
        throw new MsgException("fail: usuario " + nome + " nao encontrado");
    }

    Autenticavel usuario = this.usuarios.get(nome);
    usuario.logar(senha);
    }


    public void deslogar(String nome) {
         if (!this.usuarios.containsKey(nome)) {
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        }
        this.usuarios.get(nome).deslogar();
    }


    public void deslogarTodos() {
        
        this.usuarios.forEach((key, user) -> user.deslogar());
    }

    public String showUser( String nome ) {
        if(!this.usuarios.containsKey(nome)){
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        }

        Autenticavel usu = this.usuarios.get(nome);
        return usu + ":" + usu.getSenha() + ":" + usu.getLogado();
   }

    @Override
    public String toString() {
        String s = "";
        for ( Autenticavel u : this.usuarios.values() ) {
            s += u + ":" + u.getSenha() + ":" + u.getLogado() + "\n";
        }
        return s;
    }
}