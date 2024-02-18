package com.abdiel.livraria.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_LIVRO_MODEL")

public class LivroModel implements Serializable {
    int anoEdicao, quantidadePaginas;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String nome;
    String sobrenome, titulo, editora;
    Long isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome(String nome) {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getSobrenome(String sobrenome) {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTitulo(String titulo) {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora(String editora) {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Long getIsbn(Long isbn) {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public int getAnoEdicao(int anoEdicao) {
        return anoEdicao;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public int getQuantidadePaginas(int quantidadePaginas) {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

}
