import java.util.*;
class UFC {
    private Map<String, Funcionario> funcionarios;

    public UFC() {
        this.funcionarios = new TreeMap<String, Funcionario>();
    }

    @Override
    public String toString() {
        String s = "";
        for ( Funcionario f : this.funcionarios.values() ) {
            s += f + "\n";
        }
        return s;
    }

    public Funcionario getFuncionario(String nome) {
        return this.funcionarios.get( nome );
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
}
