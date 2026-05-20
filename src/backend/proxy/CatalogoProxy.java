package backend.proxy;

import java.util.HashMap;
import java.util.Objects;

public class CatalogoProxy implements CatalogoService{

    private static HashMap<Integer, HashMap<String, Object>> CACHE = new HashMap<>();

    private CatalogoReal catalogoReal;

    @Override
    public String buscarProduto(int id, String autorizacao) {

        //realiza verificacao de autorizacao
        if(getCache() != null){
            if(getCache().containsKey(id)){
                boolean produto_especial = (boolean) getCache().get(id).get("especial");
                if(produto_especial && !Objects.equals(autorizacao, "is_admin")){
                    return "[CACHE] Tentando produto especial sem permissão... ACESSO NEGADO";
                }
                return "[CACHE] Retornando do cache: Produto encontrado";
            }
            return "[CACHE] Produto não encontrado";
        }

        //lazy initialization
        if(catalogoReal == null){
            catalogoReal = new CatalogoReal();
        }

        return catalogoReal.buscarProduto(id, autorizacao);
    }

    public static HashMap<Integer, HashMap<String, Object>> getCache() {
        return CACHE;
    }
}
