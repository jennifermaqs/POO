package POO_2.Carro;

class Carro {
    public int pass;
    public int passMax;
    public int gas;
    public int gasMax;
    public int km;
    
    public Carro() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }
    
    public void enter() {
        if (pass < passMax) {
            pass++;
        } else {
            IO.println("fail: limite de pessoas atingido");
        }
    }
    
    public void leave() {
        if (pass > 0) {
            pass--;
        } else {
            IO.println("fail: nao ha ninguem no carro");
        }
    }
    
    public void drive(int value) {
        if (pass == 0) {
            IO.println("fail: nao ha ninguem no carro");
        } else if (gas == 0) {
            IO.println("fail: tanque vazio");
        } else if (gas >= value) {
            gas -= value;
            km += value;
        } else {
            IO.println("fail: tanque vazio apos andar " + gas + " km");
            km += gas;
            gas = 0;
        } 
    }
    
    public void fuel(int value) {
        gas += value;
        if (gas > gasMax) {
            gas = gasMax;
        }
        
    }
    
    public String toString() {
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
    
}