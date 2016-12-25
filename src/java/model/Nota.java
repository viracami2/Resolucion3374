/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Victor Castro
 */
public class Nota {
    private String nom_per;
    private String nom_asig;
    private String nota;

    public Nota(String nom_per, String nom_asig, String nota) {
        this.nom_per = nom_per;
        this.nom_asig = nom_asig;
        this.nota = nota;
    }

    public Nota() {
    }

    
    
    
    public String getNom_per() {
        return nom_per;
    }

    /**
     * @param nom_per the nom_per to set
     */
    public void setNom_per(String nom_per) {
        this.nom_per = nom_per;
    }

    /**
     * @return the nom_asig
     */
    public String getNom_asig() {
        return nom_asig;
    }

    /**
     * @param nom_asig the nom_asig to set
     */
    public void setNom_asig(String nom_asig) {
        this.nom_asig = nom_asig;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }
                             
}
