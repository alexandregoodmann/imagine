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
@RequestMapping(value = "v1/pessoas/")
public class ImagemController {

	@Autowired
	private ImagemService service;

	@Autowired
	private ImagemRepository repo;

	@PostMapping("/{idPessoa}/imagens")
	public ResponseEntity<String> create(@PathVariable("idPessoa") String idPessoa,
			@RequestParam("file") MultipartFile file) throws IOException {

		return new ResponseEntity<String>(this.service.create(idPessoa, file), HttpStatus.CREATED);
	}

	@GetMapping("/{idPessoa}/imagens/{idImagem}")
	public ResponseEntity<Imagem> find(@PathVariable("idPessoa") String idPessoa,
			@PathVariable("idImagem") String idImagem) {
		return new ResponseEntity<Imagem>(repo.findById(idImagem).get(), HttpStatus.OK);
	}

	@GetMapping("/{idPessoa}/imagens")
	public ResponseEntity<List<Imagem>> findAll(@PathVariable(required = true, name = "idPessoa") String idPessoa) {
		return new ResponseEntity<List<Imagem>>(this.repo.findAllByPessoa(new Pessoa(idPessoa)), HttpStatus.OK);
	}

}
