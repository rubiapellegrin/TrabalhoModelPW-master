/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirCarro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Carro car = new Carro();
        Pessoa pe = em.find(Pessoa.class, 13);

        car.setPlaca("placa3");
        car.setRenavam("55553");
        car.setModelo("branco");
        car.setFabricante("chevrolet");
        car.setAnoFabricaco(2215);
        car.setAnoModelo(1452);
        car.setPessoa(pe);

        Acessorios acessorio1 = em.find(Acessorios.class, 7);

        car.getAcessorios().add(acessorio1);


        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
