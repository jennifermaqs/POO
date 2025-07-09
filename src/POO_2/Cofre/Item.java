public class Item implements Valuable{
    private String label;
    private int volume;
    private double value;

    Item(String label, double value, int volume){
        setLabel(label);
        setVolume(volume);
        this.value = value;
    }

    public String getLabel(){
        return label;
    }

    public int getVolume(){
        return volume;
    }

    public double getValue(){
        return value;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    @Override
    public String toString(){
        return label + ":" + String.format("%.2f", value) + ":" + volume;
    }
}