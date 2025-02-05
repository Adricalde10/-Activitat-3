package castellet.adrian.SportHealth;

import org.bson.Document;

public class Usuaris {
	String id;
    String name;
    int edat;
    
    public Usuaris(String name,String id, int edat) {
        this.name = name;
        this.id = id;
        this.edat = edat;
    }
    
    public String getName() {  // Corregido el nombre del método
        return name;
    }
    public String getId() {
    	return id;
    }
    public int getEdat() {
    	return edat;
    }

    public void setName(String name) {  // Corregido el nombre del método
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEdat(int edat) {
    	this.edat=edat;
    }


    @Override
    public String toString() {
        return "Usuari [\n  name=" + name + " id= " +id+" edat= "+edat+ "\n]";
    }

    public Document toDocument() {
        return new Document("nom", this.name)
        		.append("_id", this.id)
        		.append("edat",this.edat);
        
    }
}
