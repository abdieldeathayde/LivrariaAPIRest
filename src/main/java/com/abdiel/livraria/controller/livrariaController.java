package com.abdiel.livraria.controller;

import com.abdiel.livraria.entities.Livro;
import com.abdiel.livraria.repository.LivrariaRepository;
import com.abdiel.livraria.service.livrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@RestController
public class livrariaController {

    @Autowired
    private LivrariaRepository _livrariaRepository;

    livrariaService lvService = new livrariaService();

    Scanner sc = new Scanner(System.in);


    public void menu() {
        System.out.print("Escolha uma opção: ");
        String opcao = sc.next();

        System.out.println();

        System.out.print("Escolha um id: ");
        Long id = sc.nextLong();

        System.out.print("\nDigite seu nome: ");
        String nome = sc.next();

        System.out.print("\nDigite seu sobrenome: ");
        String sobrenome = sc.next();

        System.out.print("\nDigite o titulo: ");
        String titulo = sc.next();

        System.out.print("\nDigite o nome da editora: ");
        String editora = sc.next();

        System.out.print("\nDigite o isbn: ");
        String isbn = sc.next();

        System.out.print("\nDigite o ano de edição: ");
        int anoEdicao = sc.nextInt();

        System.out.print("\nDigite a quantidade de páginas: ");
        int quantidadePaginas = sc.nextInt();

        switch (opcao) {
            case "1" -> adicionarLivro(nome, sobrenome, titulo, editora, isbn, anoEdicao, quantidadePaginas);
            case "2" -> Get();
            case "3" -> atualizarLivro();
            case "4" -> Delete(id);
        }
    }

    @GetMapping

    public @ResponseBody void adicionarLivro(@RequestParam String nome, @RequestParam String sobrenome, @RequestParam String titulo, @RequestParam String editora, @RequestParam String isbn, @RequestParam int anoEdicao, @RequestParam int quantidadePaginas) {

        /*Livro l1 = new Livro ("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);
        Livro l2 = new Livro ( "Tim", "Collins", "EMPRESAS FEITAS PARA VENCER", "Alta Books", "978-85-508-0524-5", 2001, 367);
        Livro l3 = new Livro ("Ernest", "Cline", "JOGADOR N° 1", "Leya", "978-85-441-0697-6", 2018, 462);

        l3.setQuantidadePaginas(461);

        List<Livro> livros = Arrays.asList(l1, l2, l3);
        return livros;*/

        Livro livro = new Livro("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);
        Livro livro2 = new Livro("Tim", "Collins", "EMPRESAS FEITAS PARA VENCER", "Alta Books", "978-85-508-0524-5", 2001, 367);
        Livro livro3 = new Livro("Ernest", "Cline", "JOGADOR N° 1", "Leya", "978-85-441-0697-6", 2018, 462);
        _livrariaRepository.save(livro);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Livro> Get() {
        return _livrariaRepository.findAll();
    }



    public void atualizarLivro() {}

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
        Optional<Livro> livro = _livrariaRepository.findById(id);
        if (livro.isPresent()) {
            _livrariaRepository.delete(livro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}