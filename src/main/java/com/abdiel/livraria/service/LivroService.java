package com.abdiel.livraria.service;

import com.abdiel.livraria.model.Livro;
import com.abdiel.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository _livroRepository;

    public LivroService(LivroRepository _livroRepository) {
        this._livroRepository = _livroRepository;
    }

    public List<Livro> listarTodos() {
        List<Livro> response = null;
        return _livroRepository.findAll();
    }

    public void salvar(Livro livro) {
        _livroRepository.save(livro);
    }

    public void deletePeloId(Long id) {
        _livroRepository.deleteById(id);
    }

    public Optional<Livro> buscarPeloId(Long id) {
        return _livroRepository.findById(id);
    }

    public Optional<Livro> buscarPeloIsbn(Long isbn) {
        return _livroRepository.findByIsbn(isbn);
    }
}
