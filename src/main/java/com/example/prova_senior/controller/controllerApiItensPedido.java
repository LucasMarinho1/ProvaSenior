package com.example.prova_senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_senior.dao.repositorio_itenspedido;
import com.example.prova_senior.modal.itenspedido;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller Produto Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api")
public class controllerApiItensPedido {

	@Autowired
	private repositorio_itenspedido Repositorio;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Cadastra itens em um pedido!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(method=RequestMethod.POST, value="/cadastroItensPedido", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveItensPedidos(@RequestBody itenspedido itenspedido) {

        Repositorio.save(itenspedido);

        return ResponseEntity.ok("Item Cadastrado!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista itens de um pedido!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/listarItensPedido", method = RequestMethod.POST)
    public Iterable<itenspedido> listaItensPedidos() {
    	Iterable<itenspedido> itenspedido =  Repositorio.findAll();
        
		return itenspedido;
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Remmove itens de um pedido!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/removerItensPedido", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removerItensPedidos(@RequestBody itenspedido itenspedido) {
    	
    	Repositorio.delete(itenspedido);

    	return ResponseEntity.ok("Item Removido!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Altera itens de um pedido!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/alterarItensPedido", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarItensPedido(@RequestBody itenspedido itenspedido) {
    	
    	Repositorio.save(itenspedido);

    	return ResponseEntity.ok("Item Alterado!");
    }
    
}
