package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Cerveja;
import repository.Cervejas;

@Controller
public class CervejasController {


	@Autowired
	private Cervejas cervejas;


	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		cervejas.findAll();
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {


		if(result.hasErrors()) {

			return novo(cerveja);
		}


		//salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";

	}




}
