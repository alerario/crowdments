/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Tagpattern;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class TagPatternCrud extends FacadeCrud<Tagpattern>{
    private EntityManager em;
    
    public TagPatternCrud(){
        super(Tagpattern.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
    
    public Tagpattern byTag(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            return (Tagpattern) getEntityManager().createNamedQuery(Tagpattern.class.getSimpleName().toString() +".findById").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
