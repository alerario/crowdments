package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class QuestionaryCrud extends FacadeCrud<Questionary>{
    private EntityManager em;
    
    public QuestionaryCrud(){
        super(Questionary.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
}
