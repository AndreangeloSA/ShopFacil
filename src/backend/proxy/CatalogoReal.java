package backend.proxy;

public class CatalogoReal implements CatalogoService{

    private int [] listaProdutos = {42};

    @Override
    public String buscarProduto(int id) {

        for (int produto : listaProdutos){
            if (produto == id){
                return "[DB] Consultando banco de dados.";
            }
        }
        return "[DB] Produto não encontrado";
    }
}

