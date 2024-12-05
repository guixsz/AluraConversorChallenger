package org.example.UI;

import org.example.Converter.CurrencyConverter;

import java.util.Scanner;


public class Console {

    static CurrencyConverter currencyConverter = new CurrencyConverter();

    public static void start() throws NullPointerException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("\n*******************************\n");
        System.out.println("Bem vindo ao super convertor de moedas");
        int numero;
        System.out.println("""
                1) Real -> Dólar
                2) Real -> Peso argentino
                3) Real -> Euro
                4) Dólar -> Real
                5) Peso Argentino -> Real
                6) Euro -> Real
                7) Outras opções
                0) Sair
                                    
                Escolha uma opção:""");
        numero = leitura.nextInt();

        switch (numero) {
            case 0: System.out.println("Programa finalizando");
                break;
            case 1: currencyConverter.coinConverse("BRL", "USD", "Real para Dólar");
                break;
            case 2: currencyConverter.coinConverse("BRL", "ARS", "Real para peso Argentino");
                break;
            case 3: currencyConverter.coinConverse("BRL", "EUR", "Real para Euro");
                break;
            case 4: currencyConverter.coinConverse("USD", "BRL", "Dólar para Real");
                break;
            case 5: currencyConverter.coinConverse("ARS", "BRL", "Peso Argentino para Real");
                break;
            case 6: currencyConverter.coinConverse("EUR", "BRL", "Euro para Real");
                break;
            case 7: ConsoleOutrasOpcoes.exibirMenuOutrasOpcoes();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente");
        }

    }
}