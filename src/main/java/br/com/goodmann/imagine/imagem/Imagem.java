package br.com.goodmann.imagine.imagem;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.goodmann.imagine.pessoa.Pessoa;

@Document
public class Imagem {

	@Id
	private String id;

	@JsonIgnore
	@DBRef(lazy = true)
	private Pessoa pessoa;

	private byte[] imagem;

	public String getIdPessoa() {
		return this.pessoa == null ? null : this.pessoa.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
