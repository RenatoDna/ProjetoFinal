package pagamento;

public class PagamentoDebito implements I_Pagamento {
    private double valorCompra; 
    private double desconto;
    private double valorComDesconto;
    public PagamentoDebito(double valorCompra) {
        this.valorCompra = valorCompra; 
    }
    @Override
    public double getValorComDesconto() {
        return this.valorComDesconto;
    }
    //processo de pagamento
    @Override
    public void processoPagamento(double valorCompra) {
        this.desconto = this.valorCompra * 0.05;
        this.valorComDesconto = this.valorCompra - desconto;

    }
    @Override
    public String toString(){
        return "Processando pagamento de R$" + String.format("%.2f",this.valorCompra) + " com cartão de débito "
                +", Desconto aplicado: R$" + String.format("%.2f",desconto)
                +", Valor a pagar: R$" + String.format("%.2f",valorComDesconto);
    }
}