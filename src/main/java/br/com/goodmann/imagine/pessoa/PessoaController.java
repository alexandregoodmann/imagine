package br.com.goodmann.imagine.pessoa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

	@Autowired
	private PessoaService service;

	@Autowired
	private PessoaRepository repo;

	@PostMapping
	public ResponseEntity<String> add(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<String>(service.add(pessoa), HttpStatus.CREATED);
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Pessoa> getById(@PathVariable String cpf) {
		return new ResponseEntity<Pessoa>(repo.findBycpf(cpf), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll() {
		return new ResponseEntity<List<Pessoa>>(this.repo.findAll(), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/{id}") public ResponseEntity<Pessoa> getById(@PathVariable
	 * String id) { Pessoa pessoa = this.service.findById(id).get(); return new
	 * ResponseEntity<Pessoa>(pessoa, HttpStatus.OK); }
	 * 
	 * 
	 * @PatchMapping public ResponseEntity<Pessoa> update(@RequestBody Pessoa
	 * pessoa) { return new ResponseEntity<Pessoa>(this.service.save(pessoa),
	 * HttpStatus.OK); }
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		this.repo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
