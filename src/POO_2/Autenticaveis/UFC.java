import java.util.*;


class UFC {
    private Map<String, Funcionario> funcionarios;
    private Map<String, Aluno> alunos;


    public UFC() {
        this.funcionarios = new TreeMap<String, Funcionario>();
        this.alunos = new TreeMap<String, Aluno>();
    }


    @Override
    public String toString() {
        String s = "";
        for ( Funcionario f : this.funcionarios.values() ) {
            s += f + "\n";
        }
        for ( Aluno a : this.alunos.values() ) {
            s += a + "\n";
        }
        return s;
    }


    public Funcionario getFuncionario(String nome) {
        if(this.funcionarios.containsKey(nome)){
            return this.funcionarios.get( nome );
        }
        return null;
    }


    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.put( funcionario.getNome(), funcionario );
    }
    
    public void rmFuncionario(String nome) {
        this.funcionarios.remove( nome );
    }


    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus) {
        if ( this.funcionarios.size() == 0 ) {
            throw new MsgException("fail: sem funcionarios");
        }


        int eachBonus = bonus / this.funcionarios.size();
        for ( Funcionario f : this.funcionarios.values() ) {
            f.setBonus( eachBonus );
        }
    }


    public Aluno getAluno(String nome) {
        if(this.alunos.containsKey(nome)){
            return this.alunos.get(nome);
        }
        return null;
    }


    public void addAluno(Aluno aluno) {
        if(this.alunos.containsKey(aluno.getNome())){
            return;
        }
        this.alunos.put(aluno.getNome(), aluno);
    }
    
    public void rmAluno(String nome) {
        this.alunos.remove(nome);
    }
}
