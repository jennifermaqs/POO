package POO_2.Cinema;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private ArrayList<Cliente> cadeiras;
    
    
    public Sala(int capacidade) {
        cadeiras = new ArrayList<>();
        for (int i = 0; i < capacidade; i++) {
            cadeiras.add(null);
        }
    }
    
    public int procurar(String id) {
        for(int i = 0; i < cadeiras.size(); i++) {
            Cliente c = cadeiras.get(i);
            if(c != null && c.getId().equals(id)) {
                return i;
            }
        }
        return -1;
        
    }
    
    public boolean verificarIndice(int indice) {
        return indice >= 0 && indice < cadeiras.size();
    }
    
    public boolean reservar(String id, String fone, int ind) {
        if(!verificarIndice(ind)) {
            IO.println("fail: cadeira nao existe");
            return false;
        }
        if(cadeiras.get(ind) != null) {
            IO.println("fail: cadeira ja esta ocupada");
            return false;
        }
        if(procurar(id) != -1) {
            IO.println("fail: cliente ja esta no cinema");
            return false;
        }
        cadeiras.set(ind, new Cliente (id, fone));
        return true;
    }
    
    public void cancelar(String id) {
        int pos = procurar(id);
        if(pos == -1) {
        IO.println("fail: cliente nao esta no cinema");
        return;
    } 
    cadeiras.set(pos,null);
}
    
    public ArrayList<Cliente> getCadeiras() {
        return cadeiras;
        
    }
    
    @Override
    public String toString() {
        ArrayList<String> lista = new ArrayList<>();
        for(int i = 0; i < cadeiras.size(); i++) {
            Cliente c = cadeiras.get(i);
            if(c == null) {
                lista.add("-");
            } else {
                lista.add(c.toString());
            }
        }
         return "[" + String.join(" ", lista) + "]";
    }
    
}
    

