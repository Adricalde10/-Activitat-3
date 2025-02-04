package castellet.adrian.SportHealth;

import java.util.List;

import org.bson.Document;

public class Usuaris {
    String name;
    
    public Usuaris (String name) {
    	this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
    	  return "Movie [\n  plot=" + name + "\n]";
}
    
    public Document toDocument(Usuaris user) {
		Document doc = new Document();
		doc.append("nom",user.getname());
		return doc;
	}
}
	
	