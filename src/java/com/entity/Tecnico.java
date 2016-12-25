
package com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Tecnico {
 
    private String codigo;
    private String nombre;
    private String especialidad;

    public Tecnico() {
    }

    public Tecnico(String codigo, String nombre, String especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
  
    public static Tecnico load(ResultSet rs) throws SQLException {
       Tecnico tec= new Tecnico();
       tec.setCodigo(rs.getString(1));
       tec.setNombre(rs.getString(2));
       tec.setEspecialidad(rs.getString(3));
       return tec;
    }
   
    
    public String getCodigo() {
        return codigo;
    }

  
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public String getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
