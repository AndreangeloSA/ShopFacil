package backend.facade;

import backend.adapter.PayBrasilAdapter;

import java.util.HashMap;

public class CheckoutFacade {

    EstoqueService estoqueService = new EstoqueService();
    FreteService freteService = new FreteService();
    NotaFiscalService notaFiscalService = new NotaFiscalService();
    PagamentoService pagamentoService = new PagamentoService();

    public void finalizarCompra(PayBrasilAdapter gateway, HashMap pedido1, HashMap dados_cartao){

        System.out.println("\n[FACADE] Iniciando checkout do pedido #" + pedido1.get("id") + "...");

        //VERIFICA ESTOQUE
        if(!estoqueService.verificarDisponibilidade(pedido1)){
            System.out.println("[ESTOQUE]    ERRO: Produto indisponível. Checkout cancelado.");
        }

        //CALCULA FRETE
        double custo_frete = freteService.calcularFrete(pedido1);
        System.out.printf("\n    [FRETE]     Custo calculado: R$%.2f", custo_frete);

        //PROCESSAR PAGAMENTO
        double valor_total = (double) pedido1.get("valor") + custo_frete;
        System.out.print("    [PAGAMENTO] ");
        System.out.println("    [PAGAMENTO] Processado com sucesso: " + pagamentoService.processarPag(gateway, valor_total, dados_cartao));

        ///EMITIR NOTA FISCAL
        System.out.println(notaFiscalService.emitirNotaFiscal(pedido1));
    }
}
