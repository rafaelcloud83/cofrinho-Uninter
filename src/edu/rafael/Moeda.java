package edu.rafael;

import java.util.Objects;

/***
 * Classe abstrata Moeda, que será usado o conceito de Polimorfismo e Herança
 * @author rafael
 */
public abstract class Moeda { // classe mãe
	
	public double valor;
	
	public Moeda(double valor) { // método construtor
		this.valor = valor;
	}
	
	// métodos para serem implementados nas classes filhas
	abstract void info();
	abstract double converter();

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}

	@Override
	public boolean equals(Object obj) { // método de comparação de objetos
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moeda other = (Moeda) obj;
		return Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
}