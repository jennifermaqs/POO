package POO_2.Agiota;

enum Label {
    GIVE("give"),
    TAKE("take"),
    PLUS("plus");
    
    private String name;
    
    Label(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
