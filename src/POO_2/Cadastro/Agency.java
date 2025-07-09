import java.util.*;
class Agency {
    private Map<Integer, Account> accounts;
    private Map<String, Client> clients;

    private Account getAccount(int accountId) throws Exception{
        if(!accounts.containsKey(accountId)){
            throw new FoundException();
        }
        return accounts.get(accountId);
    }

    public Agency() {
        this.accounts = new HashMap<Integer,Account>();
        // this.clients = new HashMap<String,Client>();
        this.clients = new LinkedHashMap<String,Client>();
    }

    // cria uma conta para o cliente
    // cria um objeto cliente e insere no mapa de clientes
    // cria uma conta corrente e uma conta poupança e insere no mapa de contas
    // faz o vínculo cruzado colocando as contas dentro do objeto do cliente
    public void addClient(String clientId) {
        Client client = new Client(clientId);
        Account accountC = new CheckingAccount(clientId,"CC");
        client.addAccount(accountC);
        accounts.put(accountC.getAccId(), accountC);
        Account accountS = new SavingsAccount(clientId, "CP");
        client.addAccount(accountS);
        accounts.put(accountS.getAccId(), accountS);
        clients.put(clientId, client);
    }

    // procura pela conta usando o getAccount e realiza a operação de depósito
    // utiliza o método deposit da classe Account
    public void deposit(int accId, double value) throws Exception{
        getAccount(accId).deposit(value);
    }

    // procura pela conta e realiza a operação de saque
    // utiliza o método withdraw da classe Account
    public void withdraw(int accId, double value) throws Exception{
        getAccount(accId).withdraw(value);
    }

    // procura pela conta e realiza a operação de transferência
    // utiliza o método transfer da classe Account
    public void transfer(int fromAccId, int toAccId, double value) throws Exception{
        getAccount(fromAccId).transfer(getAccount(toAccId), value);;
    }

    // realiza a operação de atualização mensal em todas as contas
    public void updateMonthly() {
        accounts.forEach((key, account )-> account.updateMonthly());
    }

    @Override
    public String toString() {
        String s = "- Clients\n";
        for ( Client client : this.clients.values() ) {
            s += client;
        }
        s += "- Accounts\n";
        for ( Account acc : this.accounts.values() ) {
            s += acc;
        }
        return s;
    }
}