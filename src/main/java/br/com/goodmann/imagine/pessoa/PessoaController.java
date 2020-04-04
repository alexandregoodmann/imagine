package br.com.goodmann.imagine.pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController {
	
	@GetMapping("/{id}")
	public Pessoa getPessoa(@PathVariable String id) {
		return new Pessoa();
	}

}
