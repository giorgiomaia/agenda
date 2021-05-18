package br.com.agenda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDb {
	// Abre a conexao com MySql
	public Connection abrirConexao() throws SQLException {
		// Vari�veis da conexao
		String servidor = "localhost";
		String porta = ":3307";
		String nomeBanco = "agenda";
		String usuario = "root";
		String senha = "usbw";
		
		// Aponta a conexão para o Driver do banco de dados
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Monta URL de conexao (a assinatura � jdbc + tipo de banco + servidor + nome do banco)
		String url = "jdbc:mysql://" + servidor + porta + "/" + nomeBanco;

		// Interface de conexao com o BD
		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		return conexao;
	}
	
	//Fechar conexao com o MySql
	public void fecharConexao(Connection conexao) throws SQLException {
		conexao.close();
	}
	
	

}
