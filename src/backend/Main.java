package backend;
import backend.adapter.GlobalPayAdapter;
import backend.adapter.PayBrasilAdapter;
import backend.decorator.*;
import backend.facade.CheckoutFacade;
import backend.proxy.CatalogoProxy;
import backend.proxy.CatalogoReal;
import backend.singleton.NetworkManager;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        float valor = 250;
        String service = "service";

        HashMap pedido1 = new HashMap<>();
        pedido1.put("id", "01");
        pedido1.put("nome", "Notebook");
        pedido1.put("valor", 5000.00);

        HashMap dados_cartao = new HashMap<>();
        dados_cartao.put("numero", "1234 5678 1234");
        dados_cartao.put("token", "token_abc123");
        dados_cartao.put("titular", "Lewis Hamilton");

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
        System.out.print("[ADAPTER] ");
        pagamentoPB.processar_pagamento(valor, dados_cartao);

        GlobalPayAdapter pagamentoGP = new GlobalPayAdapter();
        System.out.print("[ADAPTER] ");
        pagamentoGP.processar_pagamento(valor, dados_cartao);

        System.out.println("[ADAPTER] Ambos os gateways utilizaram a mesma interface interna (processar_pagamento()).");

        // -------------------
        //  ## FACADE ##
        // -------------------

        CheckoutFacade checkout = new CheckoutFacade();
        PayBrasilAdapter gateway = new PayBrasilAdapter();
        checkout.finalizarCompra(gateway, pedido1, dados_cartao);

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

        // -------------------
        //  ## PROXY ##
        // -------------------

        CatalogoReal catalogoReal = new CatalogoReal();
        System.out.println("\n[PROXY] Buscando produto #42... " + catalogoReal.buscarProduto(42));

        CatalogoProxy catalogoProxy = new CatalogoProxy("is_admin");
        System.out.println("[PROXY] Buscando produto #42... " + catalogoProxy.buscarProduto(42));

        CatalogoProxy catalogoProxy2 = new CatalogoProxy("not_admin");
        System.out.println("[PROXY] Tentando produto especial sem permissão... " + catalogoProxy2.buscarProduto(42));
    }
}