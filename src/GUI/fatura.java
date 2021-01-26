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
public class fatura {
    int id_fatura;
    double preco;
    String data;

    public fatura(int id_fatura, double preco, String data) {
        this.id_fatura = id_fatura;
        this.preco = preco;
        this.data = data;
    }

    public int getId_fatura() {
        return id_fatura;
    }

    public double getPreco() {
        return preco;
    }

    public String getData() {
        return data;
    }
    
}
