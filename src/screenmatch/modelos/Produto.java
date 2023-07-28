package screenmatch.modelos;

public class Produto implements Comparable<Produto> {
    private String nomeProduto;
    private int valorProduto;

    public Produto(String nomeProduto, int valorProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public int getValorProduto() {
        return valorProduto;
    }


    @Override
    public int compareTo(Produto outroProduto) {
        return Integer.valueOf(this.valorProduto).compareTo(outroProduto.valorProduto);
    }
}
