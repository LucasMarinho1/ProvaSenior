package com.example.prova_senior.modal;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TB_ITENS_PEDIDO")
public class itenspedido implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    protected UUID id;
	
	private String nomeitem;
	
	@ManyToOne
    @JoinColumn(name = "id_pedido")
	private pedido idpedido;
	
	@ManyToOne
    @JoinColumn(name = "id_produto")
	private produto idproduto;
	
	@ManyToOne
    @JoinColumn(name = "id_servico")
	private servico idservico;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNomeitem() {
		return nomeitem;
	}
	public void setNomeitem(String nomeitem) {
		this.nomeitem = nomeitem;
	}
	public pedido getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(pedido idpedido) {
		this.idpedido = idpedido;
	}
	public produto getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(produto idproduto) {
		this.idproduto = idproduto;
	}
	public servico getIdservico() {
		return idservico;
	}
	public void setIdservico(servico idservico) {
		this.idservico = idservico;
	}
}
