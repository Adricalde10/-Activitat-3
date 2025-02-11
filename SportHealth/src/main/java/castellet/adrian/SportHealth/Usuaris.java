package castellet.adrian.SportHealth;

import org.bson.Document;

public class Usuaris {
    String name;
    int edat;
    int pes;
    int altura;
    String genere;
    String data_registre;
    
    public Usuaris(String name, int edat, int pes,int altura,String genere, String data_registre) {
        this.name = name;
        this.edat = edat;
        this.pes = pes;
        this.altura = altura;
        this.genere = genere;
        this.data_registre = data_registre;
    }
    
    public String getName() {  // Corregido el nombre del método
        return name;
    }
    public int getEdat() {
    	return edat;
    }
    public int getPes() {
    	return pes;
    }
    public int getAltura() {
    	return altura;
    }
    public String getGenere() {
    	return genere;
    }
    public String getDataRegistre() {
    	return data_registre;
    }
    public void setName(String name) {  // Corregido el nombre del método
        this.name = name;
    }
    public void setEdat(int edat) {
    	this.edat=edat;
    }
    public void setPes(int pes) {
    	this.pes=pes;
    }
    public void setAltura(int altura) {
    	this.altura = altura;
    }
    public void setGenere(String genere) {
    	this.genere = genere;
    }
    public void SetDataRegistre(String data_registre) {
    	this.data_registre = data_registre;
    }
    @Override
    public String toString() {
        return "Usuari [\n  name=" + name + " edat= "+edat+ " Pes: "+ pes+ " altura= "+ altura+ " genere= "+genere+" data_registre" + data_registre +"\n]";
    }
    

    public Document toDocument() {
        return new Document("nom", this.name)
        		.append("edat",this.edat)
        		.append("edat",this.pes)
        		.append("altura", this.altura)
        		.append("genere", this.genere)
        		.append("data_registre", data_registre);
    }
}
