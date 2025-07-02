package POO_2.Budega;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Market {
    private ArrayList<Person> counters;
    private LinkedList<Person> waiting;
    
    public Market (int counterCount) {
        counters = new ArrayList<>();
        for(int i = 0; i < counterCount; i++) {
            counters.add(null); // caixas vazios
        }
        waiting = new LinkedList<>();
    }
    
    public void arrive(Person person) {
        waiting.addLast(person);
    }
    
    public void call(int index) {
        if(index < 0 || index >= counters.size()) {
            IO.println("fail: caixa inexistente");
            return;
        }
        
        if(waiting.isEmpty()) {
            IO.println("fail: sem clientes");
            return;
        }
        
        if(counters.get(index) != null) {
            IO.println("fail: caixa ocupado");
            return;
        }
        counters.set(index, waiting.removeFirst());
    }
    
    public Person finish(int index) {
        if(index < 0 || index >= counters.size()) {
            IO.println("fail: caixa inexistente");
            return null;
        }
        
        if(counters.get(index) == null) {
            IO.println("fail: caixa vazio");
            return null;
        }
        
        Person person = counters.get(index);
        counters.set(index, null);
        return person;
    }
    
    @Override
    public String toString() {
        String caixas = "Caixas: [";
        for(int i = 0; i < counters.size(); i++) {
            Person person = counters.get(i);
            if(i>0) {
            caixas += ", ";
            }
            
            if(person == null) {
                caixas += "-----";
            } else {
                caixas += person.toString();
            }
        } 
        caixas += "]";
        
        String fila = "Espera: [";
        for(int i = 0; i < waiting.size(); i++) {
            Person person = waiting.get(i);
            if(i>0) {
                fila += ", ";
            }
            fila += person.toString();
        }
        fila += "]";
        
        return caixas + "\n" + fila;
    }
    
}