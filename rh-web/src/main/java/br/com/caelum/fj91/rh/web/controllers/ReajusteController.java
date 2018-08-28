package br.com.caelum.fj91.rh.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.usecases.reajuste.CadastroDeReajuste;
import br.com.caelum.fj91.rh.usecases.reajuste.ListagemDeReajustes;
import br.com.caelum.fj91.rh.web.models.form.reajuste.ReajusteForm;
import br.com.caelum.fj91.rh.web.models.view.reajuste.ListaDeReajustesViewModel;

@Controller
@RequestMapping("/funcionarios/{id}/reajustes")
public class ReajusteController {
	
	private final ListagemDeReajustes listagemDeReajustes;
	private final CadastroDeReajuste cadastroDeReajuste;
	private final FuncionarioRepository funcionarioRepository;
	
	public ReajusteController(ListagemDeReajustes listagemDeReajustes, CadastroDeReajuste cadastroDeReajuste, FuncionarioRepository funcionarioRepository) {
		this.listagemDeReajustes = listagemDeReajustes;
		this.cadastroDeReajuste = cadastroDeReajuste;
		this.funcionarioRepository = funcionarioRepository;
	}

	@GetMapping
	public String reajustes(@PathVariable Long id, Model model) {
		Funcionario selecionado = funcionarioRepository.buscarPorId(id);
		List<Reajuste> reajustes = listagemDeReajustes.listar(selecionado);
		
		model.addAttribute("listaDeReajustesViewModel", new ListaDeReajustesViewModel(reajustes, selecionado));
		return "funcionario/reajuste";
	}
	
	@PostMapping
	public String reajustar(@PathVariable Long id, ReajusteForm form, Model model, RedirectAttributes attributes) {
		try {
			Funcionario selecionado = funcionarioRepository.buscarPorId(id);
			Reajuste novo = form.toReajuste(selecionado);
			cadastroDeReajuste.reajustarSalarioDoFuncionario(novo);
			attributes.addFlashAttribute("msgSucesso", "Reajuste cadastrado!");
			return "redirect:/funcionarios";
		} catch (BusinessException e) {
			model.addAttribute("msgErro", e.getMessage());
			return reajustes(id, model);
		}
	}

}
