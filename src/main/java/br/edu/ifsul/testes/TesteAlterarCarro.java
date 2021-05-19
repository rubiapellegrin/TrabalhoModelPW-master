/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteAlterarCarro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Carro car = em.find(Carro.class, 4);
        car.setPlaca("iso581");
        car.setRenavam("15155");
        car.setModelo("preto");
        car.setFabricante("fiat");
        car.setAnoFabricaco(22);
        car.setAnoModelo(52);
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
        em.close();
        emf.close();
 
    
    }
    
}
