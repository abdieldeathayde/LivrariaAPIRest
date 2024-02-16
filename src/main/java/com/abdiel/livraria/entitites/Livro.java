package com.abdiel.livraria.entitites;

public class Livro {

    String nome, sobrenome, titulo, editora, isbn;
    int anoEdicao, quantidadePaginas;

    public Livro(String nome, String sobrenome, String titulo, String editora, String isbn, int anoEdicao, int quantidadePaginas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.anoEdicao = anoEdicao;
        this.quantidadePaginas = quantidadePaginas;
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


}
