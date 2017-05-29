package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.QuestionaryCrud;
import br.edu.utfpr.r4c.crowdments.crud.VwAgeCrud;
import br.edu.utfpr.r4c.crowdments.entities.VwUsersex;
import br.edu.utfpr.r4c.crowdments.entities.VwUserswithanwsersMail;
import java.util.List;
import br.edu.utfpr.r4c.crowdments.crud.VwUsersexCrud;
import br.edu.utfpr.r4c.crowdments.crud.VwUserswithanwsersMailCrud;
import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import br.edu.utfpr.r4c.crowdments.entities.VwAge;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/questionary")
@Produces("application/json")
public class QuestionaryResource extends FacadeWebservice<Questionary>{
    private QuestionaryCrud cr;
                       
    public QuestionaryResource(){
        super(Questionary.class);
        cr = new QuestionaryCrud();
        this.setManager(cr);
    }       
    
    @GET
    @Path("{id}/emails")
    public List<VwUserswithanwsersMail> getEmails(@PathParam("id") int id) {
        VwUserswithanwsersMailCrud vwCrud = new VwUserswithanwsersMailCrud();
        List<VwUserswithanwsersMail> record = vwCrud.getEmails(id);
        return record;
    }
    
    @GET
    @Path("{id}/sex")
    public List<VwUsersex> getAllSex(@PathParam("id") int id) {
        VwUsersexCrud vwCrud = new VwUsersexCrud();
        List<VwUsersex> record = vwCrud.allSex(id);
        return record;
    }
    
    @GET
    @Path("{id}/age")
    public List<VwAge> getAge(@PathParam("id") int id) {
        VwAgeCrud vwCrud = new VwAgeCrud();
        List<VwAge> record = vwCrud.getAll();
        return record;
    }
        
    @GET
    @Path("{id}/sex/{sex}")
    public List<VwUsersex> getSex(@PathParam("id") int id, @PathParam("sex") String sex) {
        VwUsersexCrud vwCrud = new VwUsersexCrud();
        List<VwUsersex> record = vwCrud.byQuestionary(id, sex);
        return record;
    }
}