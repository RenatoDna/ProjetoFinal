package produto;

import entidades.TryPersonalizadoException;

public class Acessorio extends Produto{
    String tipoAcessorio;
    String material;
    String marca;
    public Acessorio(String nomeProduto,String descricaProduto,double valorProduto,int quantidadeProduto,String tipoAcessorio,String material,String marca){
        super(nomeProduto,descricaProduto,valorProduto,quantidadeProduto);
        this.tipoAcessorio=tipoAcessorio;
        this.material=material;
        this.marca=marca;
    }
    public String getTipoAcessorio() {
        return tipoAcessorio;
    }
    public String getMaterial() {
        return material;
    }
    public String getMarca() {
        return marca;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
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
        +"\nValor Produto: "+String.format("%.2f",getValorProduto())
        +"\nQuantidade: " + getQuantidadeProduto()
        +"\nTipo de Acessorio: " + getTipoAcessorio() 
        +"\nMaterial: " + getMaterial()  
        +"Marca: "+getMarca();
    }
}
 
