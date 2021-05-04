package com.example.prova_senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_senior.dao.repositorio_itenspedidocustom;
import com.example.prova_senior.dao.repositorio_pedido;
import com.example.prova_senior.modal.pedido;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller Produto Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api")
public class controllerApiPedido {

	@Autowired
	private repositorio_pedido Repositorio;
	
	@Autowired
	private repositorio_itenspedidocustom repositorioItensPedidoCustom;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Cadastrado pedido!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(method=RequestMethod.POST, value="/cadastroPedido", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePedido(@RequestBody pedido pedido) {

        Repositorio.save(pedido);

        return ResponseEntity.ok("Pedido Cadastrado!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista pedidos cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/listarPedidos", method = RequestMethod.POST)
    public Iterable<pedido> listPedidos() {
    	Iterable<pedido> pedidos =  Repositorio.findAll();
        
		return pedidos;
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "remove pedidos cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/removerPedido", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removerPedido(@RequestBody pedido pedido) {
    	
    	Repositorio.delete(pedido);

    	return ResponseEntity.ok("Pedido Removido!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Altera pedidos cadastrados!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/alterarPedido", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarPedido(@RequestBody pedido pedido) {
    	
    	Repositorio.save(pedido);

    	return ResponseEntity.ok("Pedido Alterado!");
    }
    
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Gera desconto em um pedido cadastrado!"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @RequestMapping(value="/descontoPedido", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> descontoPedido(@RequestBody pedido pedido) {
    	
    	repositorioItensPedidoCustom.concederDesconto(pedido.getId(), pedido.getDesconto());
 
    	return ResponseEntity.ok("Desconto Concedido no Pedido "+pedido.getId()+" !");
    }
    
    
}
