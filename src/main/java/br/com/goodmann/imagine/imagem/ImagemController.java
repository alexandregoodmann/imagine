package br.com.goodmann.imagine.imagem;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.goodmann.imagine.pessoa.Pessoa;

@RestController
@RequestMapping(value = "/pessoa/imagem")
public class ImagemController {

	@Autowired
	private ImagemRepository repo;

	@PostMapping
	public ResponseEntity<String> add(@RequestParam String idPessoa, @RequestParam("file") MultipartFile file)
			throws IOException {

		byte[] bytes = file.getBytes();
		Imagem img = new Imagem();
		img.setPessoa(new Pessoa(idPessoa));
		img.setImagem(bytes);

		return new ResponseEntity<String>(this.repo.save(img).getId(), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Imagem> getById(@PathVariable String id) {
		return new ResponseEntity<Imagem>(repo.findById(id).get(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Imagem>> getAll() {
		return new ResponseEntity<List<Imagem>>(this.repo.findAll(), HttpStatus.OK);
	}

}
