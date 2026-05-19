package backend.adapter;

import java.util.HashMap;

public interface Pagamento {

    boolean processar_pagamento(double valor, HashMap dados_Cartao);
}
