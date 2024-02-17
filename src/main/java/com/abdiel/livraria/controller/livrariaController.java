package com.abdiel.livraria.controller;

import com.abdiel.livraria.entities.Livro;
import com.abdiel.livraria.repository.LivrariaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@RestController
@RequestMapping(value = "/books")
public class livrariaController {

    @Autowired
    public LivrariaRepository _livrariaRepository;

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.print("Escolha uma opção: ");
        String opcao = sc.next();



        //
        //        List<Livro> book;
        //        book = Arrays.asList(livro, livro2, livro3);

        //Livro livro = new Livro(nome, sobrenome, titulo, editora, isbn, anoEdicao, quantidadePaginas);

        Livro livro =  new Livro ("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);

        System.out.println(livro.getNome("Bruce"));

        switch (opcao) {
            case "1" -> getObjects();
            case "2" -> listar();
            case "3" -> atualizarLivro();
            case "4" -> Delete();

            default -> throw new IllegalStateException("Unexpected value: " + opcao);
        }
//        System.out.println(livro);
    }


    //String nome, @RequestParam String sobrenome, @RequestParam String titulo, @RequestParam String editora, @RequestParam String isbn, @RequestParam int anoEdicao, @RequestParam int quantidadePaginas


    @GetMapping
    public List<Livro> getObjects() {




        Livro livro = new Livro("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);
        Livro livro2 = new Livro("Tim", "Collins", "EMPRESAS FEITAS PARA VENCER", "Alta Books", "978-85-508-0524-5", 2001, 367);
        Livro livro3 = new Livro("Ernest", "Cline", "JOGADOR N° 1", "Leya", "978-85-441-0697-6", 2018, 462);

        List<Livro> livroList;
        livroList = Arrays.asList(livro, livro2, livro3);
        return livroList;

    }


    @ResponseBody
    @RequestMapping("/books")
    public void listar() {

//        Livro livro = new Livro("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);
//        Livro livro2 = new Livro("Tim", "Collins", "EMPRESAS FEITAS PARA VENCER", "Alta Books", "978-85-508-0524-5", 2001, 367);
//        Livro livro3 = new Livro("Ernest", "Cline", "JOGADOR N° 1", "Leya", "978-85-441-0697-6", 2018, 462);

        List<Livro> book;
        book = _livrariaRepository.findAll();
        System.out.println("Livro: " + book + " status: " + HttpStatus.OK);


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
    public void Delete() {
        System.out.print("\nDigite o id: ");
        Long id = sc.nextLong();

        Optional<Livro> livroExistente = _livrariaRepository.findById(id);
        if (livroExistente.isPresent()) {
            _livrariaRepository.delete(livroExistente.get());
            new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

//    public void set_livrariaRepository(LivrariaRepository _livrariaRepository) {
//        this._livrariaRepository = _livrariaRepository;
//    }
}