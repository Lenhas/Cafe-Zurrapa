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
public class encomenda_basico {
    int id;
    String data;
    int qtd;

    public encomenda_basico(int id, String data,int qtd) {
        this.id = id;
        this.data = data;
        this.qtd=qtd;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getQtd() {
        return qtd;
    }
    
    
    
}
