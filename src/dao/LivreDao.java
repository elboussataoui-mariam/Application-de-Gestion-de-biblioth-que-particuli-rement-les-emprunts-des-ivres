
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import beans.Etudiant;
import beans.Livre;


public class LivreDao {
	private static final boolean String = false;
	public static void Lister_livre() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
			String user="root";
			String password="";
			Connection conn =DriverManager.getConnection(url,user,password);
		String requete ="SELECT * FROM livre";
		Statement st=conn.createStatement();
		ResultSet rs= st.executeQuery(requete);// objet type Resultaset dans it met resultat
		while(rs.next()) {
			
			String titre=rs.getString("titre");
			String numero_edition=rs.getString("numero_edition");
			String date_apparition=rs.getString("date_apparition");
			String stock=rs.getString("stock");
			System.out.print(titre+" ,"+numero_edition+","+date_apparition+","+stock+"\n");
			}
}catch(ClassNotFoundException e) {
	e.printStackTrace();
}catch(SQLException e1) {
	e1.printStackTrace();
}
}	
		
	public static void supprimer_livre(Livre  L) {
		System.out.println("voici la liste des livres ");
		Lister_livre();
		Scanner sc=new Scanner(System.in);
		System.out.println("entrer titre de livre  a supprimer ");
		String titre=sc.nextLine();
		L.setTitre(titre);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
			String user="root";
			String password="";
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			String requet4="DELETE FROM livre where titre='"+L.getTitre()+"'";
			int n3=st.executeUpdate(requet4);
			System.out.println("\t suppression avec succees.");
           
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
		public static void modifier_livre(Livre L) {
			try{
				Scanner input=new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn =DriverManager.getConnection(url,user,password);
				System.out.println("\t voici liste des livres: ");
				Lister_livre();
				System.out.println("\t choisir le livre a modifier: ");
				String titret=input.nextLine();
				L.setTitre(titret);
				System.out.println("\t Que voulez vous modifier de ce livre: ");
		        
		            System.out.println("\t 0) annuler");
		            System.out.println("\t 1) titre:");
		            System.out.println("\t 2) numero_edition:");
		            System.out.println("\t 3) date_apparition:");
		            System.out.println("\t 4) stock:");
		            
		            String choix = input.nextLine();
		            switch (choix){
	                case "0": return;
	                case "1":
	                	Scanner in=new Scanner(System.in);
	                    System.out.println("\t Entrer new titre");
	                    String newtitre=in.nextLine();
	                		String req ="UPDATE livre SET titre='"+newtitre+"' WHERE titre='"+L.getTitre()+"' ";
	                		Statement st=conn.createStatement();
	                		int nbre=st.executeUpdate(req);
	                case "2":
	                    System.out.println("\t Entrer new numero_edition");
	                    String newnumero=input.nextLine();
	                		String reqnom ="UPDATE livre SET numero_edition='"+newnumero+"' WHERE titre='"+L.getTitre()+"' ";
	                		Statement stnom=conn.createStatement();
	                		//ResultSet rs= st.executeUpdate(req);
	                		int nbrenom=stnom.executeUpdate(reqnom);
	                case "3":
	                    System.out.println("\t Entrer new date_apparition");
	                    String newdate=input.nextLine();
	                		String reqprenom ="UPDATE livre SET date_apparition='"+newdate+"' WHERE titre='"+L.getTitre()+"' ";
	                		Statement stprenom=conn.createStatement();
	                		int nbreprenom=stprenom.executeUpdate(reqprenom);break;
	                case "4":
	                    System.out.println("\t Entrer new stock");
	                    String newstock=input.nextLine();
	                		String reqstock ="UPDATE livre SET stock='"+newstock+"' WHERE titre='"+L.getTitre()+"' ";
	                		Statement ststock=conn.createStatement();
	                		int nbrstock=ststock.executeUpdate(reqstock);
	                    System.out.println("\t Modification avec succees.");
	                    break;	            
		            }		
		}catch(ClassNotFoundException e1) {
		e1.printStackTrace();
		}catch(SQLException e1) {
		e1.printStackTrace();
		}
			
		}
		public static void ajouter_livre(Livre L) {
			Scanner sc=new Scanner(System.in);
			System.out.println("entrer le titre de livre ");
			String titre=sc.nextLine();
			System.out.println("entrer le numero_edition ");
			int numero_edition=sc.nextInt();
			sc.nextLine();
			System.out.println("entrer date_apparition du livre ");
			String date_apparition=sc.nextLine();
			System.out.println("entrer le stock ");
			int stock=sc.nextInt();
			sc.nextLine();
			L.setTitre(titre);
			L.setNumero_edition(numero_edition);
			L.setDate_apparition(date_apparition);
			L.setStock(stock); 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn=DriverManager.getConnection(url,user,password);
				Statement st=conn.createStatement();
				String requet2="INSERT INTO livre(titre,numero_edition,date_apparition,stock) VALUES('"+L.getTitre()+"','"
				+L.getNumero_edition()+"','"+L.getDate_apparition()+"','"+L.getStock()+"');";
				int n1=st.executeUpdate(requet2);
				System.out.println("\t ajouter avec succees.");
               
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	/*	public static Etudiant[] Liste_etudiant() throws ClassNotFoundException, SQLException {
			
			
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
				
				String titre=rs.getString("titre");
				String numero_edition=rs.getString("numero_edition");
				String date_apparition=rs.getString("date_apparition");
				String stock=rs.getString("stock");
				//System.out.print(cin+" ,"+nom+","+prenom+","+filiere+"\n");
				//tab[i++]=new Livre(titre,numero_edition,date_apparition,stock);
				//for(i=0;i<4;i++) {
					System.out.println(tab[i]);
				
			
				}
	
			return tab;*/
public static void alimenter_stock(Livre L) {
			Scanner sc=new Scanner(System.in);
			System.out.println("voici notre livre");
			Lister_livre();
			try {
				System.out.println("entrer le titre de livre ");
				String titre1=sc.nextLine();
				L.setTitre(titre1);
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
				String user="root";
				String password="";
				Connection conn=DriverManager.getConnection(url,user,password);
				Statement stt=conn.createStatement();
					//String titre=rs.getString("titre");
				String requete ="SELECT stock FROM livre WHERE titre='"+L.getTitre()+"'";
				//WHERE titre.equals(titre1)
				Statement stt1=conn.createStatement();
				ResultSet rrs= stt1.executeQuery(requete);
		        
				if(L.getStock()>30) {
					System.out.println("\t le livre est disponible");	
						
				}
				else {
					System.out.println("\t n'est pas dispo");
				}
				//System.out.println("\t ajouter avec succees.");
               
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	public static void alimenter_stock() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
			String user="root";
			String password="";
			Lister_livre();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter numero_edition du livre a consulter ");
			int numero_edition=sc.nextInt();
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			String requet2="SELECT  stock from livre where numero_edition='"+numero_edition+"'";
			ResultSet n1=st.executeQuery(requet2);
			while(n1.next())
			{
				
				System.out.println(n1.getInt("stock"));
			}
          
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
}
			
