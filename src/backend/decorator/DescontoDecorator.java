package backend.decorator;

public class DescontoDecorator extends PedidoDecorator{

    private int perc_desconto;

    public DescontoDecorator(Pedido pedido, int perc_desconto) {
        super(pedido);
        this.perc_desconto = perc_desconto;
    }

    public float calc_desc(){
        float desconto = pedido.getValor() * (getPerc_desconto() / 100f);
        return desconto;
    }

    @Override
    public float getValor() {
        return (pedido.getValor() - calc_desc());
    }

    @Override
    public String getDescricao() {
        return pedido.getDescricao();
    }

    public int getPerc_desconto() {
        return perc_desconto;
    }
}
