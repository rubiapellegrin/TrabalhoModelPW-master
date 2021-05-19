/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirSeguro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Seguro seg = new Seguro();

        Corretor co = em.find(Corretor.class, 14);
        Carro ca = em.find(Carro.class, 9);

        Calendar cal = Calendar.getInstance();
        seg.setData(cal);
        seg.setInicioVigencia(cal);
        seg.setFimVigencia(cal);
        seg.setValorTotal(12.4);
        seg.setValorFipe(10.3);
        seg.setCarro(ca);
        seg.setCorretor(co);

        em.getTransaction().begin();
        em.persist(seg);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
