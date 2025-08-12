package ATMDesign.atm;

import ATMDesign.card.CardDetails;
import ATMDesign.db.DBAccessor;
import ATMDesign.state.ATMState;
import ATMDesign.state.State;
import ATMDesign.state.StateFactory;

public class ATM {
    private State atmState;
    private final String machineId;
    public ATM(String machineId) {
        this.machineId = machineId;
        this.atmState = new StateFactory().getState((DBAccessor.getATMState(this.machineId)), this);
    }
    public void updateState(State state) {
        this.atmState = state;
        DBAccessor.updateATMState(this.machineId,state.getStateName());
    }

    public int init(){
       return this.atmState.init();
    }
    public boolean readCard(CardDetails cardDetails,int transId) {
        return this.atmState.readCard(cardDetails);
    }
    public boolean readWithdrawDetails(CardDetails cardDetails, int transId, float amount) {
        return this.atmState.readWithdrawalDetails(cardDetails,amount,transId);
    }
    public float dispenseCash(int transId) {
        return this.atmState.dispenseCash(transId);
    }
    public boolean cancelTransaction(int transId) {
        return this.atmState.cancelTransaction(transId);
    }
    public void ejectCard() {
        this.atmState.ejectCard();
    }

    public String getMachineId() {
        return machineId;
    }
}
