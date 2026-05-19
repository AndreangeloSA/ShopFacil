package backend.adapter;

import java.util.HashMap;

public class PayBrasilService{

    public boolean realizarCobranca(double montante, HashMap cartao_info){
        System.out.println("Pagando " + montante + " via PayBrasil... Cobrança realizada com sucesso.");
        return true;
    }
}
