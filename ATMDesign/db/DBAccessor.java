package ATMDesign.db;

import ATMDesign.card.TransactionStatus;
import ATMDesign.state.ATMState;


//In case of distributed ATM servers, the different servers can get api requests for transitions for the same machine id
//so we need to store a persistent state in the db
//make this class's methods static as we don't want many instances and need central place
public class DBAccessor {

    //FOR now, we are returning only one state but in actual we will return whatever state is stored corresponding to this machine id


    public static ATMState getATMState(String machineId) {
        return ATMState.READY;
    }
    public static void updateATMState(String machineId, ATMState state) {

    }
    public static int getNewTransaction(String machineId) {
        return 1;
    }
    public static boolean cancelTransaction(int transId) {
        return true;
    }
    public static float persistWithDetails(int transId, float amount, TransactionStatus  notApproved){
        return amount;
    }


}
