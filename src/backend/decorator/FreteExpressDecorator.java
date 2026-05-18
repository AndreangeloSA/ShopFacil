package backend.decorator;

public class FreteExpressDecorator extends PedidoDecorator{

    boolean frete;

    public FreteExpressDecorator(Pedido pedido, boolean frete) {
        super(pedido);
        this.frete = frete;
    }

    @Override
    public float getValor() {
        float frete_custo;
        if(this.frete){
            frete_custo= 30;
        }
        else{
            frete_custo = 0;
        }
        return pedido.getValor() + frete_custo;
    }

    @Override
    public String getDescricao() {
        String frete_status;
        if(this.frete){
            frete_status = "FreteExpress";
        }
        else{
            frete_status = "Sem FreteExpress";
        }
        return "...| " + frete_status;
    }
}
