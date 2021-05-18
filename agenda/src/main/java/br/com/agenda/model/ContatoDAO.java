package br.com.agenda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	// Cadastrar no banco
	public boolean cadastrarDao(Contato contato) throws SQLException {
		// insirir instru��es SQL
		String sql = "INSERT INTO contato (nome, fone, mail) VALUES (?, ?, ?)";

		ConexaoDb conexao = new ConexaoDb(); // Criar objeto de conexao com o BD
		Connection con = conexao.abrirConexao();// Criar inteface de conexao
		PreparedStatement stm = con.prepareStatement(sql);// Criar Stateman para organizar os dados nos campos corretos

		// Organizando os dados na posicao correta dos campos
		stm.setString(1, contato.getNomeContato());
		stm.setString(2, contato.getTelefone());
		stm.setString(3, contato.getEmail());

		stm.execute(); // Executar os comandos no banco
		stm.close(); // Fecha o Stateman

		conexao.fecharConexao(con); // Fecha conexao com o BD
		return true;
	}
	
	// Listar no banco
	public List<Contato> listarContatosDao() throws SQLException {
		String sql = "SELECT * FROM contato"; // Instru��o SQL para buscar registros no banco

		ConexaoDb conexao = new ConexaoDb(); // Cria obj de conexao com o BD
		Connection con = conexao.abrirConexao(); // Cra interface de conexao
		PreparedStatement stm = con.prepareStatement(sql); // Cria stateman de organiza��o dos dados

		ResultSet resultadoDaBusca = stm.executeQuery();// Executa SQL e guardar o resultado que vem do BD

		List<Contato> listaDb = new ArrayList<Contato>(); // Cria lista para armazenar os resultados da consulta
		// Percorre a lista armazenando o resultado encontrado
		while (resultadoDaBusca.next()) {
			Contato contato = new Contato();// cria obj contato para atribuir os valores encontrados no BD
			contato.setId(resultadoDaBusca.getInt(1));
			contato.setNomeContato(resultadoDaBusca.getString(2));
			contato.setTelefone(resultadoDaBusca.getString(3));
			contato.setEmail(resultadoDaBusca.getString(4));

			listaDb.add(contato); // adiciona o objeto preenchido na lista
		}
		stm.close(); // Fechar Stateman
		conexao.fecharConexao(con);// Fechar Conexao BD

		return listaDb;
	}

	// excluir no banco
	public void excluirDao(int idEx) throws SQLException {
		String sql = "DELETE FROM contato WHERE id = " + idEx;

		ConexaoDb conexao = new ConexaoDb();
		Connection connection = conexao.abrirConexao();
		PreparedStatement stm = connection.prepareStatement(sql);

		stm.execute();
		stm.close();
		conexao.fecharConexao(connection);
	}

	// alterar no banco
	public void editarDao(int idContato, Contato edContato) throws SQLException {
		String sql = "UPDATE contato SET nome = ?, fone = ?, mail = ? WHERE id = " + idContato;

		ConexaoDb conexao = new ConexaoDb();
		Connection connection = conexao.abrirConexao();
		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setString(1, edContato.getNomeContato());
		stm.setString(2, edContato.getTelefone());
		stm.setString(3, edContato.getEmail());
		stm.execute();
		stm.close();
		conexao.fecharConexao(connection);
	}

	// pesquisar no banco
	public Contato buscarContato(int contEd) throws Exception {
		String sql = "SELECT * FROM contato WHERE id = " + contEd;

		Contato buscaContato = new Contato();
		ConexaoDb conexao = new ConexaoDb();
		Connection con = conexao.abrirConexao();
		PreparedStatement stm = con.prepareStatement(sql); // Cria stateman de organiza��o dos dados

		ResultSet resultadoDaBusca = stm.executeQuery();// Executa SQL e guardar o resultado que vem do BD

		while (resultadoDaBusca.next()) { // retorna apenas um ou nenhum
			buscaContato.setId(resultadoDaBusca.getInt("id"));
			buscaContato.setNomeContato(resultadoDaBusca.getString("nome"));
			buscaContato.setTelefone(resultadoDaBusca.getString("fone"));
			buscaContato.setEmail(resultadoDaBusca.getString("mail"));
		}

		stm.close();
		conexao.fecharConexao(con);
		return buscaContato;
	}

}
