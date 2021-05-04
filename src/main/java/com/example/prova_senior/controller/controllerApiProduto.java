package com.example.prova_senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_senior.dao.repositorio_produto;
import com.example.prova_senior.modal.produto;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller Produto Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api")
public class controllerApiProduto {

	@Autowired
	private repositorio_produto Repositorio;
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Cadastra produto!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(method=RequestMethod.POST, value="/cadastroProduto", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveProduto(@RequestBody produto produto) {

        Repositorio.save(produto);

        return ResponseEntity.ok("Produto Cadastrado!");
    }
    
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista produtos cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/listarProdutos", method = RequestMethod.POST)
    public Iterable<produto> listProduto() {
    	Iterable<produto> produtos =  Repositorio.findAll();
        
		return produtos;
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Remove Produtos Cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/removerProdutos", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removerProduto(@RequestBody produto produto) {
    	
    	Repositorio.delete(produto);

    	return ResponseEntity.ok("Produto Removido!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Altera Produtos Cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/alterarProdutos", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarProduto(@RequestBody produto produto) {
    	
    	Repositorio.save(produto);

    	return ResponseEntity.ok("Produto Alterado!");
    }
    
    
    
    
}
