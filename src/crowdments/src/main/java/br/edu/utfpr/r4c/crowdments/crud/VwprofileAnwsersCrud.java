/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.VwProfileanwsers;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ricar
 */
public class VwprofileAnwsersCrud extends FacadeCrud<VwProfileanwsers>{
    private EntityManager em;
    
    public VwprofileAnwsersCrud(){
        super(VwProfileanwsers.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
    
    public List<VwProfileanwsers> byQuestionary(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            
            return getEntityManager().createNamedQuery(VwProfileanwsers.class.getSimpleName()+".findByQuestionary").setParameter("questionary", id).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<VwProfileanwsers> byProfile(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            
            return getEntityManager().createNamedQuery(VwProfileanwsers.class.getSimpleName()+".findByProfile").setParameter("questionary", id).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<VwProfileanwsers> byProfileMail (String mail, Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            Query q = getEntityManager().createNamedQuery(VwProfileanwsers.class.getSimpleName()+".findByMail");
            q.setParameter("questionary", id);
            q.setParameter("mail", mail);
            
            return q.getResultList();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
