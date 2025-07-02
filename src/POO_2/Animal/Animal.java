class Animal {
    String species;
    String sound;
    int age;
    
    public Animal(String species, String sound) {
        this.species = species;
        this.sound = sound;
        this.age = 0;
    }
    
    public String fazerBarulho() {
        if (age == 0) {
            return "---";
        } 
        if (age == 4) {
            return "RIP";
        }
        return this.sound;
    }
    
    public void envelhecer(int value) {
        age += value;
        if(age >= 4) {
            IO.printf("warning: %s morreu\n", species);
            this.age = 4;
        }
        
    }
    
    public String imprimir() {
        return species + ":" + age + ":" + sound;
    }
}
