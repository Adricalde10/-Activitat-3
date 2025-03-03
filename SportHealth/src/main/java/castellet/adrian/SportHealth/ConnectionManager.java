package castellet.adrian.SportHealth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectionManager {

    public static void main(String[] args) {
        try {
            System.out.println("Conexión exitosa a Versel: "  );
            menu();
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }

    private static void sendUser(Usuaris usuari) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://m6-api.vercel.app/Usuaris"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(usuari.toJson()))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray users = new JSONArray(response.body());
            for (int i = 0; i < users.length(); i++) {
                System.out.println(users.getJSONObject(i).toString(2));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
   


    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean bucle = true;
        while (bucle) {
            System.out.println("Menu");
            System.out.println("1. Insereix una document");
            System.out.println("2. Obtenir tots els documents");
            System.out.println("3. Obtenir documents per data");
            System.out.println("4.Salir");
            System.out.print("Posa una Opcio: ");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Introdueix el nom:");
                    String nom = scanner.next();
                    System.out.println("Introdueix l'edat:");
                    int edat = scanner.nextInt();
                    System.out.println("Introdueix el Pes:");
                    int pes = scanner.nextInt();
                    System.out.println("Introdueix L'Altura:");
                    int altura = scanner.nextInt();
                    System.out.println("Introdueix el Genere:");
                    String genere = scanner.next();
                    System.out.println("Introdueix la data de registre:");
                    String data_registre = scanner.next();
                    Usuaris usuari = new Usuaris(nom, edat, pes, altura, genere, data_registre);
                    sendUser(usuari);
                    break;
                case 2:
                	
                    break;
                case 3:
                    System.out.println("Introdueix la data Inicial:");
                    String dateInici = scanner.next();
                    System.out.println("Introdueix la data Final:");
                    String dateFinal = scanner.next();
                    break;
                case 4:
                    System.out.println("Exit...");
                    bucle = false;
                    break;
            }
        }
    }
}
