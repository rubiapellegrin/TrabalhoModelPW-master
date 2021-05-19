/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rubia
 */
public class FabricaObjetosCorretor {

        public static List<Corretor> carregaCorretor(){
       
        List<Corretor> lista = new ArrayList<>();
        
        Corretor co = new Corretor();
        co.setId(8);
        co.setNome("rubia");
        co.setCpf("03899910079");
        co.setEmail("julio96@gmail");
        co.setRg("548151");
        co.setTelefone("98595652");
        co.setPercentualComissao(12.5);
        co.setNomeUsuario("rub");
        co.setSenha("rubia");
        
        lista.add(co); 
        return lista;
        
        
    }  
}
