package br.banco.cofrinho.moedas;

// classe Euro que está herdando Moeda
public class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Euro: %.2f%n", super.valor);
    }

    @Override
    public double converter() {
        return super.valor * 5.50;
    }

    @Override
    public double getValor() {
        return super.valor;
    }
}
