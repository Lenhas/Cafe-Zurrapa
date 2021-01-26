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
public class mesa {
    int id_mesa;
    int lotacao_max;
    int lotacao_atual;
    int id_bar;
    
    public mesa(int id_mesa){
        this.id_mesa=id_mesa;
        lotacao_max=0;
        lotacao_atual=0;
         id_bar=0;
        
    
    }
    public mesa(int id_mesa,int lotacao_max,int lotacao_atual,int id_bar){
        this.id_mesa=id_mesa;
        this.lotacao_max=lotacao_max;
        this.lotacao_atual=lotacao_atual;
        this.id_bar=id_bar;
    
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public int getLotacao_max() {
        return lotacao_max;
    }

    public int getLotacao_atual() {
        return lotacao_atual;
    }

    public int getId_bar() {
        return id_bar;
    }
    
    
}
