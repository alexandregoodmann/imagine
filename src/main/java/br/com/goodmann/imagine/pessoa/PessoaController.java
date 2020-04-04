package br.com.goodmann.imagine.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable String id) {
		Pessoa p = new Pessoa();
		return new ResponseEntity<Pessoa>(p, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllId() {
		List<Pessoa> l = new ArrayList<Pessoa>();
		return new ResponseEntity<List<Pessoa>>(l, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> add(@RequestBody Pessoa Pessoa, UriComponentsBuilder builder) {
		/*
		 * boolean flag = PessoaService.addPessoa(Pessoa); if (flag == false) { return
		 * new ResponseEntity<Void>(HttpStatus.CONFLICT); }
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/Pessoa/{id}").buildAndExpand(Pessoa.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("Pessoa")
	public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa Pessoa) {
		return new ResponseEntity<Pessoa>(Pessoa, HttpStatus.OK);
	}

	@DeleteMapping("Pessoa/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable("id") Integer id) {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
