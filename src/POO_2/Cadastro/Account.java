import java.text.DecimalFormat;;

abstract class Account {
    protected double balance;
    private static int nextAccountId = 0;
    protected int accId;
    protected String clientId;
    protected String typeId;

    public Account(String clientId, String typeId) {
        this.balance = 0;
        this.accId = nextAccountId++;
        this.clientId = clientId;
        this.typeId = typeId;
    }

    public void deposit(double value) {
        this.balance += value; 
    }

    public void withdraw(double value) throws Exception{
        if(this.balance <  value){
            throw new BalanceException();
        }
        balance -= value;
    }

    public void transfer(Account other, double value)  throws Exception{
        if(this.getBalance() < value){
            throw new BalanceException();
        }
        other.deposit(value);
        balance -= value;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00"); 
        String str = accId + ":" + clientId + ":" + d.format(balance) + ":" + typeId + "\n";
        return str;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccId() {
        return accId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getTypeId() {
        return typeId;
    }

    public abstract void updateMonthly();
}