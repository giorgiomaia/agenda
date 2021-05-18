package br.com.agenda.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Tela {
	//Scanner input = new Scanner(System.in);

	public String menuAgenda() {
	/*	return JOptionPane.showInputDialog(		
				  "\n------------- MENU -------------"
				+ "\n 1. Cadastrar."
				+ "\n 2. Editar."
				+ "\n 3. Listar."
				+ "\n 4. Excluir."
				+ "\n 5. Sair.\n");
	*/
		String menu = 
				".:: MENU ::.\n"
				+ "\n 1. Cadastrar."
				+ "\n 2. Editar."
				+ "\n 3. Listar."
				+ "\n 4. Excluir."
				+ "\n 5. Sair.\n\n";
		return JOptionPane.showInputDialog(menu);
	}
	
	// recebe os dados informados pelo ususario
	public String input(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	// mostra a mensagem/resultado
	public void output(String mensagem) {
		System.out.println(mensagem);
	}
	
	/* mostra a mensagem/resultado no CONSOLE
	 * public void output(String mensagem) {
	 * JOptionPane.showMessageDialog(null, mensagem); }
	 */
}
