package backend.decorator;

public class EmbrulhoDecorator extends PedidoDecorator{

    boolean embrulho;

    public EmbrulhoDecorator(Pedido pedido, boolean embrulho) {
        super(pedido);
        this.embrulho = embrulho;
    }

    @Override
    public float getValor() {
        float embrulho_custo;
        if(this.embrulho){
            embrulho_custo = 15;
        }
        else{
            embrulho_custo = 0;
        }
        return pedido.getValor() + embrulho_custo;
    }

    @Override
    public String getDescricao() {
        String embrulho_status;
        if(this.embrulho){
            embrulho_status = "Embrulho";
        }
        else{
            embrulho_status = "Sem embrulho";
        }
        return "...| " + embrulho_status;
    }
}
