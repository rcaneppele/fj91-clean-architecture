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
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.usecases.cargo.CadastroDeCargo;
import br.com.caelum.fj91.rh.usecases.cargo.ExclusaoDeCargo;
import br.com.caelum.fj91.rh.usecases.cargo.ListagemDeCargos;
import br.com.caelum.fj91.rh.web.models.form.cargo.CargoForm;
import br.com.caelum.fj91.rh.web.models.view.cargo.ListaDeCargosViewModel;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	private final ListagemDeCargos listagemDeCargos;
	private final CadastroDeCargo cadastroDeCargo;
	private final ExclusaoDeCargo exclusaoDeCargo;
	
	public CargoController(ListagemDeCargos listagemDeCargos, CadastroDeCargo cadastroDeCargo, ExclusaoDeCargo exclusaoDeCargo) {
		this.listagemDeCargos = listagemDeCargos;
		this.cadastroDeCargo = cadastroDeCargo;
		this.exclusaoDeCargo = exclusaoDeCargo;
	}

	@GetMapping
	public String lista(Model model) {
		List<Cargo> cargos = listagemDeCargos.listar();
		model.addAttribute("listaDeCargosViewModel", new ListaDeCargosViewModel(cargos));
		return "cargo/lista";
	}
	
	@GetMapping("/form")
	public String formulario() {
		return "cargo/form";
	}
	
	@PostMapping
	public String salvar(CargoForm form, Model model, RedirectAttributes attributes) {
		try {
			Cargo novo = form.toCargo();
			cadastroDeCargo.cadastrar(novo);
			attributes.addFlashAttribute("msgSucesso", "Cargo cadastrado!");
			return "redirect:/cargos";
		} catch (BusinessException e) {
			model.addAttribute("msgErro", e.getMessage());
			return "cargo/form";
		}
	}
	
	@DeleteMapping
	public String excluir(Long id, RedirectAttributes attributes) {
		try {
			Cargo selecionado = new Cargo(id, null, null, null);
			exclusaoDeCargo.excluir(selecionado);
			attributes.addFlashAttribute("msgSucesso", "Cargo excluido!");
		} catch (BusinessException e) {
			attributes.addFlashAttribute("msgErro", e.getMessage());
		}
		
		return "redirect:/cargos";
	}

}
