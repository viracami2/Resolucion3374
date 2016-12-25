/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;



import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author admin
 */
public interface IDao<T>{
    
  void setDataSource(DataSource ds);

  void create(T entity)throws SQLException;

  T consultar(String id);

  
  List<T> selectAll();

  void delete(T p);

  void modificar(T entity);
}
