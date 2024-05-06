package br.banco.cofrinho.moedas;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Real: %.2f%n", super.valor);
    }

    @Override
    public double converter() {
        return super.valor * 1;
    }

    @Override
    public double getValor() {
        return super.valor;
    }

}
