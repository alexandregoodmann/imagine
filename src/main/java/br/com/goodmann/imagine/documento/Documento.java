package br.com.goodmann.imagine.documento;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.goodmann.imagine.core.BaseModel;
import br.com.goodmann.imagine.pessoa.Pessoa;

@Document
public class Documento extends BaseModel {

	@JsonIgnore
	@DBRef(lazy = true)
	private Pessoa pessoa;

	private String tipo;

	private String numero;

	public String getIdPessoa() {
		return this.pessoa == null ? null : this.pessoa.getId();
	}

	public void setIdPessoa(String id) {
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
			this.pessoa.setId(id);
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
