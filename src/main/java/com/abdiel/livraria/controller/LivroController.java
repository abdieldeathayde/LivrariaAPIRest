package com.abdiel.livraria.controller;

import com.abdiel.livraria.entities.Livro;
import com.abdiel.livraria.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value = "/books")
public class LivroController {

    @Autowired
    private final LivroRepository _livroRepository;

    public LivroController(LivroRepository _livroRepository) {
        this._livroRepository = _livroRepository;
    }


    @GetMapping
    public void getObjects(@RequestBody Livro livro) {

        _livroRepository.save(livro);

    }


    @ResponseBody
    @RequestMapping("/books")
    public List<Livro> listar() {

        List<Livro> book;
        book = _livroRepository.findAll();
        return book;


    }



    @ResponseBody
    @Transactional
    @RequestMapping(path = "/books", method = RequestMethod.PUT)
    public void atualizarLivro(@RequestBody Livro livro) {
        _livroRepository.save(livro);
    }


    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable Long isbn) {

        _livroRepository.deleteById(isbn);

    }


}