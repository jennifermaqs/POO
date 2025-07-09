enum Coin implements Valuable{
    M10( "M10",0.10,1),
    M25( "M25",0.25,2),
    M50( "M50",0.50,3),
    M100("M100",1.00,4);

    private String label;
    private double value;
    private int volume;

    private Coin(String label, double value, int volume) {
        this.label = label;
        this.value = value;
        this.volume = volume;
    }

    public String getLabel(){
        return label;
    }

    public double getValue(){
        return value;
    }

    public int getVolume(){
        return volume;
    }

    @Override
    public String toString() {
         return label + ":" + String.format("%.2f", value) + ":" + volume;
    }
}