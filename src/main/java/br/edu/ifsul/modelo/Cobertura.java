/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "cobertura")
public class Cobertura implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cobertura", sequenceName = "seq_cobertura_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cobertura", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descricao não pode ser em branco!")
    @Length(max = 50, message = "A descricao não pode ter mais que [max] caracteres.")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @NotNull(message = "O valor deve ser informado!")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(5,2)")
    private Double valor;
    @NotNull(message = "O seguro deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "seguro", referencedColumnName = "id", nullable = false)
    private Seguro seguro;

    public Cobertura() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Cobertura other = (Cobertura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}
