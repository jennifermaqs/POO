import java.util.*;

class Client {
    private String clientId;
    private ArrayList<Account> accounts;

    public Client(String clientId) {
        this.clientId = clientId;
        this.accounts = new ArrayList<>();
    } 

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        String str = "";
        str += clientId + " [" ;
        for(int i = 0; i < accounts.size()-1; i++){
        str += accounts.get(i).getAccId() + ", ";
        }
        str += accounts.get(accounts.size()-1).getAccId();
        str += "]\n";

        return str;
    }
}