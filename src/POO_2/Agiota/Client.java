package POO_2.Agiota;

import java.util.ArrayList;

class Client {
    private String name;
    private int limite;
    ArrayList<Operation> operations;

    public Client(String name, int limite) {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    @Override
    public String toString() {
        String ss = this.name + " " + this.getBalance() + "/" + this.limite + "\n";
        for ( Operation oper : this.operations ) {
            ss += oper + "\n";
        }
        return ss;
    }

    public String getName() {
        return this.name;
    }
    public int getLimite() {
        return this.limite;
    }
    public ArrayList<Operation> getOperations() {
        return this.operations;
    }

    // public void addOperation(String name, Label label, int value) {
    //     this.operations.add( new Operation() );
    // }
    public void addOperation(Operation operation) {
        this.operations.add( operation );
    }
    //quanto esta devendo
    public int getBalance() {
        int balance = 0;
        for (Operation op : operations) {
            if(op.getLabel() == Label.GIVE || op.getLabel() == Label.PLUS) {
                balance += op.getValue();
            } else if (op.getLabel() == Label.TAKE) {
                balance -= op.getValue();
            }
        }
        return balance;
    }
}

