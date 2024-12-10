import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ae5b0a9969f81a9ca5ecf30d/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Conversor de Monedas ---");
                System.out.println("1. Convertir USD a BRL");
                System.out.println("2. Convertir BRL a USD");
                System.out.println("3. Convertir USD a ARS");
                System.out.println("4. Convertir ARS a USD");
                System.out.println("5. Convertir USD a COP");
                System.out.println("6. Convertir COP a USD");
                System.out.println("7. Salir");
                System.out.print("Elija una opción: ");

                int opcion = scanner.nextInt();
                if (opcion == 7) break;

                System.out.print("Ingrese el valor a convertir: ");
                double monto = scanner.nextDouble();

                String[] conversiones = {
                    "USD", "BRL", "USD", "BRL", 
                    "USD", "ARS", "ARS", "USD", 
                    "USD", "COP", "COP", "USD"
                };

                String monedaOrigen = conversiones[2 * (opcion - 1)];
                String monedaDestino = conversiones[2 * (opcion - 1) + 1];

                double tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino);
                double montoConvertido = monto * tasaCambio;

                System.out.printf("%.2f %s = %.2f %s%n", 
                    monto, monedaOrigen, 
                    montoConvertido, monedaDestino);

            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL + monedaOrigen))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        
        return conversionRates.get(monedaDestino).getAsDouble();
    }
}