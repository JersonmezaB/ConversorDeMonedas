package gestor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GestorMoneda {

    String json = "";

    public double calcularConversionMoneda(double monedaBase,double monedaRef,double cantida) {

        return cantida * (monedaRef / monedaBase);
    }

    public void obtnerMoneda(String modena){

        HttpResponse<String> response = null;
        String direccionApi = "https://v6.exchangerate-api.com/v6/324877dee1fd41c2395ebeb1/latest/"+modena;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionApi))
                .build();


        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Pelicula no encontrada");
        }


    }

    public double obtenerValorMoneda(String tipoMoneda){

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(json);
        JsonObject jsonobj = root.getAsJsonObject();

        String moneda = jsonobj.get("conversion_rates")
                .getAsJsonObject().get(tipoMoneda).getAsString();

        return Double.parseDouble(moneda);
    }
}
