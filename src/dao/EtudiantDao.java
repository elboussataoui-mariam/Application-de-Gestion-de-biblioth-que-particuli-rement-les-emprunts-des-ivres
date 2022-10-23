package dao;

import beans.Livre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import beans.Etudiant;


public class EtudiantDao {
	private static final boolean String = false;
	public static void Lister_etudiant() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
			String user="root";
			String password="";
			Connection conn =DriverManager.getConnection(url,user,password);
		String requete ="SELECT * FROM etudiant";
		Statement st=conn.createStatement();
		ResultSet rs= st.executeQuery(requete);// objet type Resultaset dans it met resultat
		while(rs.next()) {
			
			String cin=rs.getString("cin");
			String nom=rs.getString("nom");
			String prenom=rs.getString("prenom");
			String filiere=rs.getString("filiere");
			System.out.print(cin+" ,"+nom+","+prenom+","+filiere+"\n");
			}
}catch(ClassNotFoundException e) {
	e.printStackTrace();
}catch(SQLException e1) {
	e1.printStackTrace();
}
}	
		
	public static void supprimer_etudiant (Etudiant E) {
		System.out.println("voici la liste des étudiants ");
		Lister_etudiant();
		Scanner sc=new Scanner(System.in);
		System.out.println("entrer le cin de l'etudiant a supprimer ");
		String cin=sc.nextLine();
		E.setCin(cin);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
			String user="root";
			String password="";
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			String requet4="DELETE FROM etudiant where cin='"+E.getCin()+"'";
			int n3=st.executeUpdate(requet4);
			System.out.println("\t suppression avec succees.");
           
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
		public static void modifier_etudiant(Etudiant E) {
			try{
				Scanner input=new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn =DriverManager.getConnection(url,user,password);
				System.out.println("\t voici liste des étudiant: ");
				Lister_etudiant();
				System.out.println("\t choisir l'etudiant a modifier: ");
				String cinn=input.nextLine();
				E.setCin(cinn);
				while(true) {
				System.out.println("\t Que voulez vous modifier de cette etudiant: ");
		        
		            System.out.println("\t 0) annuler");
		            System.out.println("\t 1) cin:");
		            System.out.println("\t 2) nom:");
		            System.out.println("\t 3) prenom:");
		            System.out.println("\t 4) filiere:");
		            
		            String choix = input.nextLine();
		            switch (choix){
	                case "0": return;
	                case "1":
	                	Scanner in=new Scanner(System.in);
	                    System.out.println("\t Entrer new cin");
	                    String newcin=in.nextLine();
	                		String req ="UPDATE etudiant SET cin='"+newcin+"' WHERE cin='"+E.getCin()+"' ";
	                		Statement st=conn.createStatement();
	                		int nbre=st.executeUpdate(req);
	                		break;
	                case "2":
	                    System.out.println("\t Entrer new nom");
	                    String newnom=input.nextLine();
	                		String reqnom ="UPDATE etudiant SET nom='"+newnom+"' WHERE cin='"+E.getCin()+"' ";
	                		Statement stnom=conn.createStatement();
	                		//ResultSet rs= st.executeUpdate(req);
	                		int nbrenom=stnom.executeUpdate(reqnom);
	                		break;
	                case "3":
	                    System.out.println("\t Entrer new prenom");
	                    String newprenom=input.nextLine();
	                		String reqprenom ="UPDATE etudiant SET prenom='"+newprenom+"' WHERE cin='"+E.getCin()+"' ";
	                		Statement stprenom=conn.createStatement();
	                		int nbreprenom=stprenom.executeUpdate(reqprenom);break;
	                case "4":
	                    System.out.println("\t Entrer new filiere");
	                    String newfiliere=input.nextLine();
	                		String reqfiliere ="UPDATE etudiant SET filiere='"+newfiliere+"' WHERE cin='"+E.getCin()+"' ";
	                		Statement stfiliere=conn.createStatement();
	                		int nbrefiliere=stfiliere.executeUpdate(reqfiliere);
	                    System.out.println("\t Modification avec succees.");
	                    break;	            
		            }	
				}
		}catch(ClassNotFoundException e1) {
		e1.printStackTrace();
		}catch(SQLException e1) {
		e1.printStackTrace();
		}
			
		}
		public static void ajouter_etudiant(Etudiant E) {
			Scanner sc=new Scanner(System.in);
			System.out.println("entrer le cin de l'etudiant ");
			String cin=sc.nextLine();
			System.out.println("entrer le nom de l'etudiant ");
			String nom=sc.nextLine();
			System.out.println("entrer le prenom de l'etudiant ");
			String prenom=sc.nextLine();
			System.out.println("entrer la filiere de l'etudiant ");
			String filiere=sc.nextLine();
			//sc.nextLine();
			E.setCin(cin);
			E.setNom(nom);
			E.setPrenom(prenom);
			E.setFiliere(filiere); 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn=DriverManager.getConnection(url,user,password);
				Statement st=conn.createStatement();
				String requet2="INSERT INTO etudiant(cin,nom,prenom,filiere) VALUES('"+E.getCin()+"','"
				+E.getNom()+"','"+E.getPrenom()+"','"+E.getFiliere()+"');";
				int n1=st.executeUpdate(requet2);
				System.out.println("\t ajouter avec succees.");
               
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		public static Etudiant[] Liste_etudiant() throws ClassNotFoundException, SQLException {
			
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn =DriverManager.getConnection(url,user,password);
			String requete ="SELECT * FROM etudiant";
			Statement st=conn.createStatement();
			ResultSet rs= st.executeQuery(requete);// objet type Resultaset dans it met resultat
			int i = 0;
			Etudiant [] tab =new Etudiant[2];
			while(rs.next()) {
				
				String cin=rs.getString("cin");
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");
				String filiere=rs.getString("filiere");
				//System.out.print(cin+" ,"+nom+","+prenom+","+filiere+"\n");
				tab[i++]=new Etudiant(cin,nom,prenom,filiere);
				for(i=0;i<4;i++) {
					System.out.println(tab[i]);
				}
			
				}
	
			return tab;
			}
}
