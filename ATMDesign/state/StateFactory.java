package ATMDesign.state;

import ATMDesign.atm.ATM;

public class StateFactory {
    public State getState(ATMState atmState, ATM atm) {
        switch (atmState) {
            case READY: return new ReadyState(atm);
            case CARD_READING: return new CardReadingState(atm);
            case WITHDRAWAL_DETAILS_READING: return new WithdrawalDetailsReadingState(atm);
            case CARD_EJECTING: return new CardEjectingState(atm);
            case CASH_DISPENSING: return new CashDispensingState(atm);
            default: return null;
        }
    }
}
