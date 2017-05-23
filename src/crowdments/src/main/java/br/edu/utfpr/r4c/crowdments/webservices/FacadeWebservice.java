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
import javax.ws.rs.DELETE;
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
    List records = fac.getAll();
    return records;
  }

  @GET 
  @Path("{id}")
  public T getSingle(@PathParam("id") int id) {
    T record = fac.byId(id);
    return record; 
  }

  @DELETE 
  @Path("{id}")
  public ReturnStatus remove(@PathParam("id") int id) {
    T record = fac.byId(id);
    fac.remove(record);
    
    ReturnStatus rs = new ReturnStatus();
    rs.setStatus(200);
    rs.setInfo(record.getClass().getSimpleName() + " removed");
    rs.setCod(id);
    rs.setObject(entityClass);
    
    return rs;
  }
  
  @POST
  public ReturnStatus insert(T t) {
    fac.persist(t);
    
    ReturnStatus rs = new ReturnStatus();
    rs.setStatus(200);
    rs.setInfo(t.getClass().getSimpleName() + " inserted");
    rs.setObject(t);
    
    return rs;
  }
  protected void setManager(FacadeCrud<T> fac){
      this.fac = fac;
  }        
}
