package backend.adapter;

import java.util.HashMap;

public class GlobalPayService {

    public boolean charge(double amount, HashMap card_token){
        System.out.printf("Pagando R$%.2f via GlobalPayService... Cobrança realizada com sucesso.%n", amount);
        return true;
    }
}
