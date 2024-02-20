package com.abdiel.livraria.controller;


import com.abdiel.livraria.model.Livro;
import com.abdiel.livraria.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @ResponseBody
    @RequestMapping(path = "/listarTodos", method = RequestMethod.GET)
    public List<Livro> listarLivros() {
        List<Livro> response = null;
        response = livroService.listarTodos();
        return response;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.PUT)
    @ResponseBody
    public void atualizarLivro(@RequestBody Livro livro) {
        livroService.salvar(livro);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        livroService.deletePeloId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Livro getLivroPorId(@PathVariable Long id) {
        Optional<Livro> livroResponse = livroService.buscarPeloId(id);

        if(livroResponse.isPresent())
            return livroResponse.get();

        return null;
    }
    @RequestMapping(path = "/isbn/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Livro getLivroPorIsbn(@PathVariable Long isbn) {
        Optional<Livro> livroResponse = livroService.buscarPeloIsbn(isbn);

        if (livroResponse.isPresent())
            return livroResponse.get();

        return null;
    }
}