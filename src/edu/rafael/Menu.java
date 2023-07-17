package edu.rafael;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Classe Menu, abrir o menu principal, menu de adicionar moeda e menu de remover moeda
 * @author rafael
 */
public class Menu {
	// declaração de variáveis
	Scanner teclado;
	Cofrinho cofrinho = new Cofrinho();
	Moeda moeda;
	int opcao;
	double valor;
	boolean ehValido;
	
	// método que abre o menu principal
	public void abrirMenuPrincipal() {
		// atribuição de valor na variável
		opcao = -1;
		// início do laço do while, onde o que está no do vai ser executado pelo menos uma vez
		do {
			// exibição do menu principal no console
			System.out.print("----------------COFRINHO----------------\n"
					+ "1-Adicionar Moeda\n"
					+ "2-Remover Moeda\n"
					+ "3-Listar Moedas\n"
					+ "4-Calcular total convertido para Real\n"
					+ "0-Encerrar\n"
					+ "Escolha uma das opções acima:\n>>> ");
			teclado = new Scanner(System.in); // recebe o valor digitado e atribui a variável teclado
			try { // tratamento de excessão
				opcao = teclado.nextInt(); // tenta fazer essa linha e se der erro gera uma exceção
			} catch (Exception e) {
				System.out.print("Valor não inteiro!!! "); // mostra uma exceção amigavel ao usuário
			}
			if (opcao<0 || opcao>4) { // verifica se está entre 0 e 4
				System.out.println("Opção inválida, digite um número entre 0 e 4!!!");
			}
		} while (opcao<0 || opcao>4); // enquanto não for de 0 a 4, continua exibindo o menu
		// comando de decisão switch case
		switch (opcao) {
			case 1: { // se a opção for 1, exibe o menuAdicionarMoeda()
				menuAdicionarMoeda();
				break;
			}
			case 2: { // se a opção for 2, exibe o menuRemoverMoeda()
				menuRemoverMoeda();
				break;
			}
			case 3: { // se a opção for 3, exibe o listagemMoedas() que está dentro de cofrinho
				cofrinho.listagemMoedas();
				break;
			}
			case 4: { // se a opção for 4, exibe o totalConvertido() que está dentro de cofrinho
				cofrinho.totalConvertido();
				break;
			}
			case 0: { // se a opção for 0, finaliza o programa
				System.out.println("Finalizando o programa!!!");
				System.exit(0);
			}
		}
		abrirMenuPrincipal(); // se a opção for do 1 ao 4 mostra o menu novamente	
	}
	
	// método para adicionar moeda
	private void menuAdicionarMoeda() {
		cofrinho.adicionar(adicionarOuRemoverMoeda()); // chama o método adicionarOuRemoverMoeda() que retorna a moeda para ser adicionada
	}

	// método para remover moeda
	private void menuRemoverMoeda() {
		if (!cofrinho.estaVazio()) { // verifica se o cofrinho não está vazio
			cofrinho.remover(adicionarOuRemoverMoeda()); // chama o método adicionarOuRemoverMoeda() que retorna a moeda para ser removida
		}
	}
	
	// método para adicionar ou remover moeda
	private Moeda adicionarOuRemoverMoeda() {
		// atribuição de valores iniciais as variáveis
		opcao = -1;
		valor = 0.00;
		ehValido = false;
		// início do laço do while, onde o que está no do vai ser executado pelo menos uma vez
		do {
			// exibição do menu Tipo da Moeda no console
			System.out.print("--------------Tipo da Moeda-------------\n"
					+ "1-Real\n"
					+ "2-Dolar\n"
					+ "3-Euro\n"
					+ "Escolha um tipo de Moeda acima:\n>>> ");
			teclado = new Scanner(System.in); // recebe o valor digitado e atribui a variável teclado
			try { // tratamento de excessão
				opcao = teclado.nextInt(); // tenta fazer essa linha e se der erro gera uma exceção
			} catch (Exception e) {
				System.out.print("Valor não inteiro!!! "); // mostra uma exceção amigavel ao usuário
			}
			if (opcao<1 || opcao>3) { // verifica se está entre 1 e 3
				System.out.println("Opção inválida, digite um número entre 1 e 3!!!");
			}
		} while (opcao<1 || opcao>3); // enquanto não for de 1 a 3, continua exibindo o menu Tipo da Moeda
		
		// laço que verifica se o usuário digitou um valor double, OBS.: no meu pc o padrão é virgula
		while (!ehValido) { // enquanto não for válido, executa o que está no while
			System.out.print("Digite o valor: ");
			try { // tratamento de excessão
				valor = teclado.nextDouble(); // tenta fazer essa linha e se der erro gera uma exceção
				ehValido = true; // muda para true o valor da variável
			} catch (InputMismatchException e) { // erro caso digite um valor com ponto
				System.out.println("Valor não monetário! Usar a vírgula no lugar do ponto. EX: 0,50 !!!"); // mostra uma exceção amigavel ao usuário
			} catch (Exception e) {
				System.out.println("Ocorreu um erro, verifique se digitou tudo corretamente!!!"); // mostra uma exceção amigavel ao usuário
			} finally {
				teclado.nextLine(); // limpa o buffer do teclado
			}
		}
		// comando de decisão switch case
		switch (opcao) {
		// conceito de polimorfismo abaixo, onde o objeto moeda da classe mãe Moeda é instanciado, ou seja, criado como classe filha (Real, Dolar ou Euro)
			case 1: { // se a opção for 1, atribui o valor a moeda do tipo Real
				moeda = new Real(valor);
				break;
			}
			case 2: { // se a opção for 2, atribui o valor a moeda do tipo Dolar
				moeda = new Dolar(valor);
				break;
			}
			case 3: { // se a opção for 3, atribui o valor a moeda do tipo Euro
				moeda = new Euro(valor);
				break;
			}
		}
		return moeda; // retorna a moeda adicionada ou removida ao método que chamou o adicionarOuRemoverMoeda()
	}
}