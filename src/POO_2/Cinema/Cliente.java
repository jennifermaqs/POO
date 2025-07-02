package POO_2.Cinema;

public class Cliente {
    private String fone;
    private String id;
    
    public Cliente(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }
    
    public String getFone() {
        return fone;
    }
    
    public String getId() {
        return id;
    }
    
    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Override 
    public String toString() {
        return id + ":" + fone;
    }
}
