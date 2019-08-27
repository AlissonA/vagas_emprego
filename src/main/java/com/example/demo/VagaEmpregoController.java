package com.example.demo;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VagaEmpregoController {
	private VagaEmpregoRepository repositorio;
	
	public 	VagaEmpregoController (VagaEmpregoRepository repositorio){
		this.repositorio = repositorio;
	}

	@GetMapping("/cadastrar")
	public String exibirForm(Model model) {
		Emprego emprego = new Emprego();
		
		model.addAttribute("emprego", emprego);
		//model.addAttribute(emprego);
		
		return "formulario";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute @Valid Emprego emprego, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "formulario";
		}else{
			repositorio.save(emprego);
			return "Dados-vagadeemprego";

	}
		
		
	}
	@GetMapping("/listarVagas")
	public String listarEmprego(Model model) {
		Iterable<Emprego> empregos = repositorio.findAll();
		
		model.addAttribute("empregos", empregos);
		
		return "listagem-vagas";
	}
	
	@GetMapping("/exibir")
	public String exibir(Integer id, Model model){
		Optional<Emprego> emprego = repositorio.findById(id);
		
		model.addAttribute("emprego", emprego.get());
		
		return "Dados-vagadeemprego";
	}
	
	@GetMapping("/excluir")
		public String excluir(Integer id){
		repositorio.deleteById(id);
		
		return "redirect:/listarVagas";
	
	
	}
	@GetMapping("/editar")
	public String editar(Integer id, Model model){
		Optional<Emprego> emprego = repositorio.findById(id);
	
		model.addAttribute("emprego", emprego);
		
		return "editar";
	
	}
	
	@PostMapping("/editar")
	public String submitEditar(@ModelAttribute @Valid Emprego emprego, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "editar";
		} else {
			repositorio.save(emprego);
			return "redirect:/listarVagas";
		}

	}
	
	@GetMapping("/vagascadastradas")
	public String vagas(Model model){
		Iterable<Emprego> empregos = repositorio.findAll();
		model.addAttribute("empregos", empregos);
		
		return "listagem-vagas";
	
	}
	
	@GetMapping("/paginainicial")
	public String inicial(Model model){
		Emprego emprego = new Emprego();
		model.addAttribute("emprego", emprego);
		
		return "formulario";
	
	}
}