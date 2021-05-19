/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Corretor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirCorretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();

        Corretor co = new Corretor();
        co.setNome("rubia");
        co.setCpf("03899910079");
        co.setEmail("julio96@gmail");
        co.setRg("548151");
        co.setTelefone("98595652");
        co.setCpf("03899910079");
        co.setPercentualComissao(12.5);
        co.setNomeUsuario("rub");
        co.setSenha("rubia");
        em.getTransaction().begin();
        em.persist(co);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
