package backend.adapter;

public interface Pagamento {

    void processar_pagamento(float valor, String dados_cartao);
}
