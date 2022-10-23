package beans;

public class Emprunt{
	
	private int numero_edition;
	private String cin,date_emprunt;
	//Date date_emprunt;
	public int getNumero_edition() {
		return numero_edition;
	}
	public void setNumero_edition(int numero_edition) {
		this.numero_edition = numero_edition;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(String date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public Emprunt(int numero_edition, String cin, String date_emprunt) {
		super();
		this.numero_edition = numero_edition;
		this.cin = cin;
		this.date_emprunt = date_emprunt;
	}
	public Emprunt() {
		super();
	}
	
	
	
}
	