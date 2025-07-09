public class CheckingAccount extends Account{
    private double monthlyFee;

    CheckingAccount(String clientId, String typeId){
        super(clientId, typeId);
        monthlyFee = 20;
    }

    @Override
    public void updateMonthly(){
        deposit(-monthlyFee);
    }
}