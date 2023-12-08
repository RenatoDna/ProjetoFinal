package produto;

import tratamento.TryPersonalizadoException;

public class Brinquedo extends Produto {
    int idadeRecomentdada;
    String material;
    String corBrinquedo;
    double tamanhoBrinquedo;

    public Brinquedo(String nomeProduto,String categoriaProduto,double valorProduto,int quantidadeProduto,int idadeRecomentdada,String material,String corBrinquedo,double tamanhoBrinquedo) {
        super(nomeProduto,categoriaProduto,valorProduto,quantidadeProduto);
        this.idadeRecomentdada=idadeRecomentdada;
        this.material=material;
        this.corBrinquedo=corBrinquedo;
        this.tamanhoBrinquedo=tamanhoBrinquedo;
    }
    public double getTamanhoBrinquedo() {
        return tamanhoBrinquedo;
    }
    public int getIdadeRecomentdada() {
        return idadeRecomentdada;
    }
    public String getMaterial() {
        return material;
    }
    public String getCorBrinquedo() {
        return corBrinquedo;
    }
    public void setIdadeRecomentdada(int idadeRecomentdada) {
        this.idadeRecomentdada = idadeRecomentdada;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setCorBrinquedo(String corBrinquedo) {
        this.corBrinquedo = corBrinquedo;
    }
    public void setTamanhoBrinquedo(double tamanhoBrinquedo) {
        this.tamanhoBrinquedo = tamanhoBrinquedo;
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
        +"\nIdade Recomendade: " + getIdadeRecomentdada() +" Anos"
        +"\nMaterial: " + getMaterial()  
        +"Cor: "+ getCorBrinquedo()
        +"Tamanho: "+getTamanhoBrinquedo();
    }
    
}
