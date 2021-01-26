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
public class stock_enc {
    String nome;
    int id_produto;
    int qtd;

    public stock_enc(String nome ,int id_produto,  int qtd) {
        this.id_produto = id_produto;
        this.qtd = qtd;
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId_produto() {
        return id_produto;
    }

    public int getQtd() {
        return qtd;
    }
    
}
