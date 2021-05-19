/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa pe = new Pessoa();
        pe.setNome("julio");
        pe.setCpf("03899910079");
        pe.setEmail("julio96@gmail");
        pe.setRg("548151");
        pe.setTelefone("98595652");
        em.getTransaction().begin();
        em.persist(pe);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
