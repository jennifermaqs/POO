public class Solver {
    public static void main(String[] arg) {
        System.out.println("side_by_side=080");
        Pig pig = new Pig(0);

        while (true) {
            try{
                String[] line = IO.inputPartsPrintingLine();
    
                if      (line[0].equals("end") )            { break; }
                else if (line[0].equals("init"))            { pig = new Pig(IO.strToInt(line[1])); }
                else if (line[0].equals("break"))           { pig.breakPig(); }
                else if (line[0].equals("addCoin"))         { 
                    int aux = IO.strToInt(line[1]);
                    if(aux == 10){
                        pig.addValuable(Coin.M10);
                    }else if(aux == 25){
                        pig.addValuable(Coin.M25);
                    }else if(aux == 50){
                        pig.addValuable(Coin.M50);
                    }else if(aux == 100){
                        pig.addValuable(Coin.M100);
                    }else{
                        IO.println("fail: invalid coin value");
                    }
                }
                else if (line[0].equals("addItem"))         { pig.addValuable(new Item(line[1], IO.strToDouble(line[2]), IO.strToInt(line[3]))); }
                else if (line[0].equals("extractItems"))    { IO.println(pig.getItems()); }
                else if (line[0].equals("extractCoins"))    { IO.println(pig.getCoins()); }
                else if (line[0].equals("show"))            { IO.println(pig); }
                else                                        { IO.println("fail: comando invalido"); }
            }catch(Exception e){
                String message = e.getMessage();
                if(message != null){
                    IO.println(message);
                }
            }
        }
    }
}