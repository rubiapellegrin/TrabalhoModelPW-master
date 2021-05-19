/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rubia
 */
public class FabricaObjetos {
    
    public static List<Carro> carregaCarro(){
        List<Carro> lista = new ArrayList<>();
        
        Carro carro = new Carro();
        carro.setId(1);
        carro.setAnoFabricaco(1689);
        carro.setAnoModelo(2);
        carro.setFabricante("volksvagem");
        carro.setModelo("novo");
        carro.setPlaca("fbhg154");
        carro.setRenavam("niufdghu");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("julio");
        pessoa.setCpf("03899910079");
        pessoa.setRg("514251251");
        pessoa.setEmail("rubia@gmail.com");
        pessoa.setTelefone("424452452");
        carro.setPessoa(pessoa);
        
        Acessorios ace = new Acessorios();
        ace.setId(1);
        ace.setDescricao("parabrisa");

        carro.getAcessorios().add(ace);
        
        lista.add(carro);
        
        
        return lista;
        
        
    }
    
}
