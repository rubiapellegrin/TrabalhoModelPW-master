/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TesteListarCorretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        List<Corretor> lista = em.createQuery("from Corretor order by id").getResultList();
        for(Corretor p : lista){
            System.out.println("| ID: " + p.getId() + " | Nome: " + p.getNome() + 
                    " | Cpf: " + p.getCpf() + " | Rg: " + p.getRg()+ " | Email: " + p.getEmail() + 
                    " | Telefone: " + p.getTelefone() + " | Percentual de comissao: " + p.getPercentualComissao() +
                    " | Nome de usuario: " + p.getNomeUsuario() + " | Senha: " + p.getSenha() + " | ");
        }

        em.close();
        emf.close();
    }
    
}
