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
import br.edu.ifsul.modelo.Sinistro;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirSinistro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Sinistro sin = new Sinistro();
        sin.setDescricao("seilaoqueesinistro2");
        Calendar cal = Calendar.getInstance();
        sin.setData(cal);
        sin.setCidade("Porto alegre");
        sin.setEstado("RS");
        sin.setSeguro(em.find(Seguro.class, 4));
        em.getTransaction().begin();
        em.persist(sin);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
