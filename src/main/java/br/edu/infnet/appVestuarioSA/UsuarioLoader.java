package br.edu.infnet.appVestuarioSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Usuario usuario = new Usuario();
		usuario.setNome("Gomes Roberto");
		usuario.setEmail("gomes@email.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		usuario.setEndereco("Rua Afonso Pena 1675 - Belo Horizonte");
		
		usuarioService.incluir(usuario);
	}
}
