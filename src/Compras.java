import screenmatch.modelos.Produto;
import screenmatch.modelos.Saldo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Compras {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean opcao = true;

        System.out.println("Informe o valor do saldo:");
        Saldo saldo = new Saldo(read.nextInt());

        while (opcao) {
            System.out.println("\n0 - Sair, 1 - Comprar");
            int opcaoMenu = read.nextInt();

            switch (opcaoMenu) {
                case 1: {
                    System.out.println("\nProduto: ");
                    String nomeProduto = read.next();
                    System.out.println("\nValor: ");
                    int valorProduto = read.nextInt();
                    Produto produto = new Produto(nomeProduto, valorProduto);
                    boolean compraRealizada = saldo.realizaCompra(produto);
                    if (compraRealizada) {
                        System.out.println("\nSaldo: " + saldo.getSaldo());
                    } else {
                        System.out.println("\nSaldo insuficiente");
                        opcao = false;
                    }
                    break;
                }
                case 0: {
                    opcao = false;
                    System.out.println("""
                            ******************
                            Compras Realizadas
                            ******************
                            """);
                    Collections.sort(saldo.getCompras());
                    for (Produto compra : saldo.getCompras()) {
                        System.out.println("Produto: %s - Valor: %d".formatted(compra.getNomeProduto(), compra.getValorProduto()));
                    }
                    System.out.println("""
                            
                            ***************
                            Saldo Final: %d
                            ***************
                            """.formatted(saldo.getSaldo()));
                    break;
                }
                default: {
                    System.out.println("\nOpção Inválida");
                    break;
                }
            }
        }
    }
}
