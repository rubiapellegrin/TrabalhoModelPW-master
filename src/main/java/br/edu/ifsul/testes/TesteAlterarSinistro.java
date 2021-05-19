/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteAlterarSinistro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Sinistro sin = em.find(Sinistro.class, 6);
        sin.setDescricao("iso581");
        sin.setCidade("pascoa");
        em.getTransaction().begin();
        em.merge(sin);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
