package POO_2.Agiota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// class Comparador implements Comparator<Client> {
//     public int compare(Client c1, Client c2) {
//         return c1.getName().compareTo(c2.getName());
//     }
// }

class Agiota {
    private ArrayList<Client> aliveList;
    private ArrayList<Client> deathList;
    private ArrayList<Operation> aliveOper;
    private ArrayList<Operation> deathOper;
    private int nextOpId = 0;

    private int searchClient(String name) { 
        for (int i = 0; i < aliveList.size(); i++) {
            if(aliveList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    private void pushOperation(Client client, Label label, int value) {
        Operation oper = new Operation(this.nextOpId, client.getName(), label, value);
        this.aliveOper.add( oper );
        client.addOperation( oper );
        this.nextOpId++;
    }

    private void sortAliveList() {
        // this.aliveList.sort(); //para inteiros
        // Collections.sort (this.aliveList); //para inteiros

        // this.aliveList.sort( new Comparator<Client>() {
        //     public int compare(Client c1, Client c2) {
        //         return c1.getName().compareTo(c2.getName());
        //         // if (c1.getLimite() < c2.getLimite()) return -1;
        //         // else if (c1.getLimite() > c2.getLimite()) return 1;
        //         // else return 0;
        //     }
        // });

        // Collections.sort (this.aliveList, new Comparator<Client>() {
        //     public int compare(Client c1, Client c2) {
        //         return c1.getName().compareTo(c2.getName());
        //     }
        // });

        // Collections.sort (this.aliveList, new Comparador());
    }

    public Agiota() {
        this.aliveList = new ArrayList<>();
        this.deathList = new ArrayList<>();
        this.aliveOper = new ArrayList<>();
        this.deathOper = new ArrayList<>();
        this.nextOpId = 0;
    }

    public Client getClient(String name) throws Exception {
        int index = searchClient(name);
        if(index == -1) {
            for (Client c : deathList) {
                if(c.getName().equals(name)) {
                    return c;
                }
            }
            
            throw new Exception("fail: cliente nao existe");
        }
        return this.aliveList.get(index);
    }

    public void addClient(String name, int limite) throws Exception {
        if(searchClient(name) != -1) {
            throw new Exception("fail: cliente ja existe");
        }
        this.aliveList.add(new Client(name, limite));
        Collections.sort(this.aliveList, Comparator.comparing(Client::getName));
    }

    public void give(String name, int value) throws Exception {
        Client client = getClient(name);
        if(client.getBalance() + value > client.getLimite()) {
            throw new Exception("fail: limite excedido");
        }
        this.pushOperation(client, Label.GIVE, value);
    }

    public void take(String name, int value) throws Exception {
        Client client = getClient(name);
        this.pushOperation(client, Label.TAKE, value);
    }

    public void kill(String name) {
        int index = searchClient(name);
        if(index == -1) return;
        
        Client client = this.aliveList.remove(index);
        this.deathList.add(client);
        Collections.sort(this.deathList, Comparator.comparing(Client::getName));
        
        for(int i = this.aliveOper.size() - 1; i>= 0; i--) {
            Operation op = this.aliveOper.get(i);
            if(op.getName().equals(name)) {
                this.deathOper.add(op);
                this.aliveOper.remove(i);
            }
        }
        Collections.sort(this.deathOper, Comparator.comparing(Operation::getId));
    }

    public void plus() {
         for (Client client : this.aliveList) {
             int balance = client.getBalance();
             if(balance > 0) {
                 int interest =  (int) Math.ceil(0.1*balance);
                 this.pushOperation(client, Label.PLUS, interest);
             }
        }
          for (int i = this.aliveList.size() - 1; i >= 0; i--) {
              Client currentClient = this.aliveList.get(i);
                if ( currentClient.getBalance() > currentClient.getLimite() ) {
                     this.kill( currentClient.getName());
                }
            }
        // for (int i=0; i<this.aliveList.size(); i++) {
        //     Client client = this.aliveList.get(i);
        //     if ( client.getBalance() > client.getLimite() ) {
        //         this.kill( client.getName() );
        //         i--;
        //     }
        // }
    }

    @Override
    public String toString() {
        String ss = "";
        for ( Client client : this.aliveList ) {
            ss += ":) " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for ( Operation oper : this.aliveOper ) {
            ss += "+ " + oper + "\n";
        }
        for ( Client client : this.deathList ) {
            ss += ":( " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for(Client client : this.deathList) {
            for ( Operation oper : client.getOperations()) {
                if (deathOper.contains(oper)) {
                    ss += "- " + oper + "\n";   
                }
            }
        }
        return ss;
    }
}

