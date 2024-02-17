package com.abdiel.livraria.entities;

import jakarta.persistence.*;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor

public class Livro {


    int anoEdicao, quantidadePaginas;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String nome;
    String sobrenome, titulo, editora, isbn;


    public Livro(String nome, String sobrenome, String titulo, String editora, String isbn, int anoEdicao, int quantidadePaginas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.anoEdicao = anoEdicao;
        this.quantidadePaginas = quantidadePaginas;
    }

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

    public String getIsbn(String isbn) {
        return isbn;
    }

    public void setIsbn(String isbn) {
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


    @Override
    public String toString() {
        return super.toString();
    }
}
