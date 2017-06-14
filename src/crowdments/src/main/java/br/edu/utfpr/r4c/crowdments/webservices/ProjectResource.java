/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.ProjectCrud;
import br.edu.utfpr.r4c.crowdments.crud.TaskCrud;
import br.edu.utfpr.r4c.crowdments.entities.Project;
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
@Path("/project")
@Produces("application/json")
public class ProjectResource extends FacadeWebservice<Project>{
    private ProjectCrud cr;    
                   
    public ProjectResource(){
        super(Project.class);
        cr = new ProjectCrud();
        this.setManager(cr);
    }     
    
    @GET
    @Path("{id}/tasks/todo")
    public List<Task> getTodo(@PathParam("id") int id) {
        TaskCrud vwCrud = new TaskCrud();
        List<Task> record = vwCrud.byProjectToDo(id);
        return record;
    }
    
    @GET
    @Path("{id}/tasks/doing")
    public List<Task> getDoing(@PathParam("id") int id) {
        TaskCrud vwCrud = new TaskCrud();
        List<Task> record = vwCrud.byProjectToDoing(id);
        return record;
    }
    
    @GET
    @Path("{id}/tasks/done")
    public List<Task> getDone(@PathParam("id") int id) {
        TaskCrud vwCrud = new TaskCrud();
        List<Task> record = vwCrud.byProjectToDone(id);
        return record;
    }
}
