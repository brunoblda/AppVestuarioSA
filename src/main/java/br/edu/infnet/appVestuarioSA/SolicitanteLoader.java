package br.edu.infnet.appVestuarioSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVestuarioSA.model.domain.Solicitante;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.SolicitanteService;

@Component
@Order(2)
public class SolicitanteLoader implements ApplicationRunner {

	@Autowired
	private SolicitanteService solicitanteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Solicitante solicitante = new Solicitante("Romero Brito", "Romero@email.com", 52);
		solicitante.setUsuario(usuario);
		
		solicitanteService.incluir(solicitante);
	}
}
