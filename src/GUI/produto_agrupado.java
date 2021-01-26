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
public class produto_agrupado {
    String nome;
    int id;
    int qtd;

    public produto_agrupado(String nome, int id, int qtd) {
        this.nome = nome;
        this.id = id;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }
    
}
