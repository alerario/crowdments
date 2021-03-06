package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.AnwProfileCrud;
import br.edu.utfpr.r4c.crowdments.crud.VwprofileAnwsersCrud;
import br.edu.utfpr.r4c.crowdments.entities.Anwserprofilequestion;
import br.edu.utfpr.r4c.crowdments.entities.VwProfileanwsers;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
/**
 *
 * @author ricar
 */
@Path("/anwser")
@Produces("application/json")
public class AnwProfileResource extends FacadeWebservice<Anwserprofilequestion> {

    private AnwProfileCrud cr;

    public AnwProfileResource() {
        super(Anwserprofilequestion.class);
        cr = new AnwProfileCrud();
        this.setManager(cr);
    }

    @GET
    @Path("byQuestionary/{id}")
    public List<VwProfileanwsers> getAnwsers(@PathParam("id") int id) {
        VwprofileAnwsersCrud vwCrud = new VwprofileAnwsersCrud();
        List<VwProfileanwsers> record = vwCrud.byQuestionary(id);
        return record;
    }
    
    @GET
    @Path("byQuestionary/{id}/{mail}")
    public List<VwProfileanwsers> getAnwsersByMail(@PathParam("id") int id, @PathParam("mail") String mail) {
        VwprofileAnwsersCrud vwCrud = new VwprofileAnwsersCrud();
        List<VwProfileanwsers> record = vwCrud.byProfileMail(mail, id);
        return record;
    }
    
}
