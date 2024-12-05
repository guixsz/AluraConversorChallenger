package org.example.UI;

import org.example.Converter.CurrencyConverter;

import java.util.Scanner;

import static org.example.UI.ClearScreen.centralizarTexto;

public class Console {


    public static void start() throws InterruptedException {
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

        while (numero != 0) {
            if (numero == 1) {
                try {
                    Double currency = CurrencyConverter.currency("BRL", "USD");
                    System.out.println("Digite o valor que quer converter");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de R$ %.2f convertido é: %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("*****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("*****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 2) {
                System.out.println("A conversão de BRL para ARS é: ");
                try {
                    Double currency = CurrencyConverter.currency("BRL", "ARS");
                    System.out.println("Digite o valor que quer converter:");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de %.2f convertido é: %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 3) {
                System.out.println("A conversão de BRL para EUR");
                try {
                    Double currency = CurrencyConverter.currency("BRL", "EUR");
                    System.out.println("Digite o valor que quer converter");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de %.2f convertido é %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 4) {
                System.out.println("A conversão de USD para BRL");
                try {
                    Double currency = CurrencyConverter.currency("USD", "BRL");
                    System.out.println("Digite o valor que quer converter: ");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de %.2f convertido é %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 5) {
                System.out.println("A conversão de ARS para BRL");
                try {
                    Double currency = CurrencyConverter.currency("ARS", "BRL");
                    System.out.println("Digite o valor que quer converter: ");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de %.2f convertido é %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 6) {
                System.out.println("A conversão de EUR para BRL");
                try {
                    Double currency = CurrencyConverter.currency("EUR", "BRL");
                    System.out.println("Digite o valor que quer converter: ");
                    leitura.nextLine();
                    String moedaString = leitura.nextLine().replace(",", ".");

                    Double moeda = Double.parseDouble(moedaString);

                    String texto = String.format("O valor de %.2f convertido é %.2f", moeda, (moeda * currency));

                    System.out.println();
                    centralizarTexto("****************");
                    centralizarTexto(texto);
                    centralizarTexto("Enter para retornar");
                    centralizarTexto("****************");
                    leitura.nextLine();
                    ClearScreen.clearScreen();
                    Console.start();
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor digitado é inválido");
                }
            }
            if (numero == 7) {
                ConsoleOutrasOpcoes.exibirMenuOutrasOpcoes();
            }

        }
    }
}