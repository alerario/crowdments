/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.webservices.ReturnStatus;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricar
 */
public abstract class FacadeCrud<T> {
    //Objeto da classe referência
    private Class<T> entityClass;

    //construtor que recebe a tipagem da mesma
    public FacadeCrud(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    //método abstrato para obter o EM na implementação
    protected abstract EntityManager getEntityManager();

    //salvar e persistir o objeto
    public T persist(T entity) {
    	try{
    	    getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
            
            return entity;
    	}catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
                return null;
        }         
    }

    public T merge(T entity) {
    	try{
    	    getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            
            return entity;
    	}catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
                return null;
    	}                
    }

    public ReturnStatus remove(T entity) {
    	try{
    	    getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().getTransaction().commit();
            
            ReturnStatus rs = new ReturnStatus();
            rs.setCod(200);
            rs.setObject(entity);
            rs.setInfo(entity.getClass().getName() + " was removed");
            
            return rs;
    	}
    	catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
                return null;
    	}            
    }

    //encontrar por objeto
    public T find(Object id) {
        getEntityManager().getTransaction().begin();
        return getEntityManager().find(entityClass, id);
    }
    
    //encontrar por identificador
    public T byId(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            return (T) getEntityManager().createNamedQuery(this.entityClass.getSimpleName().toString() +".findById").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //obter todos entity
    public List<T> getAll() {
        try{
            getEntityManager().getTransaction().begin();
	    return getEntityManager().createNamedQuery(this.entityClass.getSimpleName().toString() +".findAll").getResultList();
        }catch(Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
