package ATMDesign.state;

import ATMDesign.atm.ATM;
import ATMDesign.card.CardDetails;
import ATMDesign.card.CardManager;
import ATMDesign.card.CardManagerFactory;
import ATMDesign.db.DBAccessor;

public class CardReadingState implements State {
    private final ATM atm;
    public CardReadingState(ATM atm){
        this.atm = atm;
    }
    public int init(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //
    public boolean readCard(CardDetails cardDetails){
        CardManager cardManager= CardManagerFactory.getCardManager(cardDetails.getCardType());
        boolean result= cardManager.validateCard(cardDetails);
        if(result){
            this.atm.updateState(new WithdrawalDetailsReadingState(this.atm));
            return true;
        }
        else{
            this.atm.updateState(new ReadyState(this.atm));
            return false;
        }
    }
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId){
        throw new UnsupportedOperationException("Not supported yet.");

    }
    public void ejectCard(){
        throw new UnsupportedOperationException("Not supported yet.");

    }
    public boolean cancelTransaction(int transId){
        boolean res = DBAccessor.cancelTransaction(transId);
        return res;
    }
    public float dispenseCash(int transId){
        throw new UnsupportedOperationException("Not supported yet.");

    }
    public ATMState getStateName(){
        return ATMState.CARD_READING;
    }
}
