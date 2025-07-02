package POO_2.Junkfood;

class Solver {
    public static void main (String[] args) {
        VendingMachine machine = null;

        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            

            if      ( line[0].equals("end")    )  {
                break;                               
            } else if ( line[0].equals("show")   )  {
                IO.println( machine.toString() );    
            } else if ( line[0].equals("init")   )  { 
                machine = new VendingMachine( IO.strToInt(line[1])); 
            } else if ( line[0].equals("set") )  { 
                int index = IO.strToInt(line[1]);
                String name = line[2];
                int qtd = IO.strToInt(line[3]);
                float price = IO.strToFloat(line[4]);
                if(machine.getSlot(index) != null) {
                    machine.setSlot(index, new Slot(name, price, qtd));
                } else {
                    IO.println("fail: indice nao existe");
                }
            } else if ( line[0].equals("limpar") )  {
                int index = IO.strToInt(line[1]);
                machine.clearSlot(index);
            } else if ( line[0].equals("dinheiro")  )  { 
                float value = IO.strToFloat(line[1]);
                machine.insertCash(value);
            } else if ( line[0].equals("troco") )  {
                float troco = machine.withdrawCash();
                IO.printf("voce recebeu %.2f RS\n", troco);
            } else if ( line[0].equals("comprar") )  { 
                int index = IO.strToInt(line[1]);
                machine.buyItem(index);
            } else { 
                IO.println("fail: comando invalido");                                                }
        }
    }
}

