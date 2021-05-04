package com.example.prova_senior.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class repositorio_itenspedidocustom {
	private final EntityManager em;
	
	
	
	public repositorio_itenspedidocustom(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public void concederDesconto(UUID id_pedido, double valdesconto) {
		
		String query = "update pedido x "
					 + "set x.valor = ("
									 + "select ((sum(pr.valor) * (( :valdesconto - 100.0) * -1)/100)  + sum(s.valor)) from itenspedido i "+ 
										    "inner join i.idpedido p "+
										    "left outer join i.idproduto pr " +
										    "left outer join i.idservico s "
										  + "where i.idpedido.id =:id_pedido), "
					 + "x.desconto = :valdesconto "
				       + " where x.id = :id_pedido";
		
		em.createQuery(query)
				.setParameter("id_pedido", id_pedido)
				.setParameter("valdesconto", valdesconto).executeUpdate();
	}
}
