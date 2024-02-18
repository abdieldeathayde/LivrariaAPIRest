package com.abdiel.livraria.controller;

import com.abdiel.livraria.entities.Livro;
import com.abdiel.livraria.repository.LivrariaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value = "/books")
public class livrariaController {

    @Autowired
    private final LivrariaRepository _livrariaRepository;

    public livrariaController(LivrariaRepository _livrariaRepository) {
        this._livrariaRepository = _livrariaRepository;
    }

    Scanner sc = new Scanner(System.in);

    //String nome, @RequestParam String sobrenome, @RequestParam String titulo, @RequestParam String editora, @RequestParam String isbn, @RequestParam int anoEdicao, @RequestParam int quantidadePaginas


    @GetMapping
    public void getObjects(@RequestBody Livro livro) {

        _livrariaRepository.save(livro);

    }


    @ResponseBody
    @RequestMapping("/books")
    public List<Livro> listar() {

        List<Livro> book;
        book = _livrariaRepository.findAll();
        return book;


    }



    @ResponseBody
    @Transactional
    @RequestMapping(path = "/books", method = RequestMethod.PUT)
    public void atualizarLivro(@RequestBody Livro livro) {
        _livrariaRepository.save(livro);
    }


    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable Long isbn) {

        _livrariaRepository.deleteById(isbn);

    }


}