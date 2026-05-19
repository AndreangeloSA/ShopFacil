package backend.adapter;

import java.util.HashMap;

public class PayBrasilAdapter implements Pagamento {

    private PayBrasilService payBrasilService = new PayBrasilService();

    public PayBrasilAdapter(){
    }

    @Override
    public boolean processar_pagamento(double valor, HashMap dados_Cartao){
        payBrasilService.realizarCobranca(valor, dados_Cartao);
        return true;
    }
}
