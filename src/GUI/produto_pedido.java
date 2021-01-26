/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Utilizador
 */
public class produto_pedido {
    private int id_produto;
    private String nome;
    private String tipo;
    private double preco;
    private int stock;

    public produto_pedido(int id_produto, String nome, String tipo, double preco, int stock) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.stock = stock;
    }

    public int getId_produto() {
        return id_produto;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public int getStock() {
        return stock;
    }
    
}
