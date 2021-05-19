/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A placa não pode ser em branco!")
    @Length(max = 10, message = "A placa não pode ter mais que [max] caracteres.")
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;
    @NotBlank(message = "A renavam não pode ser em branco!")
    @Length(max = 20, message = "A renavam não pode ter mais que [max] caracteres.")
    @Column(name = "renavam", nullable = false, length = 20)
    private String renavam;
    @NotBlank(message = "A modelo não pode ser em branco!")
    @Length(max = 50, message = "A modelo não pode ter mais que [max] caracteres.")
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    @NotBlank(message = "A fabricante deve ser informado!")
    @Length(max = 50, message = "A fabricante não pode ter mais que [max] caracteres.")
    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;
    @NotNull(message = "O ano de fabricacao deve ser informado!")
    @Column(name = "anoFabricaco", nullable = false)
    private Integer anoFabricaco;
    @NotNull(message = "O ano do modelo deve ser informado!")
    @Column(name = "anoModelo", nullable = false)
    private Integer anoModelo;
    @NotNull(message = " A pessoa deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "Pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "acessorios_carro",
            joinColumns
            = @JoinColumn(name = "placa_carro", referencedColumnName = "placa",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "descricao_acessorio", referencedColumnName = "descricao", nullable = false))

    //List<Acessorios> acessorios = new new ArrayList<>();
    private Set<Acessorios> acessorios = new HashSet<>();
    
    public Carro() {

    }
    
    public void adicionarAcessorio(Acessorios obj){
        //obj.setCarro(this);
        this.acessorios.add(obj);
        
    }
    

    public void removerAcessorios(int index){
        this.acessorios.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricaco() {
        return anoFabricaco;
    }

    public void setAnoFabricaco(Integer anoFabricaco) {
        this.anoFabricaco = anoFabricaco;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }

}
