package br.com.caelum.fj91.rh.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.usecases.funcionario.CadastroDeFuncionario;
import br.com.caelum.fj91.rh.usecases.funcionario.ExclusaoDeFuncionario;
import br.com.caelum.fj91.rh.usecases.funcionario.ListagemDeFuncionarios;
import br.com.caelum.fj91.rh.web.models.form.funcionario.FuncionarioForm;
import br.com.caelum.fj91.rh.web.models.view.funcionario.ListaDeFuncionariosViewModel;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	private final ListagemDeFuncionarios listagemDeFuncionarios;
	private final CadastroDeFuncionario cadastroDeFuncionario;
	private final ExclusaoDeFuncionario exclusaoDeFuncionario;
	private final CargoRepository cargoRepository;
	
	public FuncionarioController(ListagemDeFuncionarios listagemDeFuncionarios, CadastroDeFuncionario cadastroDeFuncionario, ExclusaoDeFuncionario exclusaoDeFuncionario, CargoRepository cargoRepository) {
		this.listagemDeFuncionarios = listagemDeFuncionarios;
		this.cadastroDeFuncionario = cadastroDeFuncionario;
		this.exclusaoDeFuncionario = exclusaoDeFuncionario;
		this.cargoRepository = cargoRepository;
	}

	@GetMapping
	public String lista(Model model) {
		List<Funcionario> funcionarios = listagemDeFuncionarios.listar();
		model.addAttribute("listaDeFuncionariosViewModel", new ListaDeFuncionariosViewModel(funcionarios));
		return "funcionario/lista";
	}
	
	@GetMapping("/form")
	public String formulario(Model model) {
		model.addAttribute("cargos", cargoRepository.carregarTodos());
		return "funcionario/form";
	}
	
	@PostMapping
	public String salvar(FuncionarioForm form, Model model, RedirectAttributes attributes) {
		try {
			Funcionario novo = form.toFuncionario();
			cadastroDeFuncionario.cadastrar(novo);
			attributes.addFlashAttribute("msgSucesso", "Funcionario cadastrado!");
			return "redirect:/funcionarios";
		} catch (BusinessException e) {
			model.addAttribute("msgErro", e.getMessage());
			return formulario(model);
		}
	}
	
	@DeleteMapping
	public String excluir(Long id, RedirectAttributes attributes) {
		Funcionario excluido = new Funcionario(id, null, null, null, null);
		exclusaoDeFuncionario.excluir(excluido);
		attributes.addFlashAttribute("msgSucesso", "Funcionario excluido!");
		return "redirect:/funcionarios";
	}
	
}
