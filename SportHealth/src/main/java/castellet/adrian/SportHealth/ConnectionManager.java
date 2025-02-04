package castellet.adrian.SportHealth;


import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {
	public static void main(String[] args) {
        // Connexió a MongoDB Atlas
        String uri = "mongodb+srv://04adrianc:g9SkSHvjMaeNqX6b@cluster0.mpvz2.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SportHealth");
            MongoCollection<Document> collection = database.getCollection("Usuaris");
            System.out.println("Conexión exitosa a MongoDB: " + database.getName());
            menu();
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
        }  catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }
	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1. Insereix una document");
		System.out.println("2. Obtenir tots els documents");
		System.out.println("3. Obtenir documents per data");
	}
}