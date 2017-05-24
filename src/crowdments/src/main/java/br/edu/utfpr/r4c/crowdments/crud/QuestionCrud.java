/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
