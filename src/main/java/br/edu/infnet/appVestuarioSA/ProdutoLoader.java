package br.edu.infnet.appVestuarioSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.SapatoService;
import br.edu.infnet.appVestuarioSA.model.service.MochilaService;
import br.edu.infnet.appVestuarioSA.model.service.RoupaService;


@Component
@Order(3)
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private SapatoService sapatoService;
	@Autowired
	private RoupaService roupaService;
	@Autowired
	private MochilaService mochilaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Sapato s1 = new Sapato("Tenis de corrida", 550, "Algodao", "amarelo", 43, true);
		
		s1.setUsuario(usuario);
		
		Roupa r1 = new Roupa("Camiseta florida", 120, "camiseta", "branca", "algodao", "M", false);
	
		r1.setUsuario(usuario);
		
		Mochila m1 = new Mochila("Mochila de caça", 450, "Nylon", "verde", 7, "Aventura");
		
		m1.setUsuario(usuario);
		
		sapatoService.incluir(s1);
		roupaService.incluir(r1);
		mochilaService.incluir(m1);
		
		

		
	}
}