package beans;

public class Etudiant {
private String nom,prenom,filiere,cin;
public Etudiant() {
	
}

public Etudiant(String nom, String prenom, String filiere, String cin) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.filiere = filiere;
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getFiliere() {
	return filiere;
}
public void setFiliere(String filiere) {
	this.filiere = filiere;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}

@Override
public String toString() {
	return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", filiere=" + filiere + ", cin=" + cin + "]";
}
 
}
