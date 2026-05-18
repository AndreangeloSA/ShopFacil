package backend.decorator;

public class PedidoBase implements Pedido{

    private float valor;
    String descricao;

    public PedidoBase(float valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public float getValor() {
        return this.valor;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
