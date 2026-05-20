package backend.adapter;

import java.util.HashMap;

public class PayBrasilService{

    public boolean realizarCobranca(double montante, HashMap cartao_info){
        System.out.printf("Pagando R$%.2f via PayBrasil... Cobrança realizada com sucesso.%n", montante);
        return true;
    }
}
