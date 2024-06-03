import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoeficienteDeConversao {

    Gson gson = new Gson();
    BaseJson baseJson;


    public double valorCoeficienteConversao(String moedaReferencia, String moedaConvertida) {

        String urlAPI = "https://v6.exchangerate-api.com/v6/5ccba2eba7621794d3e0b1c5/latest/" + moedaReferencia;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlAPI)).build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            baseJson = gson.fromJson(response.body(), BaseJson.class);
            return baseJson.conversion_rates().get(moedaConvertida);

        } catch (IOException | RuntimeException | InterruptedException e) {
            throw new RuntimeException("Valor inválido.");
        }

    }






}
