package edu.rafael;

import java.util.ArrayList;

/***
 * Classe Cofrinho, adicionar moeda, remover moeda, listar moedas e mostrar total em Reais
 * @author rafael
 */
public class Cofrinho {
	// instância um ArrayList de Moeda chamado listaMoedas
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	// método adicionar recebendo Moeda
	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda); // adiciona moeda a lista
		System.out.println("***Moeda adicionada no Cofrinho!!!***");
	}
	
	// método remover recebendo Moeda
	public void remover(Moeda moeda) {
		if (!estaVazio()) { // verifica se o cofrinho está vazio, não estando vazio percorre a lista de moedas e compara se existe igual
			int contador = 0; 
			for (Moeda m : listaMoedas) {
				if (moeda.equals(m)) { // se existir igual incrementa o contador
					contador++;
				}
			}
			if (contador>0) { // e se o contador for maior que 0, ou seja, existindo a moeda ela é removida
				listaMoedas.remove(moeda);
				System.out.println("***Moeda removida do Cofrinho!!!***");
			} else { // e se não existir moeda com esse valor mostra a msg
				System.out.println("***Não existe moeda no Cofrinho com este valor!!!***");
			}
		}
	}
	
	// método para listar as moedas no cofrinho
	public void listagemMoedas() {
		if (!estaVazio()) { // verifica se o cofrinho está vazio, não estando vazio percorre a lista de moedas e mostra sua informação
			System.out.println("-------------Listar moedas--------------");
			for (Moeda moeda : listaMoedas) {
				moeda.info();
			}
		}
	}
	
	// método para converter o valor em Reais
	public void totalConvertido() {
		if (!estaVazio()) { // verifica se o cofrinho está vazio, não estando vazio percorre a lista de moedas e converte o total em Reais
			double valorTotal = 0;
			for (Moeda moeda : listaMoedas) {
				valorTotal += moeda.converter(); // soma o valor de cada moeda convertido para Reais
			}
			System.out.printf("Total convertido em Reais: R$ %.2f \n", valorTotal);
		}
	}
	
	// método para verificar se o cofrinho está vazio
	public boolean estaVazio(){
		if (listaMoedas.isEmpty()) { // se a lista está vazia
			System.out.println("***Não existe moeda no Cofrinho!!!***");
			return true; // retorna true
		} else {
			return false; // senão retorna false
		}
	}
}