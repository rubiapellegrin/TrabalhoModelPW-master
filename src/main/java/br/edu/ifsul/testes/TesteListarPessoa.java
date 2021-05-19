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
public class TesteListarPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        List<Pessoa> lista = em.createQuery("from Pessoa order by id").getResultList();
        for(Pessoa p : lista){
            System.out.println("| ID: " + p.getId() + " | Nome: " + p.getNome() + 
                    " | Cpf: " + p.getCpf() + " | Rg: " + p.getRg() + " | Email: " + p.getEmail() +
                    " | Telefone: " + p.getTelefone() + " | ");
        }

        em.close();
        emf.close();
    }
    
}
