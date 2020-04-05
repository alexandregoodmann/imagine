package br.com.goodmann.imagine.imagem;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Imagem {

	@Id
	private String id;

	private String idPessoa;

	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
