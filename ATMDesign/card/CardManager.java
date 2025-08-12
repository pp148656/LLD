package ATMDesign.card;


// delegate responsibility of validation and also there are different mechanisms of validation
public interface CardManager {
    public boolean validateCard(CardDetails cardDetails);
    public boolean validateWithdrawalDetails(CardDetails cardDetails, float amount, int transId);

    //we actually needed the cardDetails and the amount also here
    //maybe we had the amount with transacetion id but we indeed needed the cardDetails here
    //which means we missed it in cashDispenser state
    public void executeWithdrawal(int transId);
}
