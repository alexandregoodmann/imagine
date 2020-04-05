package br.com.goodmann.imagine.imagem;

import java.util.List;

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
@RequestMapping(value = "/imagem")
public class ImagemController {

	@Autowired
	private ImagemRepository repo;

	@PostMapping
	public ResponseEntity<Imagem> add(@RequestBody Imagem imagem) {
		return new ResponseEntity<Imagem>(this.repo.save(imagem), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Imagem> getById(@PathVariable String id) {
		Imagem imagem = this.repo.findById(id).get();
		return new ResponseEntity<Imagem>(imagem, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Imagem>> getAll() {
		return new ResponseEntity<List<Imagem>>(this.repo.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		this.repo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
