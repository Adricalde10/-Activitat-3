package castellet.adrian.SportHealth;


import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBCRUD {
	public static void main(String[] args) {
        // Connexió a MongoDB Atlas
        String uri = "mongodb+srv://04adrianc:g9SkSHvjMaeNqX6b@cluster0.mpvz2.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SportHealth");
            MongoCollection<Document> collection = database.getCollection("Entrades");

            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}