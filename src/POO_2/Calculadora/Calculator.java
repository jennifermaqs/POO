package POO_2.Calculadora;

class Calculator {
    public int battery;
    public int batteryMax;
    public float display;
    
    public Calculator(int batteryMax) {
        this.battery = 0;
        this.batteryMax = batteryMax;
        this.display = 0;
    }
    
    public void charge(int value) {
        this.battery += value;
        if(this.battery > this.batteryMax) {
            this.battery = this.batteryMax;
        }
    }
    
    public boolean useBattery() {
        if(this.battery > 0) {
            this.battery--;
            return true;
        } else {
            IO.println("fail: bateria insuficiente");
            return false;
        }
        
    }
    
    public void sum(int a, int b) {
        if(useBattery()) {
            this.display = a + b;
        }
        
    }
    
    public void div (int num, int den) {
        if(!useBattery()) {
            return;
        } if (den == 0) {
            IO.println("fail: divisao por zero");
            return;
        }
        this.display = (float) num / den;
        
    }
    
    public String toString() {
        return String.format("display = %.2f, battery = %d", this.display, this.battery);
    }
}