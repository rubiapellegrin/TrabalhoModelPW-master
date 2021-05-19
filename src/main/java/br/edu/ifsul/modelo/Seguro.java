/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name = "seguro")
public class Seguro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @Temporal(TemporalType.DATE)
    @Column(name = "inicioVigencia", nullable = false)
    private Calendar inicioVigencia;
    @Temporal(TemporalType.DATE)
    @Column(name = "fimVigencia", nullable = false)
    private Calendar fimVigencia;
    @NotNull(message = "O valor total deve ser informado!")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "numeric(5,2)")
    private Double valorTotal;
    @NotNull(message = "O valor da fipe deve ser informado!")
    @Column(name = "valorFipe", nullable = false, columnDefinition = "numeric(5,2)")
    private Double valorFipe;
    @NotNull(message = " O corretor deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "corretor", referencedColumnName = "id", nullable = false)
    private Corretor corretor;
    @NotNull(message = " A carro deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    private Carro carro;
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sinistro> sinistros = new ArrayList<>();
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cobertura> coberturas = new ArrayList<>();

    public Seguro() {

    }
    public void adicionarCobertura(Cobertura obj){
        obj.setSeguro(this);
        this.coberturas.add(obj);
    }
    
    public void removerCobertura(int index){
        this.coberturas.remove(index);
    }

    
    public void adicionarSinistro(Sinistro obj) {
        obj.setSeguro(this);
        this.sinistros.add(obj);
    }

    public void removerSinistro(int index) {
        this.sinistros.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Sinistro> getSinistros() {
        return sinistros;
    }

    public void setSinistros(List<Sinistro> sinistros) {
        this.sinistros = sinistros;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }

}
