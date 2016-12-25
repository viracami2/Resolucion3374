
package com.implDao;


import com.dao.IDao;
import com.entity.Maquina;

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
public class ImpldaoMaquina implements IDao<Maquina> {
private DataSource dataSource=DataUtil.getDs();

    @Override
    public void setDataSource(DataSource ds) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

   

  

   
    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void create(Maquina maqui) {
            PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("Insert Into maquina values(?,?,?)");
          pst.setString(1,maqui.getCod());
          pst.setString(2,maqui.getTipo());
          pst.setString(3,maqui.getDescrip());
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Maquina consultar(String cod) {
         ResultSet rs = null;
         PreparedStatement pst = null;
         Maquina maqui = null;
     try {
         pst = dataSource.getConnection().prepareStatement("select * from maquina where cod = ?");
         pst.setString(1, ""+cod);
         rs = pst.executeQuery();
         while(rs.next()) {
             maqui = Maquina.load(rs);
         }
    } finally {
         if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
         if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
          return maqui;
    }
    }

    @Override
    public List<Maquina> selectAll() {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Maquina> listamaqui = new LinkedList();
     try {
        pst = dataSource.getConnection().prepareStatement("select * from maquina ");
        rs = pst.executeQuery();
        while(rs.next()) {
           listamaqui.add(Maquina.load(rs));
        }
    }   catch (SQLException ex) {
            Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
    }return listamaqui;
    }
    @Override
    public void delete(Maquina p) {
               PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("delete from maquina where cod= ?");
          pst.setString(1,p.getCod());
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Maquina entity) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
