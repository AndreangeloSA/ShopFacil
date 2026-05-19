package backend.adapter;

import java.util.HashMap;

public class GlobalPayAdapter implements Pagamento {

    private GlobalPayService globalPayService = new GlobalPayService();

    public GlobalPayAdapter(){
    }

    @Override
    public boolean processar_pagamento(double valor, HashMap dados_Cartao){
        globalPayService.charge(valor, dados_Cartao);
        return true;
    }
}
