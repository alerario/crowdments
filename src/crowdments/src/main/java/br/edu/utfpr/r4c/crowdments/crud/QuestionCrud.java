package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Question;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class QuestionCrud extends FacadeCrud<Question>{
    private EntityManager em;
    
    public QuestionCrud(){
        super(Question.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
}
