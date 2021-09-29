package br.edu.infnet.appVestuarioSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.SapatoService;

@Controller
public class SapatoController {
	
	@Autowired
	private SapatoService sapatoService;

	@GetMapping(value = "/sapato/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("sapatos", sapatoService.obterLista(usuario));
		
		return "sapato/lista";
	}	
	
	@GetMapping(value = "/sapato")
	public String telaCadastro() {
		return "sapato/cadastro";
	}
	
	@PostMapping(value = "/sapato/incluir")
	public String incluir(Model model, Sapato sapato, @SessionAttribute("user") Usuario usuario) {
		
		sapato.setUsuario(usuario);
		
		sapatoService.incluir(sapato);
		
		model.addAttribute("msg", "Sapato " + sapato.getDescricao() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/sapato/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Sapato sapato = sapatoService.obterPorId(id);
		
		String mensagem = null;
		try {
			sapatoService.excluir(id);		
			mensagem = "O sapato " + sapato.getDescricao() + " foi removido com sucesso!!!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão do sapato "+ sapato.getDescricao();
		}
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}
