package org.example.Converter;

import com.google.gson.Gson;
import org.example.record.MoedaFormatada;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

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
}
