package ATMDesign.card;

public class CreditCardManager implements CardManager {
    public boolean validateCard(CardDetails cardDetails){
        return true;
    }
    public boolean validateWithdrawalDetails(CardDetails cardDetails, float amount, int transId){
        return true;
    }
    public void executeWithdrawal(int transId){

    }
}
