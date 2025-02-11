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
import com.mongodb.client.model.Filters;

public class ConnectionManager {
	static String uri = "mongodb+srv://04adrianc:g9SkSHvjMaeNqX6b@cluster0.mpvz2.mongodb.net";
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
			System.out.println("Introdueix el id:");
			String id = scanner.next();
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
			
			Usuaris usuari = new Usuaris(id, nom, edat, pes, altura, genere, data_registre);
			Document docu = usuari.toDocument();
			collection.insertOne(docu);
			System.out.println(usuari);
			break;
		case 2:
			FindIterable<Document> documents = collection.find();
			for (Document doc : documents) {
				System.out.println(doc.toJson());
			}
			break;
		case 3:
			System.out.println("Introdueix la data:");
			String dateInici = scanner.next();
			FindIterable<Document> documents2 = collection.find(Filters.and(
					Filters.gte("data_registre", "2025-01-21"),
					Filters.lte("data_registre", "2025-01-28"))
					);
			for (Document doc : documents2) {
				System.out.println(doc.toJson()+"\n\n");
			}
			break;
		}
	}
}