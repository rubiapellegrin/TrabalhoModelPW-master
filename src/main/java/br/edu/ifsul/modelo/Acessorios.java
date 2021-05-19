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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "acessorios")

public class Acessorios implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_acessorios", sequenceName = "seq_acessorios_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorios", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descricao não ser em branco!")
    @Length(max = 50, message = "A descricao não pode ter mais que [max] caracteres.")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;


    public Acessorios() {

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
