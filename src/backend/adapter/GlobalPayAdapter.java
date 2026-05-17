package backend.adapter;

public class GlobalPayAdapter implements Pagamento {

    private GlobalPayService globalPayService = new GlobalPayService();

    public GlobalPayAdapter(){
    }

    @Override
    public void processar_pagamento(float valor, String dados_cartao){
        globalPayService.charge(valor, dados_cartao);
        System.out.println("[ADAPTER] Pagando " + valor + " via GlobalPay... Charge approved.");
    }
}
