package POO_2.Junkfood;

public class Slot {
    private String name;
    private float price;
    private int quantity;
    
    public Slot(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        String nome;
        if(name.equals("empty")) { 
        nome = "  empty";
        } else {
            nome = name;
            while (nome.length() < 7) {
                nome += " ";
            }
        }
        return String.format("[ %s : %d U : %.2f RS]", nome, quantity, price);
    }
}
