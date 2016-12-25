/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;


import com.entity.Mantenimiento;
import com.entity.Maquina;
import com.entity.Tecnico;
import com.implDao.ImpldaoMantenimiento;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class MantenimientoController implements Serializable{

    //objetos de negocio
    private Mantenimiento mante=new Mantenimiento();
    Tecnico tecnicoEscogido=new Tecnico();
    Maquina maquielegida=new Maquina();
    
    
    //servicios
    ImpldaoMantenimiento impdp=new ImpldaoMantenimiento();
    //Variables 
    
    //Colecciones
    private List<Mantenimiento> mantenimientos=new LinkedList();
    
    
    
    
    public MantenimientoController() {
        listar();
    }

    public void registrar(){
        impdp.create(getMante());
        FacesUtil.addInfoMessage("Registrado con exito : "+getMante().getCodman());
        setMante(new Mantenimiento());
        listar();
        
    }
    
    public void listar(){
        setMantenimientos(impdp.selectAll());
    }
    
    
    public void elegirTecnico(Tecnico t){
        mante.setCodtec(t.getCodigo());
    }
    
    public void eliminar(Mantenimiento p){
        impdp.delete(p);
        listar();
    }
    
      
    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

   
    
    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    /**
     * @return the mante
     */
    public Mantenimiento getMante() {
        return mante;
    }

    /**
     * @param mante the mante to set
     */
    public void setMante(Mantenimiento mante) {
        this.mante = mante;
    }
    
}
