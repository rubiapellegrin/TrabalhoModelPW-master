/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteAlterarSeguro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Seguro seg = em.find(Seguro.class, 12);

        Calendar cal = Calendar.getInstance();
        seg.setData(cal);
        seg.setInicioVigencia(cal);
        seg.setFimVigencia(cal);
        seg.setValorTotal(6.4);
        seg.setValorFipe(5.6);

        em.getTransaction().begin();
        em.merge(seg);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
