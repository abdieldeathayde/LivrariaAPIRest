package com.abdiel.livraria.controller;

import com.abdiel.livraria.service.livrariaService;
import entities.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping(value = "/books")
public class livrariaController {
    livrariaService lvService = new livrariaService();

    Scanner sc = new Scanner(System.in);


    public void menu() {
        String opcao = sc.next();
        switch (opcao) {
            case "1" -> adicionarLivro();
            case "2" -> mostrarLivro();
            case "3" -> atualizarLivro();
            case "4" -> excluirLivro();
        }
    }
    @GetMapping("/")
    public Set<Livro> adicionarLivro() {

        Livro l1 = new Livro ("Bruce", "Tulgan", "Não tenha medo de ser chefe", "Sextante", "978-85-431-0818-6", 2007, 190);
        Livro l2 = new Livro ( "Tim", "Collins", "EMPRESAS FEITAS PARA VENCER", "Alta Books", "978-85-508-0524-5", 2001, 367);
        Livro l3 = new Livro ("Ernest", "Cline", "JOGADOR N° 1", "Leya", "978-85-441-0697-6", 2018, 462);

        l3.setQuantidadePaginas(461);

        Set<Livro> livrosSet = new HashSet<>();
        livrosSet.add(l1);
        livrosSet.add(l2);
        livrosSet.add(l3);

        return livrosSet;
    }

    public void mostrarLivro() {

    }

    public void atualizarLivro() {}

    public void excluirLivro() {
        this.lvService.dele
    }
}