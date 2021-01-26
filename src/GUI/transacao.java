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
public class transacao {
    int id;
    String nome;
    String data;
    String tempo;
    int qtd;

    public transacao(int id, String nome, String data, String tempo, int qtd) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.tempo = tempo;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getTempo() {
        return tempo;
    }

    public int getQtd() {
        return qtd;
    }
    
    
}
