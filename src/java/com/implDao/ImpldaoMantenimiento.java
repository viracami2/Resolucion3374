
package com.implDao;


import com.dao.IDao;
import com.entity.Mantenimiento;
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
public class ImpldaoMantenimiento implements IDao<Mantenimiento> {
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
    public void create(Mantenimiento producto) {
            PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("Insert Into mantenimiento values(?,?,?,?,?)");
          pst.setString(1,producto.getCodman());
          pst.setString(2,producto.getDir());
          pst.setString(3,producto.getCodtec());
          pst.setString(4,producto.getCosto());
          pst.setString(5,producto.getCodmaqui());
          
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Mantenimiento consultar(String cod) {
         ResultSet rs = null;
         PreparedStatement pst = null;
         Mantenimiento mante = null;
     try {
         pst = dataSource.getConnection().prepareStatement("select * from mantenimiento where codman = ?");
         pst.setString(1, ""+cod);
         rs = pst.executeQuery();
         while(rs.next()) {
             mante = Mantenimiento.load(rs);
         }
    } finally {
         if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
         if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
          return mante;
    }
    }

    @Override
    public List<Mantenimiento> selectAll() {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Mantenimiento> listamante = new LinkedList();
     try {
        pst = dataSource.getConnection().prepareStatement("select * from mantenimiento ");
        rs = pst.executeQuery();
        while(rs.next()) {
           listamante.add(Mantenimiento.load(rs));
        }
    }   catch (SQLException ex) {
            Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
    }return listamante;
    }
    @Override
    public void delete(Mantenimiento p) {
               PreparedStatement pst = null;
     try {
          pst = dataSource.getConnection().prepareStatement("delete from mantenimiento where codman= ?");
          pst.setString(1,p.getCodman());
          pst.executeUpdate();
    }   catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Mantenimiento entity) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
