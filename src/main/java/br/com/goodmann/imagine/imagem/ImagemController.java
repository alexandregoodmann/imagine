package br.com.goodmann.imagine.imagem;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/imagem")
public class ImagemController {

	@Autowired
	private ImagemRepository repo;

	@PostMapping
	public ResponseEntity<String> add(@RequestParam("file") MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		Imagem i = new Imagem();
		i.setImagem(bytes);

		return new ResponseEntity<String>(this.repo.save(i).getId(), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Imagem>> getAll() {
		return new ResponseEntity<List<Imagem>>(this.repo.findAll(), HttpStatus.OK);
	}
	
}
