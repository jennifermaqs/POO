
class Solver {
    public static void main (String[] arg) {
        Animal animal = new Animal("","");

        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                     }
            else if (args[0].equals("init"))  { animal = new Animal(args[1], args[2]);     }
            else if (args[0].equals("grow"))  { animal.envelhecer( IO.strToInt(args[1]) ); }
            else if (args[0].equals("noise")) { IO.println( animal.fazerBarulho() );       }
            else if (args[0].equals("show"))  { IO.println( animal.imprimir() );           }
            else                              { IO.println("fail: comando invalido");      }
        }
    }
}
