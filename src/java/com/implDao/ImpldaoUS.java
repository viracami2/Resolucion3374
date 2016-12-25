
package com.implDao;


import com.dao.IDao;

import com.entity.us;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Usuario
 */
public class ImpldaoUS implements IDao<us> {
private DataSource dataSource=DataUtil.getDs();
private transient Connection con;
private String jdbcDriver="org.postgresql.Driver";

	private String databaseURL="jdbc:postgresql://localhost:5432/Resolucion";
	private String user;
	private String password="1234";

    
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Connection getConexion(){
	 return con;
	}	

	
    
    
public void connect() throws SQLException{
            
		if(this.isConnect())
		   System.out.println("Ya Esta Conectado");
		if(jdbcDriver==null)
	           System.out.println("No hay jdbcDriver cargado");
	    if(databaseURL==null)
	      System.out.println("No hay URL cargado en base de datos");

	    try{
	    	Class.forName(jdbcDriver).newInstance();
	    }catch(Exception e){
	    	System.out.println("La Clase"+ jdbcDriver + "No se pudo cargar");
	    }

	 //   con=DriverManager.getConnection(this.databaseURL,this.user,this.password);
             con=DriverManager.getConnection(this.databaseURL,"postgres","1234");
	}


	public void disconnect(){
	 
    if(con!=null){
	 		try{
	 			con.close();
	 		}catch (SQLException ignore){}
	 		finally {
	 			con=null;
	 		}
	 	}
	}

	public boolean isConnect(){
	 	if(con==null)
	 	   return false;

	 	   else
	 	   return true;
	}
	
 
   
  
    @Override
    public void create(us entity)throws SQLException {
      
        try {       
          
            connect();   
           //
            if(!isConnect())
	 	    System.out.println("sin conexion");

	
	 	PreparedStatement pstmt=null;

	 	            //
            
	// pstmt=con.prepareStatement("INSERT INTO us (tipo_iden,numero_iden,cod_enti_adm,tipo_usu,apellido_1,apellido_2,nombre_1,nombre_2,edad,medida_edad,sexo,cod_dep,cod_mun,zona_residencia) VALUES ('cc','1102231','123456','1','castro','mier','victor','raul','23','1','m','45','345','u')");		

	 pstmt=con.prepareStatement("insert into us values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//pstmt=con.prepareStatement("insert into us(tipo_iden,numero_iden,cod_enti_adm,tipo_usu,apellido1,apellido2,nombre1,nombre2,edad,medida_edad,sexo,cod_dep,cod_mun,zona_residencia)");	 	

                        pstmt.setString(1,entity.getTipo_iden());
                        pstmt.setString(2,entity.getNumero_iden());
                        pstmt.setString(3,entity.getCod_enti_adm());
                        pstmt.setString(4,entity.getTipo_usu());
                        pstmt.setString(5,entity.getApellido1());
                        pstmt.setString(6,entity.getApellido2());
                        pstmt.setString(7,entity.getNombre1());
                        pstmt.setString(8,entity.getNombre2());
                        pstmt.setString(9,entity.getEdad());
                        pstmt.setString(10,entity.getMedida_edad());
                        pstmt.setString(11,entity.getSexo());
                        pstmt.setString(12,entity.getCod_depar());
                        pstmt.setString(13,entity.getCod_muni());
                        pstmt.setString(14,entity.getZona_residencia());
                        

	 		pstmt.executeUpdate();
    
                        if(pstmt!=null)	 	
                               pstmt.close();
                    
		} catch (SQLException ex) { 
                    System.out.println(ex);
                    Logger.getLogger(ImpldaoUS.class.getName()).log(Level.SEVERE, null, ex);
                        }finally {         
	 	}
    
        
    }

    
    @Override
    public us consultar(String id) {
      return null;
    }

    @Override
    public List<us> selectAll() {
   ResultSet rs = null;
     PreparedStatement pst = null;
     List<us> listaus = new LinkedList();
        try {
                  
            connect();  
     if(!isConnect())
	 		throw new SQLException("Sin Conexion fail");
     
  
           pst=con.prepareStatement("select * from us");
      //  pst = dataSource.getConnection().prepareStatement("select * from us ");
        rs = pst.executeQuery();
        while(rs.next()) {
            System.out.println(""+rs.getString(1));
            System.out.println(""+rs.getString(2));
            System.out.println(""+rs.getString(3));
            System.out.println(""+rs.getString(4));
            System.out.println(""+rs.getString(5));
            System.out.println(""+rs.getString(6));
           listaus.add(us.load(rs));
        }
    }   catch (SQLException ex) {
        ex.printStackTrace();
            
        } finally {
        if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUS.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
    }return listaus;
        
    }

    @Override
    public void delete(us p) {
        
    }

    @Override
    public void modificar(us entity) {
        
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
