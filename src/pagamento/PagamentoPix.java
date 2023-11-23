package pagamento;

public class PagamentoPix implements I_Pagamento{
    private double valorCompra;
    private double desconto;
    double valorComDesconto;
    public PagamentoPix(double valorCompra) {
        this.valorCompra = valorCompra; 
    }
    @Override
    public void processoPagamento(double valorCompra) {
        this.desconto = this.valorCompra * 0.10; 
        this.valorComDesconto = this.valorCompra - desconto;
    }
    @Override
    public double getValorComDesconto() {
        return this.valorComDesconto;
    }
    @Override
    public String toString(){
        return "Processando pagamento de R$" + String.format("%.2f",this.valorCompra) + " com Pix "
                +", Desconto aplicado: R$" + String.format("%.2f",desconto)
                +", Valor a pagar: R$" + String.format("%.2f",valorComDesconto);
    }
}
