package POO_2.Tamagochi;

class Pet {
    private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;
    
    private boolean testAlive() {
        if(!alive) {
            IO.println("fail: pet esta morto");
            return false;
        } else {
            return true;
        }
    }

    public Pet (int energyMax, int hungryMax, int cleanMax) {
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        
        this.energy = energyMax;
        this.clean = cleanMax;
        this.hungry = hungryMax;
        
        this.age = 0;
        this.diamonds = 0;
        this.alive = true;
    }
    
    public String toString() {
        return String.format("E:%d/%d, S:%d/%d, L:%d/%d, D:%d, I:%d", energy, energyMax, hungry, hungryMax, clean, cleanMax, diamonds, age);
    }
    
    public void eat() {
        if(!testAlive()) {
            return;
        }
        setEnergy(energy - 1);
        setHungry(hungry + 4);
        setClean(clean - 2);
        
        age += 1;
    }
    
    public void play() {
         if(!testAlive()) {
            return;
        }
        setEnergy(energy - 2);
        setHungry(hungry - 1);
        setClean(clean - 3);

        diamonds += 1;
        age += 1;
    }
    
    public void shower() {
         if(!testAlive()) {
            return;
        }
        setEnergy(energy - 3);
        setHungry(hungry - 1);
        setClean(cleanMax);
        age += 2;
    }
    
    public void sleep() {
          if(!testAlive()) { return; }
        if (energyMax - energy < 5) {
            IO.println("fail: nao esta com sono");
            return;
        }
        int asleep = energyMax - energy;
        setEnergy(energyMax);
        setHungry(hungry - 1);
        age += asleep;
        
    }
    
    
    //getters
    public int getClean() {
        return clean;
    }
    public int getCleanMax() {
        return cleanMax;
    }
    public int getEnergy() {
        return energy;
    }
    public int getEnergyMax() {
        return energyMax;
    }
    public int getHungry() {
        return hungry;
    }
    public int getHungryMax() {
        return hungryMax;
    }
    
    //setters
    
    public void setClean(int value) {
         if (value <= 0) {
             clean = 0;
             alive = false;
             IO.println("fail: pet morreu de sujeira");
         } else if (value > cleanMax) { 
             clean = cleanMax;
         } else {
             clean = value;
         }
    }
    
    public void setEnergy(int value) {
        if (value <= 0) {
             energy = 0;
             alive = false;
             IO.println("fail: pet morreu de fraqueza");
         } else if (value > energyMax){ 
             energy = energyMax;
         } else {
             energy = value;
         }
    }
    
    public void setHungry(int value) {
        if (value <= 0) {
             hungry = 0;
             alive = false;
             IO.println("fail: pet morreu de fome");
         } else if(value > hungryMax){ 
             hungry = hungryMax;
         } else {
            hungry = value;
         }
    }
}
