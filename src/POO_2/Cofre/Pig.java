import java.util.ArrayList;

public class Pig {
    private boolean broken;
    private ArrayList<Valuable> valuables;
    private int volumeMax;

    public Pig(int volumeMax){
        this.broken = false;
        this.valuables = new ArrayList<>();
        this.volumeMax = volumeMax;
    }
    
    public boolean addValuable(Valuable valuable){
        if(isBroken()){
            IO.println("fail: the pig is broken");
            return false;
        }
        if(getVolume() + valuable.getVolume() >= volumeMax){
            IO.println("fail: the pig is full");
            return false;
        }
        valuables.add(valuable);
        return true;
    }

    public boolean breakPig(){
        if(isBroken()){
            IO.println("fail: the pig is already broken");
            return false;
        }
        broken = true;
        return broken;
    }

    public ArrayList<Valuable> getCoins() throws Exception{
        if (!isBroken()) {
            throw new BreakPigException(broken);
        }
        ArrayList<Valuable> extracted = new ArrayList<>();
        for(int i = 0; i < valuables.size(); i++){
            Valuable v = valuables.get(i);
            if(v instanceof Coin){
                valuables.remove(v);
                extracted.add(v);
                i--;
            }
        }
        if(extracted.isEmpty()){
            return null;
        }
        return extracted;
    }

    public ArrayList<Valuable> getItems() throws Exception{
        if (!isBroken()) {
            throw new BreakPigException(broken);
        }
        ArrayList<Valuable> extracted = new ArrayList<>();
        for(int i = 0; i < valuables.size(); i++){
            Valuable v = valuables.get(i);
            if(v instanceof Item){
                valuables.remove(v);
                extracted.add(v);
                i--;
            }
        }
        if(extracted.isEmpty()){
            return null;
        }
        return extracted;
    }

    public int getVolume(){
        int volume = 0;
        if(!isBroken()){
            for(Valuable v : valuables){
                volume += v.getVolume();
            }
        }
        return volume;
    }

    public double getValue(){
        double totalValue = 0.0;
            for(Valuable v : valuables){
                totalValue += v.getValue();
            }
        return totalValue;
    }

    public int volumeMax(){
        return volumeMax;
    }

    public boolean isBroken(){
        return broken;
    }

    @Override
    public String toString(){
        String str = "[";
        if(!valuables.isEmpty()){
            for(int i = 0; i <= valuables.size()-2; i++){
                str += valuables.get(i)+ ", ";
            }
            str += valuables.get(valuables.size()-1);
        }
        str += "] : " + String.format("%.2f", getValue()) + "$ : " + getVolume() + "/" + volumeMax() + " : ";
        if(broken){str += "broken";}else{str += "intact";}
        return str;
    }
}