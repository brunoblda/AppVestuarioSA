package br.edu.infnet.appVestuarioSA.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.repository.RoupaRepository;

@Service
public class RoupaService {
	
	@Autowired
	private RoupaRepository roupaRepository;

	public List<Roupa> obterLista(Usuario usuario){
		return (List<Roupa>) roupaRepository.obterLista(usuario.getId());
	}
	public List<Roupa> obterLista(){
		return (List<Roupa>) roupaRepository.findAll();
	}
	
	public void incluir(Roupa roupa) {
		roupaRepository.save(roupa);
	}
	
	public void excluir(Integer id) {
		roupaRepository.deleteById(id);
	}
	
	public Roupa obterPorId(Integer id) {
		return roupaRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) roupaRepository.count();
	}
}