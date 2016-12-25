
package com.implDao;


import com.dao.IDao;
import com.entity.Tecnico;
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
public class ImpldaoTecnico implements IDao<Tecnico> {
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
    public void create(Tecnico tec) {
            PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("Insert Into tecnico values(?,?,?)");
          pst.setString(1,tec.getCodigo());
          pst.setString(2,tec.getNombre());
          pst.setString(3,tec.getEspecialidad());
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Tecnico consultar(String cod) {
         ResultSet rs = null;
         PreparedStatement pst = null;
         Tecnico tec = null;
     try {
         pst = dataSource.getConnection().prepareStatement("select * from tecnico where codigo = ?");
         pst.setString(1, ""+cod);
         rs = pst.executeQuery();
         while(rs.next()) {
             tec = Tecnico.load(rs);
         }
    } finally {
         if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
         if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
          return tec;
    }
    }

    @Override
   
    
    public List<Tecnico> selectAll() {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Tecnico> listatecnicos = new LinkedList();
     try {
        pst = dataSource.getConnection().prepareStatement("select * from tecnico ");
        rs = pst.executeQuery();
        while(rs.next()) {
           listatecnicos.add(Tecnico.load(rs));
        }
    }   catch (SQLException ex) {
        ex.printStackTrace();
            //Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
    }return listatecnicos;
    }
    @Override
    public void delete(Tecnico p) {
               PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("delete from tecnico where codigo= ?");
          pst.setString(1,p.getCodigo());
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTecnico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Tecnico entity) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
