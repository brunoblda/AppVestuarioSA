package br.edu.infnet.appVestuarioSA.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.repository.SapatoRepository;

@Service
public class SapatoService {
	
	@Autowired
	private SapatoRepository sapatoRepository;

	public List<Sapato> obterLista(Usuario usuario){
		return (List<Sapato>) sapatoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}
	public List<Sapato> obterLista(){
		return (List<Sapato>) sapatoRepository.findAll();
	}
	
	public void incluir(Sapato sapato) {
		sapatoRepository.save(sapato);
	}
	
	public void excluir(Integer id) {
		sapatoRepository.deleteById(id);
	}
	
	public Sapato obterPorId(Integer id) {
		return sapatoRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) sapatoRepository.count();
	}
}

