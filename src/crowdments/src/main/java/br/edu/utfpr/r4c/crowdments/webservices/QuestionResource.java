/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.QuestionCrud;
import br.edu.utfpr.r4c.crowdments.entities.Question;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/question")
@Produces("application/json")
public class QuestionResource extends FacadeWebservice<Question>{
    private QuestionCrud cr;
                       
    public QuestionResource(){
        super(Question.class);
        cr = new QuestionCrud();
        this.setManager(cr);
    }       
}

