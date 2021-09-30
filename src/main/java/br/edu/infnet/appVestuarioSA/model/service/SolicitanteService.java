package br.edu.infnet.appVestuarioSA.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVestuarioSA.model.domain.Solicitante;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public List<Solicitante> obterLista(Usuario usuario){
		return solicitanteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public List<Solicitante> obterLista(){

		return (List<Solicitante>) solicitanteRepository.findAll();
	}
		
	public void incluir(Solicitante solicitante) {

		solicitanteRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {
		solicitanteRepository.deleteById(id);
	}

	public Solicitante obterPorId(Integer id) {
		return solicitanteRepository.findById(id).orElse(null);
	}
}
