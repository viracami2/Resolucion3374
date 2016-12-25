/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.implDao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import javax.annotation.Resource;

/**
 *
 * @author Usuario
 */
public class DataUtil {
    
   // @Resource(name="java:comp/jdbc/practica")  
    private static DataSource ds; 

    static {
        try // private static EntityManagerFactory emf;
        {
            Context ctx = new InitialContext();
            setDs((DataSource)ctx.lookup("java:comp/env/jdbc/Resolucion3374"));
        } catch (NamingException ex) {
            Logger.getLogger(DataUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * @return the ds
     */
    public static DataSource getDs() {
        return ds;
    }

    /**
     * @param aDs the ds to set
     */
    public static void setDs(DataSource aDs) {
        ds = aDs;
    }
}
