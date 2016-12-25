/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.entity.Tecnico;
import com.implDao.ImpldaoTecnico;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class TecnicoController implements Serializable{

    //objetos de negocio
    //hay que encapsularlo para que funcione
    private Tecnico tec=new Tecnico();
    
    //servicios
    ImpldaoTecnico impdp=new ImpldaoTecnico();
    //Variables 
    
    //Colecciones
    private List<Tecnico> tecnicos=new LinkedList();
    
    
    
    /**
     * Creates a new instance of ProductoController
     */
   
    public TecnicoController() {
        listar();
    }

    public void registrar(){
        impdp.create(getTec());
      
        FacesUtil.addInfoMessage("Se registro con exito el tecnico : "+getTec().getNombre());
      setTec(new Tecnico());
        listar();
    }
    
    public void listar(){
        setTecnicos(impdp.selectAll());
    }
    
    
    public void eliminar(Tecnico p){
        impdp.delete(p);
        listar();
    }
    
 
    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

   
    public void setTecnicos(List<Tecnico> tecc) {
        this.tecnicos = tecc;
    }

   
    public Tecnico getTec() {
        return tec;
    }

   
    public void setTec(Tecnico tec) {
        this.tec = tec;
    }
    
}
