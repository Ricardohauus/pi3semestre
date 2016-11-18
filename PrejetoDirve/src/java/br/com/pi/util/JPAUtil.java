/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo
 */
public class JPAUtil {
    public  static  EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoIntegradorClinica");
        return  factory.createEntityManager();
        
    }
}
