/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.FacadeCrud;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Produces("application/json")
public abstract class FacadeWebservice<T> {
  protected FacadeCrud<T> fac;
  private Class<T> entityClass;
  
  public FacadeWebservice(Class<T> entityClass) {
    this.entityClass = entityClass;
  }
  
  @GET
  public List<T> getList() throws SQLException, NamingException, NullPointerException{ 
    System.out.println("Class: "+ entityClass.getSimpleName());
    
    System.out.println("No. "+fac.getAll().size());
    List records = fac.getAll();
    return records;
  }

  @GET 
  @Path("{id}")
  public T getSingle(@PathParam("id") int id) {
    T record = fac.byId(id);
    return record; 
  }

  @POST 
  public void insertTix(T t) {
    fac.remove(t);
  }
  
  protected void setManager(FacadeCrud<T> fac){
      this.fac = fac;
  }
        
}
