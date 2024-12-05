package org.example.Converter;

import com.google.gson.Gson;
import org.example.UI.ClearScreen;
import org.example.UI.Console;
import org.example.record.MoedaFormatada;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static org.example.UI.ClearScreen.centralizarTexto;

public class CurrencyConverter {
    Scanner leitura = new Scanner(System.in);

    public CurrencyConverter() {
    }

    public static Double currency(String moedaOrigem, String moedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request =  HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/04a7c570add971632815eec2/pair/" + moedaOrigem + "/" + moedaDestino))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                Gson gson = new Gson();
                String json = response.body();
                MoedaFormatada retorno = gson.fromJson(json, MoedaFormatada.class);
                return retorno.conversion_rate();
            }   else {
                System.err.println("Erro ao obter taxa de câmbio.Código de status: " + response.statusCode());
                return null;
            }
        }   catch (IOException e) {
            System.err.println("Erro de E/S ao conectar à API: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.err.println("Thread interrompida durante a conexão à API: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void coinConverse(String moedaOrigem, String moedaDestino, String descricao) {
        System.out.printf("A conversão de %s:\n", descricao);

        try {
            Double currency = currency(moedaOrigem, moedaDestino);
            System.out.println("Digite o valor que quer converter: ");
            String coin = leitura.nextLine();

            String moedaString = coin.replace(",", ".");
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
        } catch (NumberFormatException | InterruptedException e) {
            System.out.println("Erro: valor digitado é inválido");;
        }
    }
}
