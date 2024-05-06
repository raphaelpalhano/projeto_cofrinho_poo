package br.banco.cofrinho;

import br.banco.cofrinho.cofre.Cofrinho;
import br.banco.cofrinho.moedas.Dolar;
import br.banco.cofrinho.moedas.Euro;
import br.banco.cofrinho.moedas.Real;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.sistemaCofrinho();
    }
}
