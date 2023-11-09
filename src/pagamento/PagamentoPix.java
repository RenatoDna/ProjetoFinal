package pagamento;

public class PagamentoPix implements I_Pagamento{
    private double valorCompra; // Change from double valorCompra;
    private double desconto;
    double valorComDesconto;
    public PagamentoPix(double valorCompra) {
        this.valorCompra = valorCompra; // Update the class member variable
    }
    @Override
    public void processoPagamento(double valorCompra) {
        this.desconto = this.valorCompra * 0.10; // Use the class member variable
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
