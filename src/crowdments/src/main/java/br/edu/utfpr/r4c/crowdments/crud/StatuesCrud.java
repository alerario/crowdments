package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Statues;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class StatuesCrud extends FacadeCrud<Statues>{
    private EntityManager em;
    
    public StatuesCrud(){
        super(Statues.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
}