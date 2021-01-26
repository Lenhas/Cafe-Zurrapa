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
public class pedido_final {
    int id_pedido;
    String data;
    String estado;

    public pedido_final(int id_pedido, String data, String estado) {
        this.id_pedido = id_pedido;
        this.data = data;
        this.estado = estado;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public String getData() {
        return data;
    }

    public String getEstado() {
        return estado;
    }
    
    
}
