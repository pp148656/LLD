package ATMDesign.state;

import ATMDesign.atm.ATM;
import ATMDesign.card.CardDetails;

public class CardEjectingState implements State{

    private final ATM atm;
    public CardEjectingState(ATM atm){
        this.atm = atm;
    }
    public int init(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //
    public boolean readCard(CardDetails cardDetails){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void ejectCard(){
        this.atm.updateState(new ReadyState(atm));
    }
    public boolean cancelTransaction(int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public float dispenseCash(int transId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ATMState getStateName() {
        return ATMState.CARD_READING;
    }
}
