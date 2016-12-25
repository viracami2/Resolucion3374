/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;


import com.entity.Maquina;
import com.implDao.ImpldaoMaquina;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Virra
 */
@ManagedBean
@SessionScoped
public class MaquinaController implements Serializable{

    //objetos de negocio
    private Maquina maq=new Maquina();
    
    //servicios
    ImpldaoMaquina impdp=new ImpldaoMaquina();
    //Variables 
    
    //Colecciones
    private List<Maquina> maquinas=new LinkedList();
    
    
    public MaquinaController() {
        listar();
    }

    public void registrar(){
        impdp.create(getMaq());
  
        FacesUtil.addInfoMessage("Se registro la maquina con exito : "+getMaq().getCod());
        setMaq(new Maquina());
        listar();
    }
    
    public void listar(){
        setMaquinas(impdp.selectAll());
    }
    
    
    public void eliminar(Maquina p){
        impdp.delete(p);
        listar();
    }
    
    
    
   

    
    public List<Maquina> getMaquinas() {
        return maquinas;
    }

  
    public void setMaquinas(List<Maquina> maquina) {
        this.maquinas = maquina;
    }

    /**
     * @return the maq
     */
    public Maquina getMaq() {
        return maq;
    }

    /**
     * @param maq the maq to set
     */
    public void setMaq(Maquina maq) {
        this.maq = maq;
    }
    
}
