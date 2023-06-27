package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Usuario;

@Controller
public class EstiloController {

	@RequestMapping("/estilos/novo")
	public String novo(Usuario usuario) {
		return "cerveja/CadastroEstilo";
	}

	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes) {


		if(result.hasErrors()) {

			return novo(usuario);
		}


		//salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "cerveja salva com sucesso!");
		return "redirect:/estilos/novo";

	}




}
