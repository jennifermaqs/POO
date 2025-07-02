package POO_2.Cinema;

class Solver {
    public static void main(String[] args) {
        Sala sala = null;

        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            if (line[0].equals("end")) {
                break;
            } else if (line[0].equals("init")) {
                int n = IO.strToInt(line[1]);
                sala = new Sala(n);
            }  else if (line[0].equals("show")) {
                if(sala == null) {
                    IO.println("[]");
                } else {
                    IO.println(sala.toString());
                }
            } else if (line[0].equals("reservar")) {
                String id = line[1];
                String fone = line[2];
                int ind = IO.strToInt(line[3]);
                sala.reservar(id, fone, ind);
            } else if (line[0].equals("cancelar")) {
                sala.cancelar(line[1]);
            } else {
                IO.println("fail: comando invalido");
            }
        }
    }
}