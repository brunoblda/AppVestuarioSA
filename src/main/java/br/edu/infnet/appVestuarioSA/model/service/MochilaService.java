package br.edu.infnet.appVestuarioSA.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.repository.MochilaRepository;

@Service
public class MochilaService {
	
	@Autowired
	private MochilaRepository mochilaRepository;

	public List<Mochila> obterLista(Usuario usuario){
		return (List<Mochila>) mochilaRepository.obterLista(usuario.getId());
	}
	public List<Mochila> obterLista(){
		return (List<Mochila>) mochilaRepository.findAll();
	}
	
	public void incluir(Mochila mochila) {
		mochilaRepository.save(mochila);
	}
	
	public void excluir(Integer id) {
		mochilaRepository.deleteById(id);
	}
	
	public Mochila obterPorId(Integer id) {
		return mochilaRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) mochilaRepository.count();
	}
}
