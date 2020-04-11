package br.com.goodmann.imagine.pessoa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pessoa {

	@Id
	private String id;

	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotEmpty
	@Pattern(regexp = "[0-9]{11}", message = "CPF deverá ser somente os números")
	private String cpf;

	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{11})", message = "Número de telefone DDD + número. Ex: 51999334568")
	private String telefone;

	@Email(message = "Formato de email inválido")
	@NotEmpty
	private String email;

	public Pessoa() {
	}

	public Pessoa(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
