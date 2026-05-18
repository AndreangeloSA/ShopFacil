package backend.proxy;

public class CatalogoProxy implements CatalogoService{

    private String autorizacao;
    private String cache = "not_null";

    private CatalogoReal catalogoReal;

    public CatalogoProxy(String autorizacao){
        this.autorizacao = autorizacao;
    }

    @Override
    public String buscarProduto(int id) {
        if(!autorizacao.equals("is_admin")){
            return "Acesso negado";
        }

        if(cache != null){
            return "[CACHE] Retornando do cache (sem acesso ao banco)";
        }

        if(catalogoReal == null){
            catalogoReal = new CatalogoReal();
        }

        cache = catalogoReal.buscarProduto(id);

        return cache;
    }
}
