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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name = "sinistro")
public class Sinistro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_sinistro", sequenceName = "seq_sinistro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_sinistro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descricao não pode ser em branco!")
    @Length(max = 50, message = "A descricao não pode ter mais que [max] caracteres.")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    @NotBlank(message = "A data não pode ser em branco!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotBlank(message = "A cidade não pode ser em branco!")
    @Length(max = 50, message = "A cidade não pode ter mais que [max] caracteres.")
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @NotBlank(message = "O estado não pode ser em branco!")
    @Length(max = 50, message = "O estado não pode ter mais que [max] caracteres.")
    @Column(name = "estado", nullable = false)
    private String estado;
    @NotNull(message = "O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "seguro", referencedColumnName = "id", nullable = false)
    private Seguro seguro;

    public Sinistro() {

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

    public Calendar getData() {
        return data;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}
