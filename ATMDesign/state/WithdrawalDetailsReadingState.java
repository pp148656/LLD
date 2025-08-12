package ATMDesign.state;

import ATMDesign.atm.ATM;
import ATMDesign.card.*;
import ATMDesign.db.DBAccessor;

public class WithdrawalDetailsReadingState implements State{
    private final ATM atm;
    public WithdrawalDetailsReadingState(ATM atm){
        this.atm = atm;
    }
    public int init(){
        return 0;
    }
    //
    public boolean readCard(CardDetails cardDetails){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId){
        CardType cardType = cardDetails.getCardType();
        CardManager cardManager= CardManagerFactory.getCardManager(cardType);
        boolean result=cardManager.validateWithdrawalDetails(cardDetails,amount,transId);
        if(result){
            this.atm.updateState(new CashDispensingState(this.atm));
            //we want the record to be stored in db for each transId
            DBAccessor
                    .persistWithDetails(transId, amount, TransactionStatus.APPROVED);
        }
        else{
            this.atm.updateState(new CardEjectingState(this.atm));
            DBAccessor
                    .persistWithDetails(transId, amount, TransactionStatus.NOT_APPROVED);
        }
        return result;
    }
    public void ejectCard(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean cancelTransaction(int transId){
        DBAccessor.cancelTransaction(transId);
        this.atm.updateState(new CardEjectingState(this.atm));
        return true;
    }
    public float dispenseCash(int transId){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public ATMState getStateName(){
        return ATMState.WITHDRAWAL_DETAILS_READING;
    }
}
