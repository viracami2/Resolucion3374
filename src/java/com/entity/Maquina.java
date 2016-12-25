/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Maquina {
    private String cod;
    private String tipo;
    private String descrip; //descripcion del problema

    public Maquina() {
    }

    public Maquina(String cod, String tipo, String descrip) {
        this.cod = cod;
        this.tipo = tipo;
        this.descrip = descrip;
    }
  
    public static Maquina load(ResultSet rs) throws SQLException {
       Maquina maqui= new Maquina();
       maqui.setCod(rs.getString(1));
       maqui.setTipo(rs.getString(2));
       maqui.setDescrip(rs.getString(3));
       return maqui;
    }
    
    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * @param descrip the descrip to set
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
}
