package backend.facade;

import backend.adapter.PayBrasilAdapter;

import java.util.HashMap;

public class PagamentoService {

    public boolean processarPag(PayBrasilAdapter gateway, double valor_total, HashMap dados_cartao){
        boolean resultado = gateway.processar_pagamento(valor_total, dados_cartao);
        return resultado;
    }
}
