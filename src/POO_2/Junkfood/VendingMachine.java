package POO_2.Junkfood;

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Slot> slots;
    private float profit;
    private float cash;
    
    public VendingMachine(int capacity) {
        this.slots = new ArrayList<>();
        for(int i = 0; i<capacity; i++) {
            this.slots.add(new Slot("empty", 0, 0));
        }
        this.profit = 0;
        this.cash = 0;
    }
    
    public Slot getSlot(int index) {
        if(index < 0 || index >= slots.size()) {
            return null;
        }
        return slots.get(index);
    }
    
    public void setSlot(int index, Slot slot) {
        if(index < 0 || index >= slots.size()) {
            IO.println("fail: indice nao existe");
            return;
        }
        slots.set(index, slot);
    }
    
    public void clearSlot(int index) {
        if(index < 0 || index >= slots.size()) {
            IO.println("fail: indice nao existe");
            return;
        }
        slots.set(index, new Slot("empty", 0, 0));
    }
    
    public void insertCash(float value) {
        this.cash += value;
    }
    
    public float withdrawCash() {
        float value = this.cash;
        this.cash = 0;
        return value;
    }
    
    public float getCash() {
        return this.cash;
    }
    
    public float getProfit() {
        return this.profit;
    }
    
    public void buyItem(int index) {
        if(index < 0 || index >= slots.size()) {
            IO.println("fail: indice nao existe");
            return;
        }
        
        Slot slot = slots.get(index);
        
        if(slot.getQuantity() == 0) {
            IO.println("fail: espiral sem produtos");
            return;
        } else if(slot.getPrice() > cash) {
            IO.println("fail: saldo insuficiente");
            return;
        } else { 
        slot.setQuantity(slot.getQuantity() - 1);
        this.cash -= slot.getPrice();
        this.profit += slot.getPrice();
        
        IO.println("voce comprou um " + slot.getName());
        }
    }
    
    @Override
    public String toString() {
        String t = "saldo: " + String.format("%.2f", cash) + "\n";
        for(int i = 0; i < slots.size(); i++) {
            t += i + " " + slots.get(i).toString();
            if(i != slots.size() - 1) {
                t += "\n";
            }
        }
        return t;
    }
    
    
}