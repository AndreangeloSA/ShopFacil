package backend.adapter;

public class PayBrasilAdapter implements Pagamento {

    private PayBrasilService payBrasilService = new PayBrasilService();

    public PayBrasilAdapter(){
    }

    @Override
    public void processar_pagamento(float valor, String dados_cartao){
        payBrasilService.realizarCobranca(valor, dados_cartao);
        System.out.println("[ADAPTER] Pagando " + valor + " via PayBrasil... Cobrança realizada com sucesso.");
    }
}
