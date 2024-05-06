package br.banco.cofrinho.moedas;


// classe Dolar que está herdando Moeda
public class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Dolar: %.2f%n", super.valor);
    }

    @Override
    public double converter() {
        return super.valor * 5;
    }
    @Override
    public double getValor() {
        return super.valor;
    }
}
