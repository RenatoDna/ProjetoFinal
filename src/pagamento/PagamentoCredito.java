package pagamento;

public class PagamentoCredito implements I_Pagamento {
    private double valorCompra;
    private int parcelas;
    private double valorComDesconto;
    private double valorCompraJuros;
    private double valorJuros;
    public PagamentoCredito(double valorCompra, int parcelas) {
        this.valorCompra = valorCompra;
        this.parcelas = parcelas;
    }
    @Override
    public void processoPagamento(double valorCompra) {
        valorCompraJuros = this.valorCompra;
        valorJuros = 0;
        if (parcelas >= 3) {
            valorJuros = this.valorCompra * 0.03;
            valorCompraJuros += valorJuros;
        }
        this.valorComDesconto += valorCompraJuros;
    }
    @Override
    public double getValorComDesconto(){
        return this.valorComDesconto;
    }
    @Override
    public String toString(){
        return "Processando pagamento de R$" + String.format("%.2f",this.valorCompra) + " com cartão de crédito "
                +", Juros aplicados: R$" + String.format("%.2f",valorJuros)
                +", Valor a pagar: R$" + String.format("%.2f",valorCompraJuros);

    } 
}

