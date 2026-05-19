package backend.adapter;

import java.util.HashMap;

public class GlobalPayService {

    public boolean charge(double amount, HashMap card_token){
        System.out.println("Pagando " + amount + " via GlobalPay... Charge approved.");
        return true;
    }
}
