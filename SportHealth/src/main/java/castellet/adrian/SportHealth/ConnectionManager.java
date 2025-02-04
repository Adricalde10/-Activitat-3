package castellet.adrian.SportHealth;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {
    static String uri = "mongodb+srv://04adrianc:g9SkSHvjMaeNqX6b@cluster0.mpvz2.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    static MongoClient mongoClient = MongoClients.create(uri);
    static MongoDatabase database = mongoClient.getDatabase("SportHealth");
    static MongoCollection<Document> collection = database.getCollection("Usuaris");
	public static void main(String[] args) {
        // Connexió a MongoDB Atlas
        //String uri = "mongodb+srv://04adrianc:g9SkSHvjMaeNqX6b@cluster0.mpvz2.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        try {
            //MongoDatabase database = mongoClient.getDatabase("SportHealth");
            //MongoCollection<Document> collection = database.getCollection("Usuaris");
            System.out.println("Conexión exitosa a MongoDB: " + database.getName());
            menu();
            
            
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
		System.out.print("Posa una Opcio: ");
		int op = scanner.nextInt();
		switch(op) {
		case 1:
			Usuaris usuari = new Usuaris("Adrian");
           // Document docu = new Document("name", usuari.getName());
			System.out.println(usuari);
		case 2:
			FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
		case 3:
		
			FindIterable<Document> documents2 = collection.find();
            for (Document doc : documents2) {
                System.out.println(doc.toJson());
            }
		}
		}
}