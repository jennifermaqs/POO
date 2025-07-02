package POO_2.Relogio;

class Time {
    private int hour;
    private int minute;
    private int second;
    
    
    public Time(int hour, int minute, int second) {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public void setHour(int value){
        if (value >= 24) {
            IO.println("fail: hora invalida");
            return;
        } else {
            this.hour = value;
        }
    }
    public void setMinute(int value) {
        if (value >= 60) {
            IO.println("fail: minuto invalido");
            return;
        } else { 
            this.minute = value;
        }
    }
    public void setSecond(int value){
        if (value >= 60) {
            IO.println("fail: segundo invalido");
            return;
        } else {
            this.second = value;

        }
    }
    
    public void nextSecond() {
        this.second++;
        if(this.second >= 60) {
            this.second = 0;
            this.minute++;
            
        if(this.minute >= 60) {
            this.minute = 0;
            this.hour++;
        if(this.hour >= 24) {
            this.hour = 0;
                } 
            }
        }
    }
}
