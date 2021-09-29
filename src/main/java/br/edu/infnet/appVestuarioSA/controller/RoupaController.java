package br.edu.infnet.appVestuarioSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.RoupaService;

@Controller
public class RoupaController {

	@Autowired
	private RoupaService roupaService;

	@GetMapping(value = "/roupa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("roupas", roupaService.obterLista(usuario));

		return "roupa/lista";
	}

	@GetMapping(value = "/roupa")
	public String telaCadastro() {
		return "roupa/cadastro";
	}

	@PostMapping(value = "/roupa/incluir")
	public String incluir(Model model, Roupa roupa, @SessionAttribute("user") Usuario usuario) {

		roupa.setUsuario(usuario);

		roupaService.incluir(roupa);

		model.addAttribute("msg", "Roupa " + roupa.getDescricao() + " cadastrada com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Roupa roupa = roupaService.obterPorId(id);

		String mensagem = null;
		try {
			roupaService.excluir(id);
			mensagem = "A roupa " + roupa.getDescricao() + " foi removida com sucesso!!!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão da roupa " + roupa.getDescricao();
		}
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}
}
