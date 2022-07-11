package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String endereco, String numero, String bairro, String cidade, String estado) {
        setId(id);
        setLogradouro(logradouro);
        setEndereco(endereco);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco1 = (Endereco) o;
        return Objects.equals(id, endereco1.id) && Objects.equals(logradouro, endereco1.logradouro) && Objects.equals(endereco, endereco1.endereco) && Objects.equals(numero, endereco1.numero) && Objects.equals(bairro, endereco1.bairro) && Objects.equals(cidade, endereco1.cidade) && Objects.equals(estado, endereco1.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logradouro, endereco, numero, bairro, cidade, estado);
    }

    @Override
    public String toString() {
        return "Endereco {" + "id: " + getId() + ", Logradouro: " + getLogradouro() + ", Endereco: " + getEndereco() + ", Numero: " + getNumero() + ", Bairro: " + getBairro() + ", Cidade: " + getCidade() + ", Estado: " + getEstado() + '}';
    }

}
