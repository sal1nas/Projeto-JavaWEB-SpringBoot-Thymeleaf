package controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Cliente;

@Controller
public class ClientesController {


	@RequestMapping("/clientes/novo")
	public String novo(Cliente cliente) {
		return "cerveja/CadastroCliente";
	}

	@RequestMapping(value = "/clientes/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {


		if(result.hasErrors()) {

			return novo(cliente);
		}


		//salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "cliente salvo com sucesso!");
		return "redirect:/clientes/novo";

	}


}
