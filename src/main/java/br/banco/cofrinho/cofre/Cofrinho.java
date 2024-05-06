package br.banco.cofrinho.cofre;

import br.banco.cofrinho.enums.ConstantesConfrinho;
import br.banco.cofrinho.moedas.Dolar;
import br.banco.cofrinho.moedas.Euro;
import br.banco.cofrinho.moedas.Moeda;
import br.banco.cofrinho.moedas.Real;

import java.util.ArrayList;
import java.util.Scanner;

public class Cofrinho {

    // declarando a variável que guarda as moedas em um array
    private final ArrayList<Moeda> listaMoeda;


    // inicializando a variável através da instância do objeto Cofrinho
    public Cofrinho() {
        listaMoeda = new ArrayList<>();
    }


    // Método publico utilizado para chamadas de todos outros métodos, esse método controla o sistema de cofrinho
    public void sistemaCofrinho() {
        boolean condicional = true;
        while (condicional) {
            int option = this.optionMenuOperacao();
            switch (option) {
                case 0:
                    System.out.println("Saindo do sistema Cofrinho...");
                    try {
                        condicional = false;
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 1:
                    Moeda moeda = this.instanceMoeda();
                    this.adicionarMoeda(moeda);
                    break;
                case 2:
                    this.removerMoeda();
                    break;
                case 3:
                    this.listarMoedas();
                    break;
                case 4:
                    this.converterTotalReal();
                    break;
                default:
                    throw new IllegalStateException("Valor incorreto" + option);
            }
        }

    }


    // Método que faz o cálculo de todos valores para conversão em real
    public void converterTotalReal() {
        double total = 0.0;
        for(Moeda moeda: listaMoeda) {
            total = total + moeda.converter();
        }
        System.out.printf("Total convertido R$ %.2f%n\n", total);
    }


    // Método interno para controlar a instanciação das moedas, de modo que siga o menu
    private Moeda instanceMoeda () {
        Moeda moeda = null;
        int optionMoeda = this.optionMenuMoedas();
        double valor = this.inputValor();
        switch (optionMoeda) {
            case 1:
                moeda = new Real(valor);
                break;
            case 2:
                moeda = new Dolar(valor);
                break;
            case 3:
                moeda = new Euro(valor);
                break;
            default:
                throw new IllegalStateException("opcao invalida" + optionMoeda);
        }

        return  moeda;
    }


    // Método para adicionar as moedas no Array e imprimir o nome da moedas
    public void adicionarMoeda(Moeda moeda) {
        String [] valor = moeda.getClass().getName().split("\\.");
        String nomeMoeda = valor[valor.length -1];
        System.out.printf("Moeda %s adicionada com sucesso! \n", nomeMoeda);
        this.listaMoeda.add(moeda);
    }

    // método para listagem de moedas com info abstract
    public void listarMoedas() {
        for(Moeda moeda: listaMoeda) {
            moeda.info();
        }
    }


    // Método para remover a moeda utilizando Predicate
    public void removerMoeda() {
        int menuMoeda = this.optionMenuMoedas();
        double valor = inputValor();
        listaMoeda.removeIf(moeda -> {
            boolean shouldRemove = false;
            switch (menuMoeda) {
                case 1:
                    shouldRemove = (moeda instanceof Real && moeda.getValor() == valor);
                    break;
                case 2:
                    shouldRemove = (moeda instanceof Dolar && moeda.getValor() == valor);
                    break;
                case 3:
                    shouldRemove = (moeda instanceof Euro && moeda.getValor() == valor);
                    break;
            }
            return shouldRemove;
        });

    }


    // metodo para imprimir o menu de operacao
    private int optionMenuOperacao() {
        Scanner input = new Scanner(System.in);
        int option = -1;
        while (option < 0 || option > 4) {
            System.out.print
            ("1 - Adicionar Moeda \n " +
            "2 - Remover Moeda \n " +
            "3 - Listar Moedas \n " +
            "4 - Calcular total convertido para real \n " +
            "0 - Encerra sistema \n" +
            "opcao: "
                    );
            String entrada = input.nextLine();
            try {
                option = Integer.parseInt(entrada);
            } catch (Exception e) {
                System.out.print("Opcao digitada inválida! \n");
            }

        }
        return option;
    }




    // método para imprimir o menu moedas
    private int optionMenuMoedas() {
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (option < 1 || option > 3) {
            System.out.print
                    ("Escolha a moeda: \n" +
                            "1 - Real \n " +
                            "2 - Dolar \n " +
                            "3 - Euro \n " +
                            "opcao: ");
            String entrada = input.nextLine();
            try {
                option = Integer.parseInt(entrada);

            } catch (Exception e) {
                System.out.print("Opcao digitada inválida! \n");
            }
            System.out.print("Digite o valor: ");

        }

        return option;
    }


    // método para solicitar o input de valor
    private double inputValor() {
        Scanner input = new Scanner(System.in);
        double valor = 0.0;
        while (valor <= 0 || valor > 1) {
            System.out.print("Digite o valor: ");
            String entrada = input.nextLine();
            try {
                valor = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número válido.");
            }
        }
        return valor;
    }

}
