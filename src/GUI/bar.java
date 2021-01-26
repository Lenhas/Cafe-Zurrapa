/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


public class bar {
    private int id_bar;
    private String distrito, localidade,pais,codigo_postal;
    
    public bar(int id_bar,String distrito,String localidade,String pais,String codigo_postal){
        this.id_bar=id_bar;
        this.distrito=distrito;
        this.localidade=localidade;
        this.pais=pais;
        this.codigo_postal=codigo_postal;
    }

    public int getId_bar() {
        return id_bar;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }
    
}
