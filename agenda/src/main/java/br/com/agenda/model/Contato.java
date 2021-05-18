package br.com.agenda.model;

import javax.faces.bean.ManagedBean;

@ManagedBean (name="contatoModel")

public class Contato {
//Atributos
	private int id;
	private String nomeContato;
	private String email;
	private String telefone;
	
//Construtor
	public Contato() {
		
	}
	
	public Contato(String nomeContato, String email, String telefone) {
		this.nomeContato = nomeContato;
		this.email = email;
		this.telefone = telefone;
	}
	
//Metodos Getters e Setters	
	public String teste() {
		String resultado = nomeContato + " " + email + " " + telefone;	
		return "";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Contato: " + nomeContato + ", email:" + email + ", Telefone:" + telefone;
	}
	

}
