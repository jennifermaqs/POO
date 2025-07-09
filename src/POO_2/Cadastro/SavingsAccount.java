public class SavingsAccount extends Account{
    private double monthlyInterest;

    SavingsAccount(String clientId, String typeId){
        super(clientId, typeId);
        this.monthlyInterest = 0.01;
    }

    @Override
    public void updateMonthly(){
        deposit(getBalance() * monthlyInterest);
    }
}