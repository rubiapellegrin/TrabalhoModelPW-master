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
public class FabricaObjetosSeguros {

        public static List<Seguro> carregaSeguro(){
       
        List<Seguro> lista = new ArrayList<>();
        Seguro seg = new Seguro();
        
        Corretor co = new Corretor();
        co.setNome("Olair");
        co.setCpf("03899910079");
        co.setEmail("julio96@gmail");
        co.setRg("548151");
        co.setTelefone("98595652");
        co.setCpf("03899910079");
        co.setPercentualComissao(12.5);
        co.setNomeUsuario("rub");
        co.setSenha("Olair");
        
        Carro carro = new Carro();
        carro.setId(1);
        carro.setAnoFabricaco(1689);
        carro.setAnoModelo(2);
        carro.setFabricante("volksvagem");
        carro.setModelo("novo");
        carro.setPlaca("fbhg154");
        carro.setRenavam("niufdghu");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fabricio");
        pessoa.setCpf("03899910079");
        pessoa.setRg("514251251");
        pessoa.setEmail("rubia@gmail.com");
        pessoa.setTelefone("424452452");
        carro.setPessoa(pessoa);
        
        Acessorios ace = new Acessorios();
        ace.setId(1);
        ace.setDescricao("parabrisa");
        carro.getAcessorios().add(ace);

        
        Cobertura cober = new Cobertura();
        cober.setId(2);
        cober.setDescricao("iso581");

        Calendar cal = Calendar.getInstance();
        seg.setId(3);
        seg.setData(cal);
        seg.setInicioVigencia(cal);
        seg.setFimVigencia(cal);
        seg.setValorTotal(12.4);
        seg.setValorFipe(10.3);
        seg.setCarro(carro);
        seg.setCorretor(co);
        seg.getCoberturas().add(cober);
        
        lista.add(seg);
        
        
        return lista;
        
        
    }  
}
