package edu.rafael;

/***
 * Classe Real (filha) que extende e herda de Moeda (mãe), aplicando o conceito de Herança
 * @author rafael
 */
public class Real extends Moeda{
	
	public Real(double valor) { // método construtor passando valor para a Classe Mãe Moeda
		super(valor);
	}
	
	// métodos sobreescrito da Classe Moeda
	@Override
	void info() {
		System.out.printf("Real - %.2f \n", valor);	
	}

	@Override
	double converter() {
		return valor;
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