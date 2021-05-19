/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MASTER
 */
public class TestePersirtirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario car = new Usuario();
        car.setNomeUsuario("nedi");
        car.setSenha("senha");
        Permissao p1 = em.find(Permissao.class, "ADMINISTRADOR");
        Permissao p2 = em.find(Permissao.class, "USUARIO");
        car.getPermissoes().add(p1);
        car.getPermissoes().add(p2);

        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
