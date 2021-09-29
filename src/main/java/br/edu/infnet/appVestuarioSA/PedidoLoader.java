package br.edu.infnet.appVestuarioSA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Pedido;
import br.edu.infnet.appVestuarioSA.model.domain.Produto;
import br.edu.infnet.appVestuarioSA.model.domain.Solicitante;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.PedidoService;

@Component
@Order(4)
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Solicitante solicitante = new Solicitante();
		solicitante.setId(1);

		Roupa p1 = new Roupa();
		p1.setId(1);

		Sapato s1 = new Sapato();
		s1.setId(2);
		
		Mochila m1 = new Mochila();
		m1.setId(3);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(p1);
		produtos.add(s1);
		produtos.add(m1);
		
		Pedido pedido = new Pedido();
		pedido.setDescricao("Pedido de Natal");
		pedido.setProdutos(produtos);
		pedido.setSolicitante(solicitante);
		pedido.setUsuario(usuario);
		
		pedidoService.incluir(pedido);
	}
}
