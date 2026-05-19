package backend.facade;

import java.util.HashMap;

public class EstoqueService {

    public boolean verificarDisponibilidade(HashMap pedido1){
        System.out.println("    [ESTOQUE]   Produto disponível: Sim");
        return true;
    }
}
