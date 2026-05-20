package backend.proxy;

import java.util.HashMap;
import java.util.Objects;

public class CatalogoReal implements CatalogoService{

    private static HashMap<Integer, HashMap<String, Object>> BANCO_DE_DADOS = new HashMap<>();

    //simula banco de dados
    public void BancoDeDados() {

        HashMap<String, Object> produto1 = new HashMap<>();
        produto1.put("id", 1);
        produto1.put("nome", "Notebook Dell");
        produto1.put("preco", 3500.00);
        produto1.put("especial", false);

        HashMap<String, Object> produto2 = new HashMap<>();
        produto2.put("id", 42);
        produto2.put("nome", "Camisa Polo");
        produto2.put("preco", 89.90);
        produto2.put("especial", false);

        HashMap<String, Object> produto3 = new HashMap<>();
        produto3.put("id", 69);
        produto3.put("nome", "Smartphone Samsung");
        produto3.put("preco", 1999.00);
        produto3.put("especial", false);

        HashMap<String, Object> produto4 = new HashMap<>();
        produto4.put("id", 16);
        produto4.put("nome", "Edição Limitada VIP");
        produto4.put("preco", 9999.00);
        produto4.put("especial", true);

        BANCO_DE_DADOS.put(1, produto1);
        BANCO_DE_DADOS.put(42, produto2);
        BANCO_DE_DADOS.put(69, produto3);
        BANCO_DE_DADOS.put(16, produto4);
    }

    public CatalogoReal(){
        BancoDeDados();
    }

    @Override
    public String buscarProduto(int id, String autorizacao) {
        // verifica se produto existe
        if (!BANCO_DE_DADOS.containsKey(id)) {
            return "[DB] Produto não encontrado";
        }

        // verifica se é especial
        boolean produtoEspecial =
                (boolean) BANCO_DE_DADOS.get(id).get("especial");

        // bloqueia acesso
        if (produtoEspecial && !Objects.equals(autorizacao, "is_admin")) {
            return "[PROXY] Produto especial sem permissão... ACESSO NEGADO";
        }

        // adiciona ao cache
        CatalogoProxy.getCache().put(id, BANCO_DE_DADOS.get(id));

        return "[DB] Consultando banco de dados: Produto encontrado";
    }
}

