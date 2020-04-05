package br.com.goodmann.imagine.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository repo;

	@PostMapping
	public ResponseEntity<Pessoa> add(@RequestBody Pessoa Pessoa) {
		Pessoa p = new Pessoa("Alexandre", "60003880206", "51981204068", "alexandregoodmann@gmail.com");
		this.repo.save(p);
		return new ResponseEntity<Pessoa>(p, HttpStatus.CREATED);
	}

	/*
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Pessoa> getById(@PathVariable
	 * String id) { Pessoa p = new Pessoa(); return new ResponseEntity<Pessoa>(p,
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping public ResponseEntity<List<Pessoa>> getAllId() { List<Pessoa> l =
	 * new ArrayList<Pessoa>(); return new ResponseEntity<List<Pessoa>>(l,
	 * HttpStatus.OK); }
	 * 
	 * 
	 * 
	 * @PutMapping("Pessoa") public ResponseEntity<Pessoa> updatePessoa(@RequestBody
	 * Pessoa Pessoa) { return new ResponseEntity<Pessoa>(Pessoa, HttpStatus.OK); }
	 * 
	 * @DeleteMapping("Pessoa/{id}") public ResponseEntity<Void>
	 * deletePessoa(@PathVariable("id") Integer id) { return new
	 * ResponseEntity<Void>(HttpStatus.NO_CONTENT); }
	 */
}
