package pagamento;

public class PagamentoDinheiro implements I_Pagamento{
    private double valorCompra;
    private double valorComDesconto;
    private double desconto;
    public PagamentoDinheiro(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public double valorCompraDesconto(double valorComDesconto){
        this.valorComDesconto = valorComDesconto;
        return valorComDesconto;
    }
    @Override
    public double getValorComDesconto() {
        return this.valorComDesconto;
    }
    @Override
    public void processoPagamento(double valorCompra) {
        desconto = this.valorCompra * 0.1;
        this.valorComDesconto = this.valorCompra - desconto;
        System.out.println();
    }
    @Override
    public String toString(){
        return "Processando pagamento de R$" + String.format("%.2f",this.valorCompra) + " com dinheiro"
                +", Desconto aplicado: R$" + String.format("%.2f",desconto)
                +", Valor a pagar: R$" + String.format("%.2f",this.valorComDesconto);
    }
}
