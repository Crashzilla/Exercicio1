package br.com.fiap.programa;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.Helper.PedidosHelper;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class TesteCliente {
	
	public static void main(String[] args){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		PedidosHelper dao = new PedidosHelper(em);
		
		Clientes cliente1 = new Clientes();
		cliente1.setNome("José Carvalho");
		cliente1.setEmail("jose@carvalho.com.br");
		
		System.out.println(dao.criarCliente(cliente1));
		
		Pedidos pedido1 = new Pedidos();
		pedido1.setData(LocalDateTime.now());
		pedido1.setDescricao("Pente de memória RAM 8GB DDR3 1600MHz");
		pedido1.setValor(99.99);
		
		System.out.println(dao.adicionarPedido(cliente1.getId(), pedido1));
		
	}
}
