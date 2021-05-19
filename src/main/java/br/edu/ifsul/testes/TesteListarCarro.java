/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

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
public class TesteListarCarro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        List<Carro> lista = em.createQuery("from Carro order by id").getResultList();
        for(Carro p : lista){
            System.out.println("| ID: " + p.getId() + " | Placa: " + p.getPlaca() + 
                    " | Renavam: " + p.getRenavam() + " | Modelo: " + p.getModelo() + 
                    " | Fabricante: " + p.getFabricante() + " | Ano de fabricação: " + p.getAnoFabricaco() + 
                    " | Ano do modelo: " + p.getAnoModelo() + " | ");
        }

        em.close();
        emf.close();
    }
    
}
