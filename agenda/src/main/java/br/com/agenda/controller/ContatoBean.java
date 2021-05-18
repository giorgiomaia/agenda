package br.com.agenda.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;

import br.com.agenda.model.AgendaService;
import br.com.agenda.model.Contato;

@RequestScoped
@ManagedBean(name = "contatoBean")
public class ContatoBean {
	// Atributos
	private int contBeanId;
	private String contBeanNome;
	private String contBeanFone;
	private String contBeanMail;
	
	// Atributos de Classe
	private Contato contato = new Contato();
	private AgendaService agenda = new AgendaService();
	private List<Contato> contatoBean = new ArrayList<Contato>();
	
	// MÉTODOS DA CLASSE
	public int getContBeanId() {
		return contBeanId;
	}

	public void setContBeanId(int contBeanId) {
		this.contBeanId = contBeanId;
	}
	
	public String getContBeanNome() {
		return contBeanNome;
	}

	public void setContBeanNome(String contBeanNome) {
		this.contBeanNome = contBeanNome;
	}

	public String getContBeanFone() {
		return contBeanFone;
	}

	public void setContBeanFone(String contBeanFone) {
		this.contBeanFone = contBeanFone;
	}

	public String getContBeanMail() {
		return contBeanMail;
	}

	public void setContBeanMail(String contBeanMail) {
		this.contBeanMail = contBeanMail;
	}

	public List<Contato> getListarContato() {
		try {
			contatoBean = agenda.listarContatoServ();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contatoBean;
	}

	public void gravarContatoBean() {
		contato.setNomeContato(getContBeanNome());
		contato.setTelefone(getContBeanFone());
		contato.setEmail(getContBeanMail());

		try {
			agenda.cadastrarContatoServ(contato);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarContatoBean() {
		contato.setNomeContato(getContBeanNome());
		contato.setTelefone(getContBeanFone());
		contato.setEmail(getContBeanMail());
		
		agenda.editarContato(getContBeanId(), contato);
	}
	
	public void excluirContatoBean() {
		agenda.excluirContatoServ(this.contBeanId);		
	}


}
