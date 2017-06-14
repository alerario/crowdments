/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.TaskCrud;
import br.edu.utfpr.r4c.crowdments.entities.Task;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/task")
@Produces("application/json")
public class TaskResource extends FacadeWebservice<Task>{
    private TaskCrud cr;    
                   
    public TaskResource(){
        super(Task.class);
        cr = new TaskCrud();
        this.setManager(cr);
    }     
}
