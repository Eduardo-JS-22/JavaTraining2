package screenmatch.modelos;

import java.util.ArrayList;
import java.util.List;

public class Saldo {
    private int saldo;
    private int limite;
    private List<Produto> compras;

    public Saldo(int saldo) {
        this.saldo = saldo;
        this.limite = saldo;
        this.compras = new ArrayList<>();
    }

    public int getSaldo() {
        return saldo;
    }

    public List<Produto> getCompras() {
        return compras;
    }

    public boolean realizaCompra(Produto produto) {
        if (this.limite > produto.getValorProduto() && this.saldo > produto.getValorProduto()) {
            this.saldo -= produto.getValorProduto();
            this.compras.add(produto);
            return true;
        } else {
            return false;
        }
    }
}
