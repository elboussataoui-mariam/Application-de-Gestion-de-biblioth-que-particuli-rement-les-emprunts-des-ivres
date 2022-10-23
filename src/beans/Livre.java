package beans;

public class Livre {
	private String titre;
	private int numero_edition;
	private String date_apparition;
	private int stock;
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNumero_edition() {
		return numero_edition;
	}
	public void setNumero_edition(int numero_edition) {
		this.numero_edition = numero_edition;
	}
	public String getDate_apparition() {
		return date_apparition;
	}
	public void setDate_apparition(String date_apparition) {
		this.date_apparition = date_apparition;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Livre(){
		
	}
	
	public Livre(String titre, int numero_edition, String date_apparition, int stock) {
		super();
		this.titre = titre;
		this.numero_edition = numero_edition;
		this.date_apparition = date_apparition;
		this.stock = stock;
	}
	
	
}
