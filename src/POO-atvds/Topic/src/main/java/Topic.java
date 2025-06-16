
public class Topic {
    private Passageiro[] preferenciais;
    private Passageiro[] normais;
    private int capacidade;
    private int qtdPrioritarios;

    public Topic(int capacidade, int qtdPrioritarios) {
        this.capacidade = capacidade;
        this.qtdPrioritarios = qtdPrioritarios;
        this.preferenciais = new Passageiro[qtdPrioritarios];
        this.normais = new Passageiro[capacidade - qtdPrioritarios];
    }

    public int getNumeroAssentosPrioritarios() {
        return qtdPrioritarios;
    }
    public int getNumeroAssentosNormais() {
        return capacidade - qtdPrioritarios;
    }

    public Passageiro getPassageiroAssentoPrioritario(int lugar) {
        if (lugar >= 0 && lugar < preferenciais.length) {
            return preferenciais[lugar];
        }
        return null;
    }

    public Passageiro getPassageiroAssentoNormal(int lugar) {
        if (lugar >= 0 && lugar < normais.length) {
            return normais[lugar];
        }
        return null;
    }

    public int getVagas() {
        int vagas = 0;
        for (Passageiro p : preferenciais) {
            if (p == null) {
                vagas++;
            }
        }
        for (Passageiro p : normais) {
            if (p == null) {
                vagas++;
            }
        }
        return vagas;
    }

    public boolean subir(Passageiro passageiro) {
        if(isPassageiroPresente(passageiro.getNome())) {
        System.out.println("Passageiro ja esta na topic");
        return false;
        }

        if(isTopicCheia()) {
            System.out.println("Topic lotada");
            return false;
        }

        if(passageiro.ePrioritario()) {
            if(alocarPreferencial(passageiro)) {
                return true;
            }
        }

        return alocarNormal(passageiro);
    }

    public boolean descer (String nome) {
        for (int i = 0; i < preferenciais.length; i++) {
            if(preferenciais[i] != null && preferenciais[i].getNome().equals(nome)){
                preferenciais[i] = null;
                return true;
            }
        }
        for(int i = 0; i < normais.length; i++) {
            if(normais[i] != null && normais [i].getNome().equals(nome)) {
                normais[i] = null;
                return true;
            }
        }
        
        System.out.println("Passageiro nao esta na topic"); 
        return false;
       
    }


    private boolean isTopicCheia() {
        for (Passageiro p : preferenciais) {
            if (p == null) {
                return false;
            }
        }
        for (Passageiro p : normais) {
            if (p == null) {
                return false; 
        }
    }
    return true;
}

        private boolean isPassageiroPresente(String nome) {
        for(Passageiro p : preferenciais) {
        if(p != null && p.getNome().equals(nome)) {
            return true;
        }
    }
      for(Passageiro p : normais) {
        if(p != null && p.getNome().equals(nome)) {
            return true;
        }
    }
       return false;
}

    private boolean alocarPreferencial(Passageiro passageiro) {
        for(int i = 0; i  < preferenciais.length; i++) {
         if(preferenciais[i] == null) {
            preferenciais[i] = passageiro;

            return true;
        }
    }

         return false;
}


    private boolean alocarNormal(Passageiro passageiro) {
         for (int i = 0; i < normais.length; i++) {
            if(normais[i] == null) {
            normais[i] = passageiro;
            return true;
        }
    }
         return alocarPreferencial(passageiro);
}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

    //  passageiros preferenciais
    for (int i = 0; i < preferenciais.length; i++) {
        if (i > 0) sb.append(" "); 
        if (preferenciais[i] == null) {
            sb.append("@");
        } else {
            sb.append("@" + preferenciais[i].getNome() + ":" + preferenciais[i].getIdade());
        }
    }

    // passageiros normais
    for (int i = 0; i < normais.length; i++) {
        sb.append(" "); 
        if (normais[i] == null) {
            sb.append("=");
        } else {
            sb.append("=" + normais[i].getNome() + ":" + normais[i].getIdade());
        }
    }

    sb.append(" ]");
    return sb.toString();
    }
}

