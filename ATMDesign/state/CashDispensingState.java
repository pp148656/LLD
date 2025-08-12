package ATMDesign.state;

import ATMDesign.atm.ATM;
import ATMDesign.card.CardDetails;
import ATMDesign.card.CardManagerFactory;
import ATMDesign.card.CardType;
import ATMDesign.db.DBAccessor;

public class CashDispensingState implements State{
    private final ATM atm;
    public CashDispensingState(ATM atm){
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean cancelTransaction(int transId){

        DBAccessor.cancelTransaction(transId);
        this.atm.updateState(new CashDispensingState(this.atm));

        return true;
    }
    public float dispenseCash(int transId){
        //we somehow know how much the cardType too
        CardType cardType=null;
        //we also missed the actual carddetails so that we could reduce the amount 
        CardManagerFactory.getCardManager(cardType)
                .executeWithdrawal(transId);
        this.atm.updateState(new CardEjectingState(this.atm));

        return 1;
    }

    public ATMState getStateName(){
        return ATMState.CASH_DISPENSING;
    }

}
