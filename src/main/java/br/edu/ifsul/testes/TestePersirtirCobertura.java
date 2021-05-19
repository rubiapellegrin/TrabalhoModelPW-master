/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Seguro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirCobertura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Cobertura cober = new Cobertura();
        cober.setDescricao("seilaoqueecobertura2");
        cober.setValor(12.5);
        cober.setSeguro(em.find(Seguro.class, 10));
        em.getTransaction().begin();
        em.persist(cober);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
