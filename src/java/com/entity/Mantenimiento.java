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
public class Mantenimiento {
    private String codman;
    private String dir;
    private String codtec;
    private String costo;
    private String codmaqui;

    public Mantenimiento() {
    }

    public Mantenimiento(String codman, String dir, String codtec, String costo, String maqui) {
        this.codman = codman;
        this.dir = dir;
        this.codtec = codtec;
        this.costo = costo;
        this.codmaqui = maqui;
    }

      
    public static Mantenimiento load(ResultSet rs) throws SQLException {
       Mantenimiento mante= new Mantenimiento();
       mante.setCodman(rs.getString(1));
       mante.setDir(rs.getString(2));
       mante.setCodtec(rs.getString(3));
       mante.setCosto(rs.getString(4));
       mante.setCodmaqui(rs.getString(5));
       return mante;
    }

    /**
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir) {
        this.dir = dir;
    }


    /**
     * @return the costo
     */
    public String getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    /**
     * @return the codman
     */
    public String getCodman() {
        return codman;
    }

    /**
     * @param codman the codman to set
     */
    public void setCodman(String codman) {
        this.codman = codman;
    }

    /**
     * @return the codtec
     */
    public String getCodtec() {
        return codtec;
    }

    /**
     * @param codtec the codtec to set
     */
    public void setCodtec(String codtec) {
        this.codtec = codtec;
    }

    /**
     * @return the codmaqui
     */
    public String getCodmaqui() {
        return codmaqui;
    }

    /**
     * @param codmaqui the codmaqui to set
     */
    public void setCodmaqui(String codmaqui) {
        this.codmaqui = codmaqui;
    }
    
    
}
