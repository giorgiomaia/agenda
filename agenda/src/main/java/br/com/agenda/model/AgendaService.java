package br.com.agenda.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.agenda.view.Tela;

public class AgendaService {

	ContatoDAO dao = new ContatoDAO();

	public String cadastrarContatoServ(Contato contato) throws SQLException {
		String mensagem = "";

		if (dao.cadastrarDao(contato)) {
			mensagem = "Cadastro Realizado.";
		} else {
			mensagem = "Erro ao Cadastrar Contato.";
		}

		return mensagem;
	}

	public List<Contato> listarContatoServ() throws SQLException {
		List<Contato> listaContatosDB = dao.listarContatosDao(); // atribui os registros recuperados � lista

		return listaContatosDB;
	}

	public String excluirContatoServ(int idEx) {
		String mensagem = "";
		try {
			if (dao.buscarContato(idEx).getId() != idEx) {
				mensagem = "CONTATO NÃO IDENTIFICADO.\n";
			} else {
				dao.excluirDao(idEx);
				mensagem = "Processo realizado.\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mensagem;
	}

	public String editarContato(int edId, Contato contatoServ) {
		String mensagem = "";
		try {
			if (dao.buscarContato(edId).getId() != edId) {
				mensagem = "CONTATO NÃO IDENTIFICADO.";
			} else {
				dao.editarDao(edId, contatoServ);
				mensagem = "Alterado com Sucesso!\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensagem;
	}

}
