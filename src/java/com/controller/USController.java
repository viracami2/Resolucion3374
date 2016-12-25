/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;
import com.entity.us;
import com.implDao.ImpldaoUS;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class USController implements Serializable{

    //objetos de negocio
    //hay que encapsularlo para que funcione
    private  us us=new us();
    
    //servicios
    ImpldaoUS impdp=new ImpldaoUS();
    //Variables 
    
    //Colecciones
    private List<us> uss=new LinkedList();
    
    
    
    /**
     * Creates a new instance of ProductoController
     */
   
    public USController() {
      
    }

    public void registrar() throws SQLException{
        impdp.create(getUs());
      
        FacesUtil.addInfoMessage("Se registro con exito el us : "+getUs().getNombre1());
      setUs(new us());
        listar();
    }
    
    public void listar(){
        setUss(impdp.selectAll());
    }
    
    
    public void eliminar(us p){
        impdp.delete(p);
        listar();
    }

    public void generar() throws IOException{
        //cuando listamos tenemos la variable uss con los datos cargados
        listar();
        String ruta = "E:\\Archivos\\us.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        
       // try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            System.out.println("!!!!!!!tamado de lista "+uss.size());
            for (int i = 0; i < uss.size(); i++) {
                
           bw.write(uss.get(i).getTipo_iden()+","+
                    uss.get(i).getNumero_iden()+","+
                    uss.get(i).getCod_enti_adm()+","+
                    uss.get(i).getTipo_usu()+","+
                    uss.get(i).getApellido1()+","+
                    uss.get(i).getApellido2()+","+
                    uss.get(i).getNombre1()+","+
                    uss.get(i).getNombre2()+","+
                    uss.get(i).getEdad()+","+
                    uss.get(i).getMedida_edad()+","+
                    uss.get(i).getSexo()+","+
                    uss.get(i).getCod_depar()+","+
                    uss.get(i).getCod_muni()+","+
                    uss.get(i).getZona_residencia()
                    );
           bw.newLine();
                    }
        }
        bw.close();
    //}catch(Exception ex){System.out.println(ex);    }
    }
    
    
    
    /**
     * @return the us
     */
    public us getUs() {
        return us;
    }

    /**
     * @param us the us to set
     */
    public void setUs(us us) {
        this.us = us;
    }

    /**
     * @return the uss
     */
    public List<us> getUss() {
        return uss;
    }

    /**
     * @param uss the uss to set
     */
    public void setUss(List<us> uss) {
        this.uss = uss;
    }
        }
