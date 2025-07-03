import java.util.*;

public class Solver {
    public static void main(String[] arg) {
        UFC ufc = new UFC();

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");

            try {
                if      (args[0].equals("end"))          { break; }
                else if (args[0].equals("addProf"))      { ufc.addFuncionario(new Professor(args[1], args[2])); }
                else if (args[0].equals("addSta"))       { ufc.addFuncionario(new STA(args[1], (int) number(args[2]))); }
                else if (args[0].equals("addTer"))       { ufc.addFuncionario(new Terceirizado(args[1], (int) number(args[2]), args[3])); }
                else if (args[0].equals("rm"))           { ufc.rmFuncionario(args[1]); }
                else if (args[0].equals("showAll"))      { print(ufc); }
                else if (args[0].equals("show"))         { println(ufc.getFuncionario(args[1])); }
                else if (args[0].equals("addDiaria"))    { ufc.getFuncionario(args[1]).addDiaria(); }
                else if (args[0].equals("setBonus"))     { ufc.setBonus((int) number(args[1])); }
                else                                     { println("fail: comando invalido"); }
            } catch (MsgException me) {
                println(me.getMessage());
                // e.printStackTrace(System.out);
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}
