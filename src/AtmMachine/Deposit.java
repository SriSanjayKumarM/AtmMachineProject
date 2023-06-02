package AtmMachine;

import java.util.HashMap;

public class Deposit {

    HashMap<Integer, Double> avail_balance; //declaration

    public Deposit() {
        avail_balance = new HashMap<Integer, Double>();  //initialisation
        avail_balance.put(1111, 10002.00);
        avail_balance.put(2222, 20002.00);
        avail_balance.put(3333, 30002.00);
    }

    public Double avail_balance(int userPin) {
        return avail_balance.get(userPin);
    }
}

