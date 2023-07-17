package edu.rafael;

/***
 * Classe Dolar (filha) que extende e herda de Moeda (mãe), aplicando o conceito de Herança
 * @author rafael
 */
public class Dolar extends Moeda{

	public Dolar(double valor) { // método construtor passando valor para a Classe Mãe Moeda
		super(valor);
	}
	
	// métodos sobreescrito da Classe Moeda
	@Override
	void info() {
		System.out.printf("Dolar - %.2f \n", valor);	
	}

	@Override
	double converter() {
		return valor * 3.00; // 3.00 é o valor do dolar em reais		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) { // método de comparação de objetos
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}