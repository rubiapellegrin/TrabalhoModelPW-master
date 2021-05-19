/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarAcessorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        List<Acessorios> lista = em.createQuery("from Acessorios order by id").getResultList();
        for(Acessorios p : lista){
            System.out.println("| ID: " + p.getId() + " | Descricao: " + p.getDescricao() + " | ");
        }

        em.close();
        emf.close();
    }
    
}
