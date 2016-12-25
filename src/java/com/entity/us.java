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
 * @author Victor Castro
 */
public class us {

    private String tipo_iden;
    private String numero_iden;
    private String cod_enti_adm;
    private String tipo_usu;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;
    private String edad;
    private String medida_edad;
    private String sexo;
    private String cod_depar;
    private String cod_muni;
    private String zona_residencia;

    /**
     * @return the tipo_iden
     */
    public static us load(ResultSet rs) throws SQLException {
       us us= new us();
       us.setTipo_iden(rs.getString(1));
       us.setNumero_iden(rs.getString(2));
       us.setCod_enti_adm(rs.getString(3));
       
       us.setTipo_usu(rs.getString(4));
       us.setApellido1(rs.getString(5));
       us.setApellido2(rs.getString(6));
       us.setNombre1(rs.getString(7));
       us.setNombre2(rs.getString(8));
       us.setEdad(rs.getString(9));
       us.setMedida_edad(rs.getString(10));
       us.setSexo(rs.getString(11));
       us.setCod_depar(rs.getString(12));
       us.setCod_muni(rs.getString(13));
       us.setZona_residencia(rs.getString(14));
       return us;
    }
    
    
    
    
    public String getTipo_iden() {
        return tipo_iden;
    }

    /**
     * @param tipo_iden the tipo_iden to set
     */
    public void setTipo_iden(String tipo_iden) {
        this.tipo_iden = tipo_iden;
    }

    /**
     * @return the numero_iden
     */
    public String getNumero_iden() {
        return numero_iden;
    }

    /**
     * @param numero_iden the numero_iden to set
     */
    public void setNumero_iden(String numero_iden) {
        this.numero_iden = numero_iden;
    }

    /**
     * @return the cod_enti_adm
     */
    public String getCod_enti_adm() {
        return cod_enti_adm;
    }

    /**
     * @param cod_enti_adm the cod_enti_adm to set
     */
    public void setCod_enti_adm(String cod_enti_adm) {
        this.cod_enti_adm = cod_enti_adm;
    }

    /**
     * @return the tipo_usu
     */
    public String getTipo_usu() {
        return tipo_usu;
    }

    /**
     * @param tipo_usu the tipo_usu to set
     */
    public void setTipo_usu(String tipo_usu) {
        this.tipo_usu = tipo_usu;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the medida_edad
     */
    public String getMedida_edad() {
        return medida_edad;
    }

    /**
     * @param medida_edad the medida_edad to set
     */
    public void setMedida_edad(String medida_edad) {
        this.medida_edad = medida_edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the cod_depar
     */
    public String getCod_depar() {
        return cod_depar;
    }

    /**
     * @param cod_depar the cod_depar to set
     */
    public void setCod_depar(String cod_depar) {
        this.cod_depar = cod_depar;
    }

    /**
     * @return the cod_muni
     */
    public String getCod_muni() {
        return cod_muni;
    }

    /**
     * @param cod_muni the cod_muni to set
     */
    public void setCod_muni(String cod_muni) {
        this.cod_muni = cod_muni;
    }

    /**
     * @return the zona_residencia
     */
    public String getZona_residencia() {
        return zona_residencia;
    }

    /**
     * @param zona_residencia the zona_residencia to set
     */
    public void setZona_residencia(String zona_residencia) {
        this.zona_residencia = zona_residencia;
    }
}
