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
public class pedido {
    String nome;
    int qtd;

    public pedido(String nome, int qtd) {
        this.nome = nome;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }
    
}
