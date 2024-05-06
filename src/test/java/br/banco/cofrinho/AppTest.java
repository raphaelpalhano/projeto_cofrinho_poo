package br.banco.cofrinho;

import br.banco.cofrinho.cofre.Cofrinho;
import br.banco.cofrinho.moedas.Dolar;
import br.banco.cofrinho.moedas.Euro;
import br.banco.cofrinho.moedas.Real;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.money.Monetary;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionarMoeda(new Real(0.50));
        cofrinho.adicionarMoeda(new Dolar(0.50));
        cofrinho.adicionarMoeda(new Euro(0.50));
        cofrinho.adicionarMoeda(new Euro(0.50));
        cofrinho.removerMoeda();

        cofrinho.listarMoedas();
    }

    public void testCase() {
        int brl = Monetary.getCurrency("BRL").getDefaultFractionDigits();
        System.out.println(brl);
    }
}
