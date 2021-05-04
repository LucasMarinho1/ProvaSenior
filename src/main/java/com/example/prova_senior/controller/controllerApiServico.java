package com.example.prova_senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_senior.dao.repositorio_servico;
import com.example.prova_senior.modal.servico;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller Produto Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api")
public class controllerApiServico {

	@Autowired
	private repositorio_servico Repositorio;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Cadastrado serviço!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(method=RequestMethod.POST, value="/cadastroServico", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveServico(@RequestBody servico servico) {

        Repositorio.save(servico);

        return ResponseEntity.ok("Servico Cadastrado!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista serviços cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/listarServicos", method = RequestMethod.POST)
    public Iterable<servico> listServicos() {
    	Iterable<servico> servicos =  Repositorio.findAll();
        
		return servicos;
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Remove serviços cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/removerServico", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removerServico(@RequestBody servico servico) {
    	
    	Repositorio.delete(servico);

    	return ResponseEntity.ok("Servico Removido!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Altera serviços cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/alterarServico", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarServico(@RequestBody servico servico) {
    	
    	Repositorio.save(servico);

    	return ResponseEntity.ok("Servico Alterado!");
    }
    
    
    
    
}
