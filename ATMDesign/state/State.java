package ATMDesign.state;

import ATMDesign.card.CardDetails;

public interface State {
    //move to ready
    int init();
    //
    boolean readCard(CardDetails cardDetails);
    boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId);
    void ejectCard();
    boolean cancelTransaction(int transId);
    float dispenseCash(int transId);

    ATMState getStateName();
}
