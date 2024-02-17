package com.abdiel.livraria.repository;

import com.abdiel.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrariaRepository extends JpaRepository<Livro, Long> {

}
