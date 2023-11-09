package produto;

import entidades.TryPersonalizadoException;

public abstract class Produto {
    Acessorio acessorio;
    Brinquedo brinquedo;
    Eletronico eletronico;
    protected String nomeProduto;
    protected String categoriaProduto;
    protected double valorProduto;
    protected int quantidadeProduto;

    public Produto(String nomeProduto, String categoriaProduto, double valorProduto, int quantidadeProduto){
        this.nomeProduto= nomeProduto;
        this.categoriaProduto=categoriaProduto;
        this.valorProduto=valorProduto;
        this.quantidadeProduto=quantidadeProduto;
    }
    public Acessorio getAcessorio() {
        return acessorio;
    }
    public Brinquedo getBrinquedo() {
        return brinquedo;
    }
    public Eletronico getEletronico() {
        return eletronico;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public String getCategoriaProduto() {
        return categoriaProduto;
    }
    public double getValorProduto() {
        return valorProduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    public void setValorProduto(double valorProduto) {
        if (valorProduto < 0){
            throw new TryPersonalizadoException("O valor do produto não pode ser menor que 0!");
        }else{
            this.valorProduto = valorProduto;
        }
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        if (quantidadeProduto < 0){
            throw new TryPersonalizadoException("A quantidade não pode ser menor que 0! ");
        }else{
            this.quantidadeProduto = quantidadeProduto;
        }
    }
    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
    public void setBrinquedo(Brinquedo brinquedo) {
        this.brinquedo = brinquedo;
    }
    public void setEletronico(Eletronico eletronico) {
        this.eletronico = eletronico;
    }
    public void retiradaVenda(int quantidade){
        this.quantidadeProduto -= quantidade;
    }
    public void atualizarQuantidadeEstoque(int quantiaAdd){
        if (quantiaAdd < 0){
            throw new TryPersonalizadoException("A quantidade para atualização do estoque de "+getNomeProduto()+" não pode ser menor que 0!");
        }else{
            this.quantidadeProduto += quantiaAdd;
        }
    }
}

