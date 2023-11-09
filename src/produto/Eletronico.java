package produto;

import entidades.TryPersonalizadoException;

public class Eletronico extends Produto{
    String voltagem;
    String modelo;
    double tamanhoEletronico;
    String marca;

    public Eletronico(String nomeProduto,String categoriaProduto,double valorProduto,int quantidadeProduto,String voltagem,String modelo,double tamanhoEletronico,String marca){
        super(nomeProduto,categoriaProduto,valorProduto,quantidadeProduto);
        this.voltagem=voltagem;
        this.modelo=modelo;
        this.tamanhoEletronico=tamanhoEletronico;
        this.marca=marca;
    }
    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setTamanhoEletronico(double tamanhoEletronico) {
        this.tamanhoEletronico = tamanhoEletronico;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getVoltagem() {
        return voltagem;
    }
    public String getModelo() {
        return modelo;
    }
    public double getTamanhoEletronico() {
        return tamanhoEletronico;
    }
    public String getMarca() {
        return marca;
    }
    @Override
    public void setQuantidadeProduto(int quantidadeProduto) {
        if (quantidadeProduto < 0){
            throw new TryPersonalizadoException("A quantidade em estoque de "+getNomeProduto()+" não pode ser menor que 0!");
        }else{
            this.quantidadeProduto = quantidadeProduto;
        }
    }
    @Override
    public void atualizarQuantidadeEstoque(int quantiaAdd){
        if (quantiaAdd < 0){
            throw new TryPersonalizadoException("A quantidade para atualização do estoque de "+getNomeProduto()+" não pode ser menor que 0!");
        }else{
            this.quantidadeProduto += quantiaAdd;
        }
    }
    @Override
    public void retiradaVenda(int quantia){
            this.quantidadeProduto -= quantia;
    }
    @Override
    public String toString() {
        return "\nNome: " + getNomeProduto() 
        +"\nDescrição: " + getCategoriaProduto() 
        +"\nValor Produto:"+String.format("%.2f",getValorProduto())
        +"\nQuantidade: " + getQuantidadeProduto()
        +"\nVoltagem: " + getVoltagem() 
        +"\nModelo: " + getModelo()  
        +"Tamanho: "+ getTamanhoEletronico()
        +"Marca: "+getMarca();
    }
}
