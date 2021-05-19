/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarSeguro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Seguro> lista = em.createQuery("from Seguro order by id").getResultList();
        for(Seguro p : lista){
            
            System.out.println("| ID: " + p.getId() + " | Data: " + s.format(p.getData().getTime()) + 
                    " | Inicio de vigencia: " + s.format(p.getInicioVigencia().getTime()) + " | Fim da vigencia: " + s.format(p.getFimVigencia().getTime()) + 
                    " | Valor Total: " + p.getValorTotal() + " | Valor da fipe: " + p.getValorFipe() + 
                    " | Placa do carro: " + p.getCarro().getPlaca()  + " | Corretor:  " + p.getCorretor().getNome() + " | ");
        }

        em.close();
        emf.close();
    }
    
}
