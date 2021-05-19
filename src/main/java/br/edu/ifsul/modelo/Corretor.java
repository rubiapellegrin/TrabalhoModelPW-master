/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MASTER
 */
@Entity
@Table(name = "corretor")
public class Corretor extends Pessoa implements Serializable {

    
    @Column(name = "percentualComissao", nullable = false, columnDefinition="numeric(5,2)") 
    private double percentualComissao;
    @NotBlank(message = "O nome de usuario não pode ser em branco. ")
    @Length(max = 50, message = "O nome de usuario não pode ter mais que {max}  caracteres. ")
    @Column(name = "nomeUsuario", nullable = false, length = 50)
    private String nomeUsuario;
    @NotBlank(message = "A senha não pode ser em branco. ")
    @Length(max = 50, message = "O senha não pode ter mais que {max}  caracteres. ")
    @Column(name = "senha", nullable = false, length = 50)
    private String senha;

    public Corretor() {

    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
