/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Sinistro;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarSinitro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        List<Sinistro> lista = em.createQuery("from Sinistro order by id").getResultList();
        for (Sinistro p : lista) {
            System.out.println("| ID: " + p.getId() + " | Descricao: " + p.getDescricao()
                    + " | Data: " + s.format(p.getData().getTime()) + " | Cidade: " + p.getCidade() + " | Estado: " + p.getEstado() + " | ");
        }

        em.close();
        emf.close();
    }

}
