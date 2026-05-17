package backend;
import backend.adapter.GlobalPayAdapter;
import backend.adapter.PayBrasilAdapter;
import backend.singleton.NetworkManager;

public class Main {
    public static void main(String[] args) {

        float valor = 250;
        String dados_cartao = "123 345 678";
        String service = "service";

        System.out.print("\n=== SHOPFÁCIL - DEMONSTRAÇÃO DOS PADRÕES DE PROJETO ===\n");

        //SINGLETON

        NetworkManager N1 = NetworkManager.getInstance();
        NetworkManager N2 = NetworkManager.getInstance();
        //N1.connect(service);
        //connect incrementa requisições realizadas, caso um teste seja desejado
        String stats = NetworkManager.getInstance().getStats();
        System.out.print(stats);


        //ADAPTER
        PayBrasilAdapter pagamentoPB = new PayBrasilAdapter();
        pagamentoPB.processar_pagamento(valor, dados_cartao);

        GlobalPayAdapter pagamentoGP = new GlobalPayAdapter();
        pagamentoGP.processar_pagamento(valor, dados_cartao);

    }
}