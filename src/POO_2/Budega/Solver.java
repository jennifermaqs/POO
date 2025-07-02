package POO_2.Budega;

class Solver {
    public static void main(String[] args) {
        Market market = null;

        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            if (line[0].equals("end")) {
                break;
            } else if (line[0].equals("init")) {
                market = new Market(IO.strToInt(line[1]));
            } else if (line[0].equals("arrive")) {
                String name = line[1];
                market.arrive(new Person(name));
            } else if (line[0].equals("show")) {
                IO.println(market.toString());
            } else if (line[0].equals("call")) {
                market.call(IO.strToInt(line[1]));
            } else if (line[0].equals("finish")) {
                market.finish(IO.strToInt(line[1]));
            } else {
                IO.println("fail: comando invalido");
            }
        }
    }
}