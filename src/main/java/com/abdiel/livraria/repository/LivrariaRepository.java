package com.abdiel.livraria.repository;

import com.abdiel.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrariaRepository extends JpaRepository<Livro, Long> {

    String nome = " ";
    String sobrenome = "";
    String titulo = "";
    String editora = "";
    String isbn = "";
}
