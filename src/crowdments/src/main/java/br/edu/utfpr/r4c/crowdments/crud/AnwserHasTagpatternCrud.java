/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.AnwserHasTagpattern;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class AnwserHasTagpatternCrud extends FacadeCrud<AnwserHasTagpattern>{
    private EntityManager em;
    
        public AnwserHasTagpatternCrud(){
        super(AnwserHasTagpattern.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
    
    
    
    public List<AnwserHasTagpattern> byTag(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            return (List<AnwserHasTagpattern>) getEntityManager().createNamedQuery(AnwserHasTagpattern.class.getSimpleName().toString() +".findByTagPattern").setParameter("id", id).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}