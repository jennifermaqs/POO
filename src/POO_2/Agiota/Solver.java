package POO_2.Agiota;
public class Solver {
    public static void main(String[] arg) {
        System.out.println("side_by_side=080");
        
        Agiota agiota = new Agiota();

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

        try {
            if      (line[0].equals("end"))     { break; }
            else if (line[0].equals("init"))    { agiota = new Agiota(); }
            else if (line[0].equals("show"))    { IO.print(agiota); }
            else if (line[0].equals("showCli")) { IO.print( agiota.getClient( line[1] ) ); }
            else if (line[0].equals("addCli"))  { agiota.addClient( line[1], IO.strToInt(line[2]) ); }
            else if (line[0].equals("give"))    { agiota.give( line[1], IO.strToInt(line[2]) ); }
            else if (line[0].equals("take"))    { agiota.take( line[1], IO.strToInt(line[2]) ); }
            else if (line[0].equals("kill"))    { agiota.kill( line[1] ); }
            else if (line[0].equals("plus"))    { agiota.plus(); }
            else                                { IO.println("fail: comando invalido"); }
            
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    }
}
}

