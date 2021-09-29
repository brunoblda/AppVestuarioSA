package br.edu.infnet.appVestuarioSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Usuario;
import br.edu.infnet.appVestuarioSA.model.service.MochilaService;

@Controller
public class MochilaController {

	@Autowired
	private MochilaService mochilaService;

	@GetMapping(value = "/mochila/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("mochilas", mochilaService.obterLista(usuario));

		return "mochila/lista";
	}

	@GetMapping(value = "/mochila")
	public String telaCadastro() {
		return "mochila/cadastro";
	}

	@PostMapping(value = "/mochila/incluir")
	public String incluir(Model model, Mochila mochila, @SessionAttribute("user") Usuario usuario) {

		mochila.setUsuario(usuario);

		mochilaService.incluir(mochila);

		model.addAttribute("msg", "Mochila " + mochila.getDescricao() + " cadastrada com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/mochila/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Mochila mochila = mochilaService.obterPorId(id);

		String mensagem = null;
		try {
			mochilaService.excluir(id);
			mensagem = "A mochila " + mochila.getDescricao() + " foi removida com sucesso!!!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão da mochila " + mochila.getDescricao();
		}
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}
}