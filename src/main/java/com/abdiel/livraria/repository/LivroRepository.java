package com.abdiel.livraria.repository;

import com.abdiel.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select l from Livro l where l.isbn = :isbn")
    Optional<Livro> findByIsbn(Long isbn);

}
