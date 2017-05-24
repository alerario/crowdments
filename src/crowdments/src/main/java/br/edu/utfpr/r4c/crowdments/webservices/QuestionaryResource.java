package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.QuestionaryCrud;
import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import javax.ws.rs.Path;
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
}