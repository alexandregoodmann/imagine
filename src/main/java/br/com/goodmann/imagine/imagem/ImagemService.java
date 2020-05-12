package br.com.goodmann.imagine.imagem;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.goodmann.imagine.pessoa.Pessoa;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository repo;

	public String create(String idPessoa, MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		Imagem img = new Imagem();
		img.setPessoa(new Pessoa(idPessoa));
		img.setImagem(bytes);

		return this.repo.save(img).getId();
	}

}
