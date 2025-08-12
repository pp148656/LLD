package ATMDesign.state;

import ATMDesign.atm.ATM;
import ATMDesign.card.CardDetails;
import ATMDesign.db.DBAccessor;

public class ReadyState implements State {
    private final ATM atm;
    public ReadyState(ATM atm) {
        this.atm = atm;
    }
    public int init(){
       int transId= DBAccessor.getNewTransaction(this.atm.getMachineId());
        if (transId == 0)
            throw new RuntimeException("Unable to start txn");
        this.atm.updateState(new CardReadingState(this.atm));
        return transId;
    }
    //
    public boolean readCard(CardDetails cardDetails){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void ejectCard(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean cancelTransaction(int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public float dispenseCash(int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ATMState getStateName(){
        return ATMState.READY;
    }

}
