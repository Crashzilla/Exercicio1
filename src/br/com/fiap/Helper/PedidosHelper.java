package br.com.fiap.Helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class PedidosHelper {
	
	private EntityManager em;

	public PedidosHelper(EntityManager em) {
		super();
		this.em = em;
	}
	
	public String criarCliente (Clientes cliente){
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return "Pedido salvo.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String adicionarPedido(int idCliente, Pedidos pedido){
		try {
			Clientes c = em.find(Clientes.class, idCliente);
			pedido.setCliente(c);
			c.getPedidos().add(pedido);
			
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return "Pedido realizado.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
