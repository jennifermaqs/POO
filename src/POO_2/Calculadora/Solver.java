package POO_2.Calculadora;


class Solver {
    public static void main (String[] arg) {
        Calculator calculator = new Calculator(0);

        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                 }
            else if (args[0].equals("init"))  { calculator = new Calculator(IO.strToInt(args[1]));                   }
            else if (args[0].equals("charge")) { calculator.charge(IO.strToInt(args[1]));                         }
            else if (args[0].equals("sum")) { calculator.sum(IO.strToInt(args[1]), IO.strToInt(args[2]));                         }
            else if (args[0].equals("div")) { calculator.div( IO.strToInt(args[1]), IO.strToInt(args[2]) );   }
            else if (args[0].equals("show"))  { IO.println( calculator.toString() );        }
            else                              { IO.println("fail: comando invalido");  }
        }
    }
}

