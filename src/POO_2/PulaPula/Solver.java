package POO_2.PulaPula;

class Solver {
    public static void main(String[] args) {
        Trampoline trampoline = new Trampoline();

        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            if (line[0].equals("end")) {
                break;
            } else if (line[0].equals("arrive")) {
                String name = line[1];
                int age = IO.strToInt(line[2]);
                trampoline.arrive(new Kid(name, age));
            } else if (line[0].equals("show")) {
                IO.println(trampoline.toString());
            } else if (line[0].equals("remove")) {
                trampoline.removeKid(line[1]);
            } else if (line[0].equals("enter")) {
                trampoline.enter(); 
            } else if (line[0].equals("leave")) {
                trampoline.leave(); 
            } else {
                IO.println("fail: comando invalido");
            }
        }
    }
}