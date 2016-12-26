package model;


//package javaapplication1;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;

public class Model implements Serializable{

	private transient Connection con;
	private String jdbcDriver;
	private String databaseURL;
	private String user;
	private String password;
        
        private List lista_estudiantes;	
	private List lista_evaluaciones;	
	private List lista_factores;
	private List lista_item;
	private List lista_matriculas;
	private List lista_docentes;
        private List lista_string;	
	
 //	Campos de generacion de listas y objetos
	private List genericList;
    
	private DecimalFormat df = new java.text.DecimalFormat( "###,##0.00" );

	public void connect() throws SQLException{
            databaseURL="jdbc:postgresql://localhost:5432/Resolucion";
            jdbcDriver="org.postgresql.Driver";
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

	public String getJdbcDriver(){
	 	return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver){
           
	 	this.jdbcDriver=jdbcDriver;
	}

	public String getDatabaseURL(){
	 	return databaseURL;
	}

	public void setDatabaseURL(String databaseURL){
            
	 	this.databaseURL=databaseURL;
	}


	/*---------------METODOS DE LAS EVALUACIONES ----------------------*/
//
//	public void addEvaluacion(Evaluacion evaluacion)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		if(this.existeEvaluacion(evaluacion))
//			throw new SQLException("La Evaluacion ya Esta Registrada");
//
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into evaluacion values (?,?,?)");
//	 		pstmt.setString(1,evaluacion.getCodigo_Evaluacion());
//	 		pstmt.setString(2,evaluacion.getDescripcion());
//	 		pstmt.setString(3,evaluacion.getValores_Respuestas());
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//	
//	
//		/*---------------METODOS DE LAS MATRICULAS ----------------------*/

//	public void guardarEstudiante(Estudiante est)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into estudiante values (?,?,?,?,?)");
//	 		pstmt.setString(1,est.getCodigo());
//	 		pstmt.setString(3,est.getNombre());
//	 		pstmt.setString(4,est.getApelllido());
//	 		pstmt.setString(2,est.getIdentificacion());
//                        pstmt.setString(5,est.getPrograma());
//	 			 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
////	
//	////////////////////////////////////////////////
//	
		public List listEstudiantes()throws SQLException{

		if(!isConnect())
	 		throw new SQLException("Sin Conexion");

		PreparedStatement pstmt=null;
		ResultSet result=null;
               
		try{		
		   pstmt=con.prepareStatement("select * from estudiante");
		 
		   result=pstmt.executeQuery();			   
                   lista_estudiantes = new LinkedList();
		   
			while(result.next()){
//				Estudiante a = new Estudiante();
//                                a.setCodigo(result.getString(1));
//                                a.setIdentificacion(result.getString(2));
//                                a.setNombre(result.getString(3));
//                                a.setApelllido(result.getString(4));
//                              	a.setPrograma(result.getString(5));
//                                this.lista_estudiantes.add(a);
				//this.addAsignatura(a);
				
			}
				
		}finally {
				if(result!=null)
					result.close();
	 			  	if(pstmt!=null)
	 			  		 pstmt.close();
	    }
                return lista_estudiantes;
	}
               
                
                
                
//                public Nota [] buscarNotas(String nom)throws SQLException{
//                    Nota notas =new Nota();
//                Nota  notass [] =new Nota [100];
//                String nom_per;
//                String nom_asig;
//                String nota;
//                int i=0;
//                //
//                if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{	
//                    
//pstmt=con.prepareStatement(
//"select persona.nombre ,asignatura.nombre ,nota.nota from asignatura,nota,persona where  codigo_est='"+nom+"' and codigo=codigo_asig and codigo_est =codigo_per; ");
//		 
//		   result=pstmt.executeQuery();			   
//                 	
//			while(result.next()){
//				
//                                notas.setNom_per(result.getString(1));
//                                notas.setNom_asig( result.getString(2));
//                                notas.setNota(nota= result.getString(3));
//                             notass [i]=notas;
//                             i++;
//                        }
//                        
//				
//		}catch(Exception e) {
//                    System.out.println(e);
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//                //
//                
//                return notass;
//                
//                }
//	
//
//
//                         LLAMADO DE USUARIOS
//
//
public boolean listUsuarios(String usuario,String pass,String tipo)throws SQLException{
                
                String usuario2="";
                String pass2="";
                String tipo2="";
                boolean sw =false;
                //asignando datos
                String usuario1=usuario;
                String pass1=pass;
                String tipo1=tipo;
		if(!isConnect())
	 		throw new SQLException("Sin Conexion");

		PreparedStatement pstmt=null;
		ResultSet result=null;
               
		try{	
                    
		   pstmt=con.prepareStatement("select * from usuario ");
		 
		   result=pstmt.executeQuery();			   
                 	
                           
			while(result.next()){
				
                                usuario2= result.getString(1);
                        
                                pass2 = result.getString(2);
                                tipo2 = result.getString(3);
                                                        
                                
                                 if ( pass2.equals(pass1) && usuario2.equals(usuario1) && tipo2.equals(tipo1) ){
                                    sw = true;
                                
                                
                                            }
                       
                        }
                        
				
		}catch(Exception e) {
                    System.out.println(e);
				if(result!=null)
					result.close();
	 			  	if(pstmt!=null)
	 			  		 pstmt.close();
	    }
                return sw;
	}       




public String[] buscarNotas()throws SQLException{
                
                String usuario2="";
                String pass2="";
                String tipo2="";
                String [] notas = null;
                boolean sw =false;
                //asignando datos
             
		if(!isConnect())
	 		throw new SQLException("Sin Conexion");

		PreparedStatement pstmt=null;
		ResultSet result=null;
               
		try{	
                    
		   pstmt=con.prepareStatement("select * from usuario ");
		 
		   result=pstmt.executeQuery();			   
                 	
                          System.out.println("llego al try2");      
			while(result.next()){
				
                                usuario2= result.getString(1);
                              System.out.println("usu"+usuario2);
                                pass2 = result.getString(2);
                              System.out.println("pass"+pass2); 
                                tipo2 = result.getString(3);
                                System.out.println("tipo"+tipo2);
                                
                        
                       
                        }
                        
				
		}catch(Exception e) {
                    System.out.println(e);
				if(result!=null)
					result.close();
	 			  	if(pstmt!=null)
	 			  		 pstmt.close();
	    }
                return notas;
	}       
                
	
//	/*---------------METODOS DE LAS MATRICULAS ----------------------*/
//
//	public void addCarga(Carga carga)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into carga values (?,?,?,?,?)");
//	 		pstmt.setString(1,carga.getCodigo_Docente());
//	 		pstmt.setString(2,carga.getCodigo_Asignatura());
//	 		pstmt.setInt(3,carga.getAno());
//	 		pstmt.setInt(4,carga.getPeriodo());
//	 		pstmt.setInt(5,carga.getSeccion());
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//	
//	////////////////////////////////////////////////
//	
//		public void listCarga()throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{		
//		   pstmt=con.prepareStatement("select * from horadias");
//		 
//		   result=pstmt.executeQuery();			   
//		   
//			while(result.next()){
//				Carga carga = new Carga();
//				carga.setCodigo_Docente(result.getString(1));
//				carga.setCodigo_Asignatura(result.getString(2));
//				carga.setSeccion(result.getInt(3));	
//				carga.setAno(result.getInt(4));
//				carga.setPeriodo(result.getInt(5));
//			
//				this.addCarga(carga);
//				
//			}
//				
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//	
//	
//	
//	
//	public void addAsignatura(Asignatura asignatura)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into asignatura values (?,?,?,?)");
//	 		pstmt.setString(1,asignatura.getCodigo_Asignatura());
//	 		pstmt.setString(2,asignatura.getNombre_Asignatura());
//	 		pstmt.setInt(3,asignatura.getSemestre());
//	 		pstmt.setString(4,asignatura.getPrograma());
//	 	
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//	
//	////////////////////////////////////////////////
//	
//		public void listDetacad()throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{		
//		   pstmt=con.prepareStatement("select * from detaacad");
//		 
//		   result=pstmt.executeQuery();			   
//		   lista_evaluaciones=new LinkedList();
//
//			while(result.next()){
//				Matricula m = new Matricula();
//				m.setCodigo_Estudiante(result.getString(1));
//				m.setAno(result.getInt(2));
//				m.setPeriodo(result.getInt(3));
//				m.setCodigo_Asignatura(result.getString(4));
//				m.setSeccion(result.getInt(5));
//				this.addMatricula(m);
//				
//			}
//				
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//	/////*********************************/////////////////////////
//	
//
//	public boolean  existeEvaluacion(Evaluacion evaluacion)throws SQLException{
//		
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//			stm=con.prepareStatement("select count(*) from evaluacion where codigo_evaluacion = ?" );
//    		stm.setString(1,evaluacion.getCodigo_Evaluacion().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
// 		    if(stm!=null)
// 			   stm.close();
//		}
//
//	 	return sw;
//		}
//
//	public void updateEvaluacion(Evaluacion evaluacion)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update evaluacion set codigo_evaluacion=?,descripcion=?,valores_respuestas=? where codigo_evaluacion=? ");
//			pstmt.setString(1,evaluacion.getCodigo_Evaluacion());
//			pstmt.setString(2,evaluacion.getDescripcion());
//			pstmt.setString(3,evaluacion.getValores_Respuestas());
//			pstmt.setString(4,evaluacion.getCodigo_Evaluacion());
//				
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//
//
//    public Evaluacion getEvaluacion(String codigo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo==null)
//			throw new SQLException("No hay Codigo de Evaluacion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Evaluacion evaluacion=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from evaluacion where codigo_evaluacion=?");
//			pstmt.setString(1,codigo.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				evaluacion=Evaluacion.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return evaluacion;
//	}
//
// 	public List getEvaluaciones(){
//	 	return lista_evaluaciones;
//	}
//
//	public void listEvaluaciones()throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{		
//		   pstmt=con.prepareStatement("select * from evaluacion");
//		 
//		   result=pstmt.executeQuery();			   
//		   lista_evaluaciones=new LinkedList();
//
//			while(result.next())
//				  lista_evaluaciones.add(Evaluacion.load(result));
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//		
//   
//	
//	public void deleteEvaluacion(Evaluacion evaluacion)throws SQLException{
//
//		PreparedStatement pstmt=null;
//
//	 	try{
//        pstmt=con.prepareStatement("delete from evaluacion where codigo_evaluacion=?");
//        pstmt.setString(1,evaluacion.getCodigo_Evaluacion().trim());
//        pstmt.executeUpdate();
//
//	 	}finally {
//        if(pstmt!=null)
//           pstmt.close();
//	 	}
//	}
//	
//	
//	
//	public void updateParametros(Parametros parametros)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update parametros set ano=?,periodo=?,estado_evaluacion=? where evaluacion_actual=? ");
//			pstmt.setInt(1,parametros.getAno());
//			pstmt.setInt(2,parametros.getPeriodo());
//			pstmt.setInt(3,parametros.getEstado_Evaluacion());
//			pstmt.setString(4,parametros.getCodigo_Evaluacion());
//				
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//	
//	
//   /*---------------METODOS DE LOS FACTORES ----------------------*/
//
//	public void addFactor(Factores factores)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		if(this.existeFactor(factores))
//			throw new SQLException("El Factor ya Esta Registrado");
//
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into factores values (?,?,?,?)");
//	 		pstmt.setString(1,factores.getCodigo_Factor());
//	 		pstmt.setString(2,factores.getDescripcion());
//	 		pstmt.setFloat(3,factores.getPorcentaje());
//	 		pstmt.setString(4,factores.getCodigo_Evaluacion());
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//
//	public boolean  existeFactor(Factores factores)throws SQLException{
//		
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from factores where codigo_factor = ?" );  		
//    		stm.setString(1,factores.getCodigo_Factor().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//		}
//
//	public void updateFactor(Factores factores)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update factores "
//			         +" set "
//			     +"codigo_factor=?,"
//			     +"descripcion=?,"
//			     +"porcentaje=?,"
//			     +"codigo_evaluacion=?"			    		     			    
//			     +"where codigo_factor=? ");
//			pstmt.setString(1,factores.getCodigo_Factor());
//			pstmt.setString(2,factores.getDescripcion());
//			pstmt.setFloat(3,factores.getPorcentaje());
//			pstmt.setString(4,factores.getCodigo_Evaluacion());
//			pstmt.setString(5,factores.getCodigo_Factor());
//				
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//
//
//    public Factores getFactor(String codigo_factor)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_factor==null)
//			throw new SQLException("No hay Codigo de Factor");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Factores factores=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from factores where codigo_factor=?");			
//			pstmt.setString(1,codigo_factor.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				factores=Factores.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return factores;
//	}
//
// 	public List getFactores(){
//	 	return lista_factores;
//	}
//
//	public void listFactores(String codigo_evaluacion)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{
//		   pstmt=con.prepareStatement("select * from factores where codigo_evaluacion=?");
//		   pstmt.setString(1,codigo_evaluacion.trim());		 
//		   result=pstmt.executeQuery();			   
//		   lista_factores=new LinkedList();
//
//			while(result.next())
//				  lista_factores.add(Factores.load(result));
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//   
//	
//	public void deleteFactor(Factores factores)throws SQLException{
//
//		PreparedStatement pstmt=null;
//
//	 	try{
//        pstmt=con.prepareStatement("delete from factores where codigo_factor=?");
//        pstmt.setString(1,factores.getCodigo_Factor().trim());
//        pstmt.executeUpdate();
//
//	 	}finally {
//        if(pstmt!=null)
//           pstmt.close();
//	 	}
//	}
//	
//	/**
//	 * Motodo Para Listar losDocentes ya Evaluados por los Estudiantes
//	 * @param item
//	 * @throws SQLException
//	 */
//	
//	
//	public void addDocente_Evaluado(Docentes_evaluados doc_eval)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into docentes_evaluados values (?,?,?,?)");
//	 		pstmt.setString(1,doc_eval.getCodigo_Estudiante());
//	 		pstmt.setString(2,doc_eval.getCodigo_Docente());
//	 		pstmt.setInt(3,doc_eval.getAno());
//	 		pstmt.setInt(4,doc_eval.getPeriodo());
//	 			 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//	
//	
//	public List getListDocentes_Evaluados(){
//	 	return lista_docentes;
//	}
//	
//	public void listDocentes_Evaluados(String codigo_estudiante)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{
//		   pstmt=con.prepareStatement("select * from docentes_evaluados where cod_estudiante=?");
//		   pstmt.setString(1,codigo_estudiante.trim());		 
//		   result=pstmt.executeQuery();			   
//		   lista_docentes = new LinkedList();
//
//			while(result.next())
//				lista_docentes.add(Docentes_evaluados.load(result));
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//	
//	public void updateDocente(Docente docente)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update docente "
//			         +" set "
//			     +"usuario=?,"
//			     +"password=?"	     	    		     			    
//			     +"where codigo_docente=? ");
//			pstmt.setString(1,docente.getUsuario());
//			pstmt.setString(2,docente.getPassword());
//			pstmt.setString(3,docente.getCodigo_Docente());
//			
//				
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//	
//	
//  	/*---------------METODOS DE LOS ITEM ----------------------*/
//
//	public void addItem(Item item)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		if(this.existeItem(item))
//			throw new SQLException("El Item ya Esta Registrado");
//
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into item values (?,?,?)");
//	 		pstmt.setString(1,item.getCodigo_Item());
//	 		pstmt.setString(2,item.getCodigo_Factor());
//	 		pstmt.setString(3,item.getDescripcion());
//	 			 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//
//	public boolean  existeItem(Item item)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;		
//	
//        try{
//        	stm=con.prepareStatement("select count(*) from item where codigo_item = ?" );  				
//    		stm.setString(1,item.getCodigo_Item().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//		}
//
//	public void updateItem(Item item)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update Item "
//			     +" set "
//			     +"codigo_item=?,"
//			     +"codigo_factor=?,"
//			     +"descripcion=? "			     	    		     			    
//			     +"where codigo_item=? ");
//			pstmt.setString(1,item.getCodigo_Item());
//			pstmt.setString(2,item.getCodigo_Factor());
//			pstmt.setString(3,item.getDescripcion());
//			pstmt.setString(4,item.getCodigo_Item());
//						
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//
//
//    public Item getItem(String codigo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo==null)
//			throw new SQLException("No hay Codigo de Factor");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Item item=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from item where codigo_item=?");
//			pstmt.setString(1,codigo.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				item=Item.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return item;
//	}
//
// 	public List getItems(){
//	 	return lista_item;
//	}
//
//	public void listItem(String codigo_factor)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//               
//		try{
//		   pstmt=con.prepareStatement("select * from item where codigo_factor=?");	
//		   pstmt.setString(1,codigo_factor.trim());			   
//		   result=pstmt.executeQuery();			   
//		   lista_item=new LinkedList();
//
//			while(result.next())
//				  lista_item.add(Item.load(result));
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//   
//	
//	public void deleteItem(Item item)throws SQLException{
//
//			PreparedStatement pstmt=null;
//	
//		 	try{
//		        pstmt=con.prepareStatement("delete from item where codigo_item=?");
//		        pstmt.setString(1,item.getCodigo_Item().trim());
//		        pstmt.executeUpdate();
//	
//		 	}finally {
//		        if(pstmt!=null)
//		           pstmt.close();
//		 	}
//	}
//	
// 	/*---------------METODOS DE LOS PARAMETROS ----------------------*/
//
//
//
//    public Parametros getParametro()throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Parametros pa=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from parametros where estado_evaluacion = ?");
//			pstmt.setString(1,"1");	
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				pa=Parametros.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return pa;
//	}
//	
//	public void updateCodigo_Evaluacion(String codevaluacion)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	
//        codevaluacion = String.valueOf(Integer.parseInt(codevaluacion)+1);
//        
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update parametros "
//			     +" set "
//			     +"codigo_evaluacion=?"			     			     	    		     			    
//			     +"where estado_evaluacion=? ");
//			pstmt.setString(1,codevaluacion);
//			pstmt.setString(2,"1");			
//						
//			pstmt.executeUpdate();
//   
//		}finally {
//            if(pstmt!=null)
//                   pstmt.close();
//	 	}
//	}
//	
//	
//	/**********  METODOS DE LOS DIRECTIVOS  **********/////////
//	
//	public boolean  existeDirectivo(Directivo directivo)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from directivos where codigo_directivo = ?" );  				
//    		stm.setString(1,directivo.getCodigo_Directivo().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//    
//    public boolean  existeDirectivoSesion(Directivo directivo)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//		
//	    try{
//        	stm=con.prepareStatement("select count(*) from directivos where usuario = ? and password = ?" );  				
//    		stm.setString(1,directivo.getUsuario().trim());
//    		stm.setString(2,directivo.getPassword().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//    
//   
//
//  
//    /**
//     * 
//     * @param codigo_directivo
//     * @return
//     * @throws SQLException
//     */
//    public Directivo getDirectivo(String codigo_directivo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_directivo==null)
//			throw new SQLException("No hay Codigo de Docente");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Directivo directivo=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from directivos where codigo_directivo=?");
//			pstmt.setString(1,codigo_directivo.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				directivo=Directivo.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return directivo;
//	}
//	
//	public String getCodigo_Directivo(String usuario,String password)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String codigo_directivo=null;
//
//		try{
//			pstmt=con.prepareStatement("select codigo_directivo from directivos where usuario = ? and password = ?" );
//			pstmt.setString(1,usuario.trim());
//    		pstmt.setString(2,password.trim());
//			result=pstmt.executeQuery();
//			if(result.next())
//			   codigo_directivo = result.getString(1);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return codigo_directivo;
//	}
//	
//	
//	
//	 
//	public void updateContrasena_Directivo(String cod_directivo,String user,String password)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	       
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update directivos "
//			     +" set "
//			     +"usuario=?,"	
//			     +"password=? "			     			     	    		     			    
//			     +"where codigo_directivo=? ");
//			pstmt.setString(1,user);
//			pstmt.setString(2,password);
//			pstmt.setString(3,cod_directivo);			
//						
//			pstmt.executeUpdate();
//  
//		}finally {
//           if(pstmt!=null)
//                  pstmt.close();
//	 	}
//	}
//	
//	/**
//	 * 
//	 * @param cod_directivo los Progamas de ese Directivo
//	 * @return El Listado de 
//	 * @throws SQLException
//	 */
//	public List ListProgramas_Directivos(String cod_directivo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	
//		PreparedStatement pstmt=null;
//		ResultSet result=null;		
//		List listPrograma = new LinkedList();
//
//		try{
//			pstmt=con.prepareStatement("select p.codigo_programa, p.nombre_programa "+
//					                  "from programa p, directivo_programa dp,directivos d "+
//					                  "where  d.codigo_directivo = dp.codigo_directivo and "+
//					                  "p.codigo_programa=dp.codigo_programa  and  d.codigo_directivo = ?");
//			
//			pstmt.setString(1,cod_directivo.trim());    		
//			result=pstmt.executeQuery();	
//			
//			while(result.next())
//				listPrograma.add(Programa.load(result));			
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return listPrograma;
//	}
//	
//	
// /**********  METODOS DE LOS ADMINISTRADORES  **********/////////
//    
//    public boolean  existeAdministradorSesion(Administrador administrador)throws SQLException{
//
//    	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//		
//	    try{
//        	stm=con.prepareStatement("select count(*) from administrador where usuario = ? and password = ?" );  				
//    		stm.setString(1,administrador.getUsuario().trim());
//    		stm.setString(2,administrador.getPassword().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//    
//    
//    public String getCodigo_Administrador(String usuario,String password)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String codigo_administrador=null;
//
//		try{
//			pstmt=con.prepareStatement("select cedula from administrador where usuario = ? and password = ?" );
//			pstmt.setString(1,usuario.trim());
//    		pstmt.setString(2,password.trim());
//			result=pstmt.executeQuery();
//			if(result.next())
//				codigo_administrador = result.getString(1);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return codigo_administrador;
//	}
//	
//	
//	
//		/*---------------METODOS DE LOS DOCENTES ----------------------*/
//
//
//	public boolean  existeDocente(Docente docente)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from docente where codigo_docente = ?" );  				
//    		stm.setString(1,docente.getCodigo_Docente().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//    
//    public boolean  existeDocenteSesion(Docente docente)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from docente where usuario = ? and password = ?" );  				
//    		stm.setString(1,docente.getUsuario().trim());
//    		stm.setString(2,docente.getPassword().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//  
//    public Docente getDocente(String codigo_docente)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_docente==null)
//			throw new SQLException("No hay Codigo de Docente");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Docente docente=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from docente where codigo_docente=?");
//			pstmt.setString(1,codigo_docente.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				docente=Docente.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return docente;
//	}
//	
//	public String getCodigo_Docente(String usuario,String password)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String codigo_docente=null;
//
//		try{
//			pstmt=con.prepareStatement("select codigo_docente from docente where usuario = ? and password = ?" );
//			pstmt.setString(1,usuario.trim());
//    		pstmt.setString(2,password.trim());
//			result=pstmt.executeQuery();
//			if(result.next())
//			   codigo_docente = result.getString(1);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//	
//		return codigo_docente;
//	}
//	
//	
//   public List getListDocentesPrograma(String codigo_programa,String ano,String periodo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_programa==null)
//			throw new SQLException("No hay Codigo de Docente");			
//		
//		
//		PreparedStatement pstmt=null;
//		ResultSet result=null;		
//		List list_carga = new LinkedList();       
//
//		try{
//			
//			pstmt=con.prepareStatement("select distinct carga.codigo_docente "+
//			"from carga inner join asignatura "+
//			"on asignatura.codigo_asignatura=carga.codigo_asignatura "+
//			"and  asignatura.programa= ? where "+
//			"carga.periodo=? and carga.ano=? ");
//		
//			pstmt.setString(1,codigo_programa.trim());		
//			pstmt.setInt(2,Integer.parseInt(periodo));
//			pstmt.setInt(3,Integer.parseInt(ano));
//			result=pstmt.executeQuery();
//				
//			while(result.next())		
//			   list_carga.add(result.getString(1)); 
//				   			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return list_carga;
//	}
//   
//   public void updateContrasena_Docente(String cod_docente,String user,String password)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	       
//		PreparedStatement pstmt=null;
//		try{
//
//			pstmt=con.prepareStatement("update docente "
//			     +" set "
//			     +"usuario=?,"	
//			     +"password=? "			     			     	    		     			    
//			     +"where codigo_docente=? ");
//			pstmt.setString(1,user);
//			pstmt.setString(2,password);
//			pstmt.setString(3,cod_docente);			
//						
//			pstmt.executeUpdate();
//  
//		}finally {
//           if(pstmt!=null)
//                  pstmt.close();
//	 	}
//	}
//	
//	 
//
//
//	/*---------------METODOS DE LOS ESTUDIANTES ----------------------*/
//
//    public Estudiantes getEstudiante(String codigo_estudiante)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_estudiante==null)
//			throw new SQLException("No hay Codigo de Estudiante");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Estudiantes estudiante=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from estudiantes where codigo =?");
//			pstmt.setString(1,codigo_estudiante.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				estudiante=Estudiantes.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return estudiante;
//	}
//	
//	
//	public boolean existeEstudiante(Estudiantes estudiante)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from estudiantes where codigo = ?" );  				
//    		stm.setString(1,estudiante.getCodigo_Estudiante().trim());
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//    
//    public boolean existeEstudianteSesion(Estudiantes estudiante)throws SQLException{
//
//	  System.out.println("legooooo al model "+ estudiante.getCodigo_Estudiante());
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//                
//                this.connect();
//                
//            if(this.isConnect())
//		          System.out.println("Ya Esta Conectado ");
//            else
//	 	System.out.println("No Esta Conectado ");	
//
//        try{
//           
//            
//        	stm=con.prepareStatement("select count(*) from estudiante where codigo_estudiante = ? and documento = ?" );  
//               
//    		stm.setString(1,estudiante.getCodigo_Estudiante().trim());
//               
//    		stm.setString(2,estudiante.getDocumento().trim());
//              
//			result=stm.executeQuery();
//                       
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//
//} catch (SQLException excep) {
//				System.out.println("ERROR: " + excep);
//			}
//		/*}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}*/
//System.out.println("legooooo al model 4");
//	 	return sw;
//    }
//    
//    	/*---------------METODOS DE LAS MATRICULAS ----------------------*/
//
//    public Matricula getMatricula(String codigo_estudiante)throws SQLException{
//     
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_estudiante==null)
//			throw new SQLException("No hay Codigo de Estudiante");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Matricula matricula=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from matricula where codigo_estudiante=?");
//			pstmt.setString(1,codigo_estudiante.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				matricula=Matricula.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return matricula;
//	}
//	
//	
//	public List getListMatriculas(){
//	 	return lista_matriculas;
//	}
//
//	public void listMatriculas(String codigo_estudiante)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		
//	   
//               
//		try{
//		    pstmt=con.prepareStatement("select * from matricula where codigo_estudiante=?");
//			pstmt.setString(1,codigo_estudiante.trim());
//			result=pstmt.executeQuery();	   
//		    lista_matriculas=new LinkedList();
//
//			while(result.next())
//				  lista_matriculas.add(Matricula.load(result));
//		}finally {
//				if(result!=null)
//					result.close();
//	 			  	if(pstmt!=null)
//	 			  		 pstmt.close();
//	    }
//	}
//	
//	/*---------------METODOS DE LOS ESTADOS ----------------------*/
//
//    public void addEstado(Estado estado)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into estado values (?,?,?)");
//	 		pstmt.setString(1,estado.getCodigo_Estudiante());
//	 		pstmt.setInt(2,estado.getAno());
//	 		pstmt.setInt(3,estado.getPeriodo());
//	 			 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
// 
//    
//    
//    public Estado getEstadoEstudiante(String codestdiante)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	 		
//	 	if(codestdiante==null)
//			throw new SQLException("No hay Codigo de Estudiante");
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Estado estado=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from estado where codigo_estudiante = ?");
//			pstmt.setString(1,codestdiante.trim());	
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				estado=Estado.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return estado;
//	}
//	
//	 public boolean existeEstadoEstudiante(String codestudiante)throws SQLException{
//
//	
//		boolean sw=false;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from estado where codigo_estudiante = ?" );  				
//    		stm.setString(1,codestudiante.trim());    		
//			result=stm.executeQuery();
//			if(result.next())
//			  if(!result.getString(1).equals("0"))
//				sw=true;
//		
//
//		}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
//
//	 	return sw;
//    }
//	
//    /*---------------METODOS DE LOS PROGRAMAS ----------------------*/
//
//
//    public String getNombrePrograma(String codprograma)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	 		
//	 	if(codprograma==null)
//			throw new SQLException("No hay Codigo de Programa");
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String nomprograma=null;
//	
//		try{
//			pstmt=con.prepareStatement("select nombre_programa from programa where codigo_programa = ?");
//			pstmt.setString(1,codprograma.trim());	
//			result=pstmt.executeQuery();
//		
//			if(result.next())		
//				nomprograma=result.getString(1);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return nomprograma;
//	}
//
//
//
//	
//		/*---------------METODOS DE LAS ASIGNATURAS ----------------------*/
//
//    public Asignatura getAsignatura(String codigo_asignatura)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_asignatura==null)
//			throw new SQLException("No hay Codigo de Asignatura");
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Asignatura asignatura=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from asignatura where codigo_asignatura=?");
//			pstmt.setString(1,codigo_asignatura.trim());
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				asignatura=Asignatura.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return asignatura;
//	}
//	
//    /*---------------METODOS DE LAS CARGA ----------------------*/
//
//    public Carga getCarga(String codigo_asignatura,int seccion)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigo_asignatura==null)
//			throw new SQLException("No hay Codigo de Asignatura");			
//
//
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Carga carga=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from carga where codigo_asignatura = ? and seccion = ?");			
//			pstmt.setString(1,codigo_asignatura.trim());
//			pstmt.setInt(2,seccion);
//			result=pstmt.executeQuery();
//
//			if(result.next())
//				carga=Carga.load(result);
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return carga;
//	}
//	
//	 public List getListCargaDocente(String codigoDocente,String ano,String periodo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigoDocente==null)
//			throw new SQLException("No hay Codigo de Docente");			
//		
//		
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Carga carga=null;
//		List list_carga = new LinkedList();       
//
//		try{
//			pstmt=con.prepareStatement("select * from carga where codigo_docente = ?  and ano = ? and periodo = ?");			
//			pstmt.setString(1,codigoDocente.trim());		
//			pstmt.setInt(2,Integer.parseInt(ano));
//			pstmt.setInt(3,Integer.parseInt(periodo));
//			result=pstmt.executeQuery();
//				
//			while(result.next())		
//			   list_carga.add(Carga.load(result)); 
//			   			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return list_carga;
//	}
//	
//	
//	 public List getListCargaDocentePrograma(String codPrograma,String ano,String periodo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codPrograma==null)
//			throw new SQLException("No hay Codigo de Docente");			
//		
//		
//		PreparedStatement pstmt=null;
//		ResultSet result=null;		
//		List list_carga = new LinkedList();       
//        
//		try{
//			pstmt=con.prepareStatement("select carga.codigo_docente,carga.codigo_asignatura,carga.ano,carga.periodo, carga.seccion from carga, "+
//		                               "asignatura where carga.ano = ? and carga.periodo = ? and carga.codigo_asignatura = asignatura.codigo_asignatura "+
//		                               "and asignatura.programa = ? order by carga.codigo_docente");			
//			pstmt.setInt(1,Integer.parseInt(ano));		
//			pstmt.setInt(2,Integer.parseInt(periodo));
//			pstmt.setString(3,codPrograma.trim());
//	    	result=pstmt.executeQuery();
//				
//			while(result.next()){							
//			   list_carga.add(Carga.load(result)); 
//		   	}
//			   			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return list_carga;
//	}
//	
//	
///*	 public List getListCargaDocente(String codigoDocente,String ano,String periodo)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 	if(codigoDocente==null)
//			throw new SQLException("No hay Codigo de Docente");			
//		
//		
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		Carga carga=null;
//		List list_carga = new LinkedList();       
//
//		try{
//			pstmt=con.prepareStatement("Select * from Carga where codigo_docente = ?  and ano = ? and periodo = ?");			
//			pstmt.setString(1,codigoDocente.trim());		
//			pstmt.setInt(2,Integer.parseInt(ano));
//			pstmt.setInt(3,Integer.parseInt(periodo));
//			result=pstmt.executeQuery();
//				
//			while(result.next())		
//			   list_carga.add(Carga.load(result)); 
//			   			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return list_carga;
//	}*/
//	
//	
//		/*---------------METODOS DE LAS RESPUESTAS ----------------------*/
//
//	public void addRespuesta(Respuesta respuesta)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//    
//    	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into respuesta values (?,?,?,?,?,?)");
//	 		pstmt.setString(1,respuesta.getCodigo_Respuesta());
//	 		pstmt.setString(2,respuesta.getCodigo_Asignatura());
//	 		pstmt.setInt(3,respuesta.getSeccion());
//	 		pstmt.setInt(4,respuesta.getAno());
//	 		pstmt.setInt(5,respuesta.getPeriodo());
//	 		pstmt.setString(6,respuesta.getObservaciones());
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//	
//	public String getCodigoRespuesta(Respuesta respuesta)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String  cod_respuesta=null;
//
//		try{
//			pstmt=con.prepareStatement("select * from respuesta where codigo_asignatura = ? and seccion = ? and ano = ? and periodo = ?");			
//			pstmt.setString(1,respuesta.getCodigo_Asignatura().trim());
//			pstmt.setInt(2,respuesta.getSeccion());
//			pstmt.setInt(3,respuesta.getAno());
//			pstmt.setInt(4,respuesta.getPeriodo());
//			result=pstmt.executeQuery();
//
//			if(result.next())		
//				cod_respuesta=result.getString(1);
//						
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return cod_respuesta;
//	}
//	
//	public List getResultadoDocente(String codAsignatura, int seccion, int ano, int per)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;	
//        List tablaResultado = new LinkedList();
//        List respuesta = new LinkedList();
//        
//		try{
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			pstmt=con.prepareStatement("select item.codigo_factor, detalle.respuesta from item, detalle, respuesta "+
//										"where detalle.codigo_item = item.codigo_item and respuesta.codigo_respuesta=detalle.codigo_respuesta and "+
//										"respuesta.codigo_asignatura=? and respuesta.seccion=? and respuesta.ano=? and respuesta.periodo=? ");
//				
//			pstmt.setString(1,codAsignatura.trim());
//			pstmt.setInt(2,seccion);
//			pstmt.setInt(3,ano);
//			pstmt.setInt(4,per);
//			result=pstmt.executeQuery();
//
//			while(result.next()){
//				tablaResultado.add(RespuestaItem.load(result));
//			}
//			
//			Iterator it = tablaResultado.iterator();
//			float sumaRespuesta=0;
//			int sumaTotal=0;
//			
//			
//			while(it.hasNext()){
//				RespuestaItem resIt = (RespuestaItem)it.next();
//				/*Si el factor no esta en la lista de respuesta*/	
//			    if(!this.verificarFactorRespuesta(respuesta,resIt.getCodigo_Factor())){
//			   		sumaRespuesta=0;
//			   		sumaTotal=0;
//					Iterator it2 = 	tablaResultado.iterator();
//						while(it2.hasNext()){
//							RespuestaItem resIt2 = (RespuestaItem)it2.next();
//								if(resIt.getCodigo_Factor().equals(resIt2.getCodigo_Factor())){
//								 	sumaRespuesta=sumaRespuesta+resIt2.getRespuesta();
//			   						sumaTotal=sumaTotal+5;
//							}		
//								
//				}
//				float r = sumaRespuesta/sumaTotal*100;
//				RespuestaItem total = new RespuestaItem();
//				total.setCodigo_Factor(resIt.getCodigo_Factor());				
//				total.setRespuesta(r);
//				respuesta.add(total);	
//			}
//			
//		}
//		/*Capturar Total de la Evaluacion*/
//		/*Obtener el porcentaje de cada uno de los factores*/
//		
//		Iterator itRes = respuesta.iterator();
//		float definitiva=0;
//		int pos=0;
//        while(itRes.hasNext()){
//        	RespuestaItem resItem = (RespuestaItem)itRes.next();
//        	Factores factor = getFactor(resItem.getCodigo_Factor());
//        	definitiva = definitiva+(resItem.getRespuesta()*factor.getPorcentaje()/100);
//        /*Se Cargan los nombres de los factores*/
//        	RespuestaItem res = new RespuestaItem();
//        	res.setCodigo_Factor(factor.getDescripcion());
//			res.setRespuesta(resItem.getRespuesta());
//	 	    respuesta.set(pos,res);
//        	pos++;
//        }
//        /*Se guarga en la Lista de respuesta de definitiva*/
//        RespuestaItem def = new RespuestaItem();
//        def.setCodigo_Factor("Global");
//        def.setRespuesta(definitiva);
//        respuesta.add(def);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return respuesta;
//	}
//	
//	/**
//	 * 
//	 * @param parametro
//	 * @param ano
//	 * @param per
//	 * @return
//	 * @throws SQLException
//	 */
//	public List getConsultaDocentes(String parametro, int ano, int per)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;        
//        List respuesta = new LinkedList();
//        
//		try{
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			
//			pstmt=con.prepareStatement("select distinct docente.codigo_docente,docente.nombres from carga, docente "+
//										"where carga.codigo_docente = docente.codigo_docente and docente.nombres like '%"+parametro.trim()+"%' or docente.codigo_docente=?  "+
//										"and carga.ano=? and carga.periodo=? ");
//				
//			pstmt.setString(1,parametro.trim());	
//			pstmt.setInt(2,ano);
//			pstmt.setInt(3,per);	
//			
//			
//			result=pstmt.executeQuery();
//			
//
//			while(result.next()){
//				
//				Docente d = new Docente();
//				d.setCodigo_Docente(result.getString(1));
//				d.setNombre(result.getString(2));
//				respuesta.add(d);
//			}
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return respuesta;
//	}
//	
//	///Metodo para listar el Consolidado por asignatura
//   public List getResultadoDocenteAsignatura(String codAsignatura, int ano, int per)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String  cod_respuesta=null;
//        List tablaResultado = new LinkedList();
//        List respuesta = new LinkedList();
//        
//		try{
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			pstmt=con.prepareStatement("select item.codigo_factor, detalle.respuesta from item, detalle, respuesta "+
//										"where detalle.codigo_item = item.codigo_item and respuesta.codigo_respuesta=detalle.codigo_respuesta and "+
//										"respuesta.codigo_asignatura=? and respuesta.ano=? and respuesta.periodo=? ");
//				
//			pstmt.setString(1,codAsignatura.trim());		
//			pstmt.setInt(2,ano);
//			pstmt.setInt(3,per);
//			result=pstmt.executeQuery();
//
//			while(result.next()){
//				tablaResultado.add(RespuestaItem.load(result));
//			}
//			
//			Iterator it = tablaResultado.iterator();
//			float sumaRespuesta=0;
//			int sumaTotal=0;
//			
//			
//			while(it.hasNext()){
//				RespuestaItem resIt = (RespuestaItem)it.next();
//				/*Si el factor no esta en la lista de respuesta*/	
//			    if(!this.verificarFactorRespuesta(respuesta,resIt.getCodigo_Factor())){
//			   		sumaRespuesta=0;
//			   		sumaTotal=0;
//					Iterator it2 = 	tablaResultado.iterator();
//						while(it2.hasNext()){
//							RespuestaItem resIt2 = (RespuestaItem)it2.next();
//								if(resIt.getCodigo_Factor().equals(resIt2.getCodigo_Factor())){
//								 	sumaRespuesta=sumaRespuesta+resIt2.getRespuesta();
//			   						sumaTotal=sumaTotal+5;
//							}		
//								
//				}
//				float r = sumaRespuesta/sumaTotal*100;
//				RespuestaItem total = new RespuestaItem();
//				total.setCodigo_Factor(resIt.getCodigo_Factor());				
//				total.setRespuesta(r);
//				respuesta.add(total);	
//			}
//			
//		}
//		/*Capturar Total de la Evaluacion*/
//		/*Obtener el porcentaje de cada uno de los factores*/
//		
//		Iterator itRes = respuesta.iterator();
//		float definitiva=0;
//		int pos=0;
//        while(itRes.hasNext()){
//        	RespuestaItem resItem = (RespuestaItem)itRes.next();
//        	Factores factor = getFactor(resItem.getCodigo_Factor());
//        	definitiva = definitiva+(resItem.getRespuesta()*factor.getPorcentaje()/100);
//        /*Se Cargan los nombres de los factores*/
//        	RespuestaItem res = new RespuestaItem();
//        	res.setCodigo_Factor(factor.getDescripcion());
//			res.setRespuesta(resItem.getRespuesta());
//	 	    respuesta.set(pos,res);
//        	pos++;
//        }
//        /*Se guarga en la Lista de respuesta de definitiva*/
//        RespuestaItem def = new RespuestaItem();
//        def.setCodigo_Factor("Global");
//        def.setRespuesta(definitiva);
//        respuesta.add(def);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return respuesta;
//	}
//	
//     
//      public float getResultadoAsignaturaSeccion(String codAsignatura, int seccion, int ano, int per)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		String  cod_respuesta=null;
//        List tablaResultado = new LinkedList();
//        List respuesta = new LinkedList();
//        
//        float definitiva =0;
//        
//		try{
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			pstmt=con.prepareStatement("select item.codigo_factor, detalle.respuesta from item, detalle, respuesta "+
//										"where detalle.codigo_item = item.codigo_item and respuesta.codigo_respuesta=detalle.codigo_respuesta and "+
//										"respuesta.codigo_asignatura=? and respuesta.seccion=? and respuesta.ano=? and respuesta.periodo=? ");
//				
//			pstmt.setString(1,codAsignatura.trim());
//			pstmt.setInt(2,seccion);
//			pstmt.setInt(3,ano);
//			pstmt.setInt(4,per);
//			result=pstmt.executeQuery();
//		
//			while(result.next()){
//				tablaResultado.add(RespuestaItem.load(result));
//			}
//			
//			Iterator it = tablaResultado.iterator();
//			float sumaRespuesta=0;
//			int sumaTotal=0;
//			
//			
//			while(it.hasNext()){
//				RespuestaItem resIt = (RespuestaItem)it.next();
//				/*Si el factor no esta en la lista de respuesta*/	
//			    if(!this.verificarFactorRespuesta(respuesta,resIt.getCodigo_Factor())){
//			   		sumaRespuesta=0;
//			   		sumaTotal=0;
//					Iterator it2 = 	tablaResultado.iterator();
//						while(it2.hasNext()){
//							RespuestaItem resIt2 = (RespuestaItem)it2.next();
//								if(resIt.getCodigo_Factor().equals(resIt2.getCodigo_Factor())){
//								 	sumaRespuesta=sumaRespuesta+resIt2.getRespuesta();
//			   						sumaTotal=sumaTotal+5;
//							}		
//								
//				}
//				float r = sumaRespuesta/sumaTotal*100;
//				RespuestaItem total = new RespuestaItem();
//				total.setCodigo_Factor(resIt.getCodigo_Factor());				
//				total.setRespuesta(r);
//				respuesta.add(total);	
//			}
//			
//		}
//		/*Capturar Total de la Evaluacion*/
//		/*Obtener el porcentaje de cada uno de los factores*/
//		
//		Iterator itRes = respuesta.iterator();
//		
//		int pos=0;
//        while(itRes.hasNext()){
//        	RespuestaItem resItem = (RespuestaItem)itRes.next();
//        	Factores factor = getFactor(resItem.getCodigo_Factor());
//        	definitiva = definitiva+(resItem.getRespuesta()*factor.getPorcentaje()/100);
//        /*Se Cargan los nombres de los factores*/
//        	RespuestaItem res = new RespuestaItem();
//        	res.setCodigo_Factor(factor.getDescripcion());
//			res.setRespuesta(resItem.getRespuesta());
//	 	    respuesta.set(pos,res);
//        	pos++;
//        }
//       
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//		return definitiva;
//	}
//     
//	//**********************     RESULTADO GLOBAL DEL DOCENTE ************//////////////////
//	public List getResultadoDocenteGlobal(String codDocente,int ano, int per)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		/*Se busca las asignaturas que dicta un docente en un periodo especifico
//		 *
//		 **/ 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		List tablaResultado;
//		List respuesta = new LinkedList();
//		
//		        
//		try{
//			Iterator itCarga = this.getListCargaDocente(codDocente,""+ano,""+per).iterator();
//			tablaResultado = new LinkedList();
//			while(itCarga.hasNext()){
//			
//		 	Carga carga = (Carga)itCarga.next();
//		 	
//	       // String  cod_respuesta=null;
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			pstmt=con.prepareStatement("select item.codigo_factor, detalle.respuesta from item, detalle, respuesta "+
//										"where detalle.codigo_item = item.codigo_item and respuesta.codigo_respuesta=detalle.codigo_respuesta and "+
//										"respuesta.codigo_asignatura=? and respuesta.seccion=? and respuesta.ano=? and respuesta.periodo=? ");
//				
//			pstmt.setString(1,carga.getCodigo_Asignatura());
//			pstmt.setInt(2,carga.getSeccion());
//			pstmt.setInt(3,ano);
//			pstmt.setInt(4,per);
//			result=pstmt.executeQuery();
//
//			while(result.next()){
//				tablaResultado.add(RespuestaItem.load(result));
//			}
//			}
//			Iterator it = tablaResultado.iterator();
//			float sumaRespuesta=0;
//			int sumaTotal=0;
//			
//			while(it.hasNext()){
//				RespuestaItem resIt = (RespuestaItem)it.next();
//				
//				/*Si el factor no esta en la lista de respuesta*/	
//			    if(!this.verificarFactorRespuesta(respuesta,resIt.getCodigo_Factor())){
//			   		sumaRespuesta=0;
//			   		sumaTotal=0;
//					Iterator it2 = 	tablaResultado.iterator();
//					while(it2.hasNext()){
//						RespuestaItem resIt2 = (RespuestaItem)it2.next();
//						if(resIt.getCodigo_Factor().equals(resIt2.getCodigo_Factor())){
//						 	sumaRespuesta=sumaRespuesta+resIt2.getRespuesta();
//		   					sumaTotal=sumaTotal+5;
//						}										
//					}
//					float r = sumaRespuesta/sumaTotal*100;
//					RespuestaItem total = new RespuestaItem();
//					total.setCodigo_Factor(resIt.getCodigo_Factor());				
//					total.setRespuesta(r);
//					respuesta.add(total);	
//			    }
//			
//		}
//		
//		/*Capturar Total de la Evaluacion*/
//		/*Obtener el porcentaje de cada uno de los factores*/
//		
//		Iterator itRes = respuesta.iterator();
//		float definitiva=0;
//		int pos=0;
//        while(itRes.hasNext()){
//        	RespuestaItem resItem = (RespuestaItem)itRes.next();
//        	Factores factor = getFactor(resItem.getCodigo_Factor());
//        	definitiva = definitiva+(resItem.getRespuesta()*factor.getPorcentaje()/100);
//        	
//            /*Se Cargan los nombres de los factores*/
//        	RespuestaItem res = new RespuestaItem();
//        	res.setCodigo_Factor(factor.getDescripcion());
//			res.setRespuesta(resItem.getRespuesta());
//	 	    respuesta.set(pos,res);
//        	pos++;
//        }
//        /*Se guarga en la Lista de respuesta de definitiva*/
//        RespuestaItem def = new RespuestaItem();
//        def.setCodigo_Factor("Global");
//        def.setRespuesta(definitiva);
//        respuesta.add(def);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//	
//		return respuesta;
//	}
//	
//	/**
//	 * 
//	 * @param codPrograma
//	 * @param ano
//	 * @param per
//	 * @return
//	 * @throws SQLException
//	 */
//	
//	public List getResultadoGlobalPrograma(String codPrograma,int ano, int per)throws SQLException{
//		
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		/*Se busca las asignaturas que dicta un docente en un periodo especifico
//		 *
//		 **/ 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		List tablaResultado;
//		List respuesta = new LinkedList();
//				        
//		try{
//			//Iterator itCarga = this.getListCargaDocente(codDocente,""+ano,""+per).iterator();
//			tablaResultado = new LinkedList();
//		//	while(itCarga.hasNext()){
//			
//		 //	Carga carga = (Carga)itCarga.next();
//		 	
//	       // String  cod_respuesta=null;
//			/*
//			 *Aqui viene la sintaxis de cruze de tablas para MySql...
//			 */
//			pstmt=con.prepareStatement("select item.codigo_factor, detalle.respuesta from item, detalle, respuesta,asignatura "+
//										"where detalle.codigo_item = item.codigo_item and respuesta.codigo_respuesta=detalle.codigo_respuesta "+
//										" and respuesta.ano=? and respuesta.periodo=? and "+
//										"respuesta.codigo_asignatura = asignatura.codigo_asignatura and asignatura.programa = ?");
//				
//			
//			pstmt.setInt(1,ano);
//			pstmt.setInt(2,per);
//			pstmt.setString(3,codPrograma);
//			result=pstmt.executeQuery();
//
//			while(result.next()){
//				tablaResultado.add(RespuestaItem.load(result));
//			}
//			//}
//			Iterator it = tablaResultado.iterator();
//			float sumaRespuesta=0;
//			int sumaTotal=0;
//			
//			while(it.hasNext()){
//				RespuestaItem resIt = (RespuestaItem)it.next();
//				
//				/*Si el factor no esta en la lista de respuesta*/	
//			    if(!this.verificarFactorRespuesta(respuesta,resIt.getCodigo_Factor())){
//			   		sumaRespuesta=0;
//			   		sumaTotal=0;
//					Iterator it2 = 	tablaResultado.iterator();
//					while(it2.hasNext()){
//						RespuestaItem resIt2 = (RespuestaItem)it2.next();
//						if(resIt.getCodigo_Factor().equals(resIt2.getCodigo_Factor())){
//						 	sumaRespuesta=sumaRespuesta+resIt2.getRespuesta();
//		   					sumaTotal=sumaTotal+5;
//						}										
//					}
//					float r = sumaRespuesta/sumaTotal*100;
//					RespuestaItem total = new RespuestaItem();
//					total.setCodigo_Factor(resIt.getCodigo_Factor());				
//					total.setRespuesta(r);
//					respuesta.add(total);	
//			    }
//			
//		}
//		
//		/*Capturar Total de la Evaluacion*/
//		/*Obtener el porcentaje de cada uno de los factores*/
//		
//		Iterator itRes = respuesta.iterator();
//		float definitiva=0;
//		int pos=0;
//        while(itRes.hasNext()){
//        	RespuestaItem resItem = (RespuestaItem)itRes.next();
//        	Factores factor = getFactor(resItem.getCodigo_Factor());
//        	definitiva = definitiva+(resItem.getRespuesta()*factor.getPorcentaje()/100);
//        	
//            /*Se Cargan los nombres de los factores*/
//        	RespuestaItem res = new RespuestaItem();
//        	res.setCodigo_Factor(factor.getDescripcion());
//			res.setRespuesta(resItem.getRespuesta());
//	 	    respuesta.set(pos,res);
//        	pos++;
//        }
//        /*Se guarga en la Lista de respuesta de definitiva*/
//        RespuestaItem def = new RespuestaItem();
//        def.setCodigo_Factor("Global");
//        def.setRespuesta(definitiva);
//        respuesta.add(def);
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}
//	
//		return respuesta;
//	}
//	
//	
//	/*------------ METODOS DE LOS INTERVALOS ----------------------*/	
//	
//	public String getIntervalo(String codigo_evaluacion,float valor)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	 		
//	 	if(codigo_evaluacion==null)
//			throw new SQLException("No hay Codigo de Programa");
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		List listinetervalo = new LinkedList();
//		String rango = "";
//	
//		try{
//			pstmt=con.prepareStatement("select * from intervalo where codigo_evaluacion = ?");
//			pstmt.setString(1,codigo_evaluacion.trim());	
//			result=pstmt.executeQuery();
//			
//			while(result.next())		
//			   listinetervalo.add(Intervalo.load(result));
//			
//			Iterator itinter = listinetervalo.iterator();
//			
//			while(itinter.hasNext()){
//        		Intervalo intervalo = (Intervalo)itinter.next();
//        		if((intervalo.getPorcentaje_Inicial()<=valor)&&(intervalo.getPorcentaje_Final()>=valor)){        		
//        		  rango = intervalo.getDescripcion();
//        		  break;
//        		}
//        	}
//        
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//				
//		return rango;
//	}
//	
//	
//	public String getColor_Intervalo(String codigo_evaluacion,float valor)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//	 		
//	 	if(codigo_evaluacion==null)
//			throw new SQLException("No hay Codigo de Programa");
//	 
//		PreparedStatement pstmt=null;
//		ResultSet result=null;
//		List listinetervalo = new LinkedList();
//		String color = "";
//	
//		try{
//			pstmt=con.prepareStatement("select * from intervalo where codigo_evaluacion = ?");
//			pstmt.setString(1,codigo_evaluacion.trim());	
//			result=pstmt.executeQuery();
//			
//			while(result.next())		
//			   listinetervalo.add(Intervalo.load(result));
//			
//			Iterator itinter = listinetervalo.iterator();
//			
//			while(itinter.hasNext()){
//        		Intervalo intervalo = (Intervalo)itinter.next();
//        		if((intervalo.getPorcentaje_Inicial()<=valor)&&(intervalo.getPorcentaje_Final()>=valor)){        		
//        		  color = intervalo.getColor();
//        		  break;
//        		}
//        	}
//        
//			
//		}finally {
//				if(result!=null)
//					result.close();
//				  	if(pstmt!=null)
//				  		 pstmt.close();
//		}		
//				
//		return color;
//	}
//	
//	
//	
//	/*------------Verificar la existen del factor en la lista de Rta ----------------------*/
//	
//	public boolean verificarFactorRespuesta(List lista, String factor){
//		Iterator it = lista.iterator();
//		boolean sw= false;
//		while(it.hasNext()){
//			RespuestaItem resIt = (RespuestaItem)it.next();
//			if(resIt.getCodigo_Factor().equals(factor)){
//				sw=true;
//				break;
//			}
//		}
//		return sw;
//	}
//	
//	
//	/*---------------METODOS DE LOS DETALLES ----------------------*/
//
//	public void addDetalle(Detalle detalle)throws SQLException{
//
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//	
//	 	PreparedStatement pstmt=null;
//
//	 	try{
//
//	 		pstmt=con.prepareStatement("insert into detalle values (?,?,?)");
//	 		pstmt.setString(1,detalle.getCodigo_Respuesta());
//	 		pstmt.setString(2,detalle.getCodigo_Item());
//	 		pstmt.setInt(3,detalle.getRespuesta());
//	 				
//	 		pstmt.executeUpdate();
//
//		}finally {
//	 		if(pstmt!=null)
//	 		   pstmt.close();
//	 	}
//	}
//
// 	
//	//////////////////////////////////////////////////////////////////////////////
//	
//	/**
//	 * Llama al metodo ListGeneric parametrizado
//	 * @exception SQLException si aparece un error de base de datos
//	 */
//	 public synchronized void listGeneric(String query) throws SQLException {
//	   List auxList = null;
//	   PreparedStatement pstmt = null;
//	   ResultSet rs = null;
//	   String dato = "";
//	   try {
//		   // Preparar consulta Sql
//		   pstmt = con.prepareStatement(query);
//
//		   // Ejecutar consulta y copiar resultados a la lista
//		   rs = pstmt.executeQuery();
//		   genericList = new LinkedList();
//
//		   while (rs.next()) {
//			 auxList = new LinkedList();
//		     for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i){
//			     dato = rs.getString(i);
//			     if (dato == null)
//			       dato = "";
//			     auxList.add(dato.trim());
//		     }
//		     genericList.add(auxList);
//		   }
//	   }finally{
//		   if (rs != null)
//		     rs.close();
//		   if (pstmt != null)
//		     pstmt.close();
//	   }
//	 }
//
//	/**
//	 * Llama al metodo ListGeneric parametrizado
//	 * @exception SQLException si aparece un error de base de datos
//	 */
//	 public synchronized void listGeneric(Object object)throws SQLException{
//	   this.listGeneric(object,"","");
//	 }
//
//	/**
//	 * Hace una consulta en la base de datos del sistema .
//	 * Crea una lista de objetos deacuerdo a la clase requerida.
//	 * @param condicion la  condicion de filtro Where
//	 * @param ordenar el parametro de ordenacion
//	 * @exception SQLException si aparece un error de base de datos
//	 */
//	 public synchronized void listGeneric(Object object,String condicion,String ordenar)throws SQLException{
//	   Object tempGenericObject = null;
//	   String nameTabla = "";
//	   StringTokenizer st;
//	   String Query = "select * "+
//					  "from " ;
//
//	   // Verificar si existe una conexion
//	   if(!isConnect())
//		   throw new SQLException("Sin Conexion");
//
//	   tempGenericObject = this.instanceClass(object);// Instancio la Clase
//	   /**
//		  * Genero la Consulta SQL (Query)
//	   **/
// 
//	   // Obtengo el nombre de la Tabla
//	   st = new StringTokenizer(tempGenericObject.getClass().getName(),".");
//	   while (st.hasMoreElements())
//		   nameTabla=st.nextToken();
//
//	   Query += nameTabla.toLowerCase() + " ";
//
//	   // Verificar si hay una condicion(Where) para filtrar la sentencia Query
//	   if(!condicion.trim().equals(""))
//		   Query += " where(" + condicion + ")";
//	   // Verificar si hay un Orden para la sentencia Query
//	   if(!ordenar.trim().equals("")) 
//		   Query += " order by " + ordenar +" desc";
//
//	   PreparedStatement pstmt = null;
//	   ResultSet rs = null;
//	   try {
//		   // Preparar consulta Sql
//		   pstmt = con.prepareStatement(Query);
//		   // Ejecutar consulta y copiar resultados a la lista
//		   rs = pstmt.executeQuery();
//		   genericList = new LinkedList();
//		   while(rs.next()){
//		     try {
//			     // Realizo instrospeccion para ejecutar el metodo Load
//			     Method[] methods = tempGenericObject.getClass().getDeclaredMethods();
//			     for (int i = 0; i < methods.length; i++){
//			       Method method = methods[i];
//			       if (method.getName().equals("load")){
//				       Object[] args ={rs};
//				       genericList.add(method.invoke(tempGenericObject,args));
//				       break;
//			       }
//			     }
//		     }catch(IllegalAccessException e){
//			     throw new SQLException("Realizando instrospeccion. Metodo [listGeneric()]  :"+e);
//		     }catch(InvocationTargetException e){
//			     throw new SQLException("Realizando instrospeccion. Metodo [listGeneric()]  :"+e);
//		     }
//		   }// End While
//	   }finally{
//		   if(rs!=null)
//		     rs.close();
//		   if(pstmt!=null)
//		     pstmt.close();
//	   }
//	 }
//
//	/**
//	 *  Devuelve los resultados (lista de objetos) de la busqueda
//	 *  de una clase requerida
//	 */
//	 public List getList(){
//	   return genericList;
//	 }
//
//	/**
//	 *  Devuelve los resultados (arreglo de String) de los campos
//	 *  que conforman el Indice Principal de una Tabla en particular
//	 **/
//	protected String[] getPkTable(String nameTable)throws SQLException{
//	  ResultSet rs = null;
//	  PreparedStatement  pstmt = null;
//	  Vector camposPk = null;
//	  String auxCamposPk[] = {};
//	  try {
//		  pstmt = con.prepareStatement("select nomkey "+
//									                      "wrom syskey " +
//									                      "where nomdbf ='"+nameTable.trim().toLowerCase()+"' "+
//									                      "order by ordkey ");
//		  rs = pstmt.executeQuery();
//		  camposPk = new Vector();
//		  while (rs.next()){
//		    camposPk.addElement(rs.getString(1));
//		  }
//		  auxCamposPk = new String[camposPk.size()];
//		  for (int i = 0; i < camposPk.size(); i++)
//		    auxCamposPk[i] = camposPk.elementAt(i).toString().trim();
//	  }catch (Exception e) {
//		  throw new SQLException("Error Metodo [getPkTable()] : "+e);
//	  }finally {
//		  if(rs!=null)
//		    rs.close();
//		  if(pstmt!=null)
//		    pstmt.close();
//	  }
//	  return auxCamposPk;
//	}
//	
//	/**
//	 * Metodo que instancia una clase generica y devuelve
//	 * el objeto instanciado.
//	 * @param object la clase a instanciar
//	 * @exception SQLException si aparece un error de base de datos
//	 */
//	protected Object instanceClass(Object object)throws SQLException{
//	  Object tempGenericObject = null;
//	  try {
//		  // Instancio el Objeto de manera temporal para que no
//		  //se pierda la referncia de la Classe Generica
//		  tempGenericObject=object.getClass().newInstance();
//	  }catch (IllegalAccessException e) {
//		  throw new SQLException("Error Instanciando Clase.Metodo [newRegistro()]  :"+e);
//	  }catch (InstantiationException e) {
//		  throw new SQLException("Error Instanciando Clase.Metodo [newRegistro()]  :"+e);
//	  }
//	  return tempGenericObject;
//	}
// 	
//	/*Metodos asociados al conteo de Evaluados y Matriculados*/
// 	public int numeroEstudiantesMatriculados(String codAsig, int ano, int periodo,int seccion )throws SQLException{
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		
//		int numeroMatriculados=0;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from matricula where codigo_asignatura = ? and ano = ? and periodo = ? and seccion=?" );  		
//    		stm.setString(1,codAsig);
//    		stm.setInt(2,ano);
//    		stm.setInt(3,periodo);
//    		stm.setInt(4,seccion);
//			result=stm.executeQuery();
//			if(result.next())
//					numeroMatriculados = result.getInt(1);
//				}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
// 		return numeroMatriculados;
// 	} 
// 	
// 	public int numeroEstudiantesEvaluacion(String codAsig, int ano, int periodo, int seccion )throws SQLException{
//		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		
//		int numeroRespuestas=0;
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select count(*) from respuesta where codigo_asignatura = ? and ano = ? and periodo = ? and seccion=?" );  		
//    		stm.setString(1,codAsig);
//    		stm.setInt(2,ano);
//    		stm.setInt(3,periodo);
//    		stm.setInt(4,seccion);
//			result=stm.executeQuery();
//			if(result.next())
//					numeroRespuestas = result.getInt(1);
//				}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
// 		return numeroRespuestas;
// 	} 
//	/*Metodos Asociados a las Observaciones*/
// 	public List listaObservaciones(String codAsig, int ano, int periodo, int seccion )throws SQLException{
// 		if(!isConnect())
//	 		throw new SQLException("Sin Conexion");
//
//		
// 		List lista  = new LinkedList();
//		PreparedStatement stm=null;
//		ResultSet result=null;
//
//        try{
//        	stm=con.prepareStatement("select observaciones from respuesta where codigo_asignatura = ? and ano = ? and periodo = ? and seccion=? and observaciones<>''" );  		
//    		stm.setString(1,codAsig);
//    		stm.setInt(2,ano);
//    		stm.setInt(3,periodo);
//    		stm.setInt(4,seccion);
//			result=stm.executeQuery();
//			while(result.next()){
//					lista.add(result.getString(1));
//			}
//				}finally {
//	 		   if(stm!=null)
//	 			   stm.close();
//		}
// 		return lista;
// 		
// 	}
// 	
 	
	
}// fin clase model