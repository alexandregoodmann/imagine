package br.com.goodmann.imagine.pessoa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/pessoas")
public class PessoaController {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

	@Autowired
	private PessoaService service;

	@Autowired
	private PessoaRepository repo;

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> find(@PathVariable(required = true, name = "id") String id) {
		Optional<Pessoa> obj = this.repo.findById(id);
		if (obj.isPresent()) {
			return new ResponseEntity<Pessoa>(obj.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Pessoa> findByCPF(@PathVariable(required = true, name = "cpf") String cpf) {
		logger.trace("[FIND BY CPF] - Pessoa CPF:" + cpf);
		Pessoa obj = this.repo.findBycpf(cpf);
		if (obj != null) {
			return new ResponseEntity<Pessoa>(obj, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Pessoa pessoa) {
		logger.trace("[CREATE] - " + pessoa.toString());
		return new ResponseEntity<String>(service.create(pessoa), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(required = true, name = "id") String id,
			@RequestBody Pessoa pessoa) {
		logger.trace("[PUT] - " + pessoa.toString());
		return new ResponseEntity<String>(service.update(pessoa), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> updatePartial(@PathVariable(required = true, name = "id") String id,
			@RequestBody Pessoa pessoa) throws NotFoundException {
		logger.trace("[PATCH] - " + pessoa.toString());
		return new ResponseEntity<String>(service.updatePartial(pessoa), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true, name = "id") String id) {
		logger.trace("[DELETE] - Pessoa ID:" + id);
		this.repo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
