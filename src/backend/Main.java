package backend;
import backend.adapter.GlobalPayAdapter;
import backend.adapter.PayBrasilAdapter;
import backend.decorator.*;
import backend.singleton.NetworkManager;

public class Main {
    public static void main(String[] args) {

        float valor = 250;
        String dados_cartao = "123 345 678";
        String service = "service";

        System.out.print("\n=== SHOPFÁCIL - DEMONSTRAÇÃO DOS PADRÕES DE PROJETO ===\n");

        // -------------------
        //  ## SINGLETON ##
        // -------------------

        NetworkManager N1 = NetworkManager.getInstance();
        NetworkManager N2 = NetworkManager.getInstance();
        System.out.println("[SINGLETON] Instância 1: " + N1);
        System.out.println("[SINGLETON] Instância 2: " + N2);

        //N1.connect(service); //incrementa requisições realizadas, caso um teste seja desejado

        String stats = NetworkManager.getInstance().getStats();
        System.out.print(stats);
        System.out.println("[SINGLETON] São a mesma instância? " + N1.equals(N2)+"\n");

        // -------------------
        //  ## ADAPTER ##
        // -------------------

        PayBrasilAdapter pagamentoPB = new PayBrasilAdapter();
        pagamentoPB.processar_pagamento(valor, dados_cartao);

        GlobalPayAdapter pagamentoGP = new GlobalPayAdapter();
        pagamentoGP.processar_pagamento(valor, dados_cartao);

        System.out.println("[ADAPTER] Ambos os gateways utilizaram a mesma interface interna (processar_pagamento()).");

        //TODO
        // -------------------
        //  ## FACADE ##
        // -------------------


        // -------------------
        //  ## DECORATOR ##
        // -------------------

        Pedido pedido = new PedidoBase(5000, "Notebook");
        System.out.println("\n[DECORATOR] Pedido base:          " + pedido.getDescricao() + "            | R$" + pedido.getValor());

        pedido = new DescontoDecorator(pedido, 10);
        System.out.println("[DECORATOR] + Desconto 10%:       " + pedido.getDescricao() + "c/desc10%" + "   | R$" + pedido.getValor());

        pedido = new EmbrulhoDecorator(pedido, true);
        System.out.println("[DECORATOR] + Embrulho presente:  " + pedido.getDescricao() + "       | R$" + pedido.getValor());

        pedido = new FreteExpressDecorator(pedido, true);
        System.out.println("[DECORATOR] + FreteExpress:       " + pedido.getDescricao() + "   | R$" + pedido.getValor());

        //TODO
        // -------------------
        //  ## PROXY ##
        // -------------------
    }
}