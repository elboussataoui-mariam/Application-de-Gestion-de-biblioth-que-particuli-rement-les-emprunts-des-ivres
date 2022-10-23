package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class EmpruntDao {
	private int NUM;
	private int VALEUR;
	
public int getVALEUR() {
		return VALEUR;
	}

	public void setVALEUR(int vALEUR) {
		VALEUR = vALEUR;
	}

public int getNUM() {
		return NUM;
	}

	public void setNUM(int nUM) {
		NUM = nUM;
	}

public static boolean enregitre_emprunt() {
	
	try {
		LivreDao.Lister_livre();
		System.out.println("entrer le numéro du livre a emprunter");
		Scanner  input =new Scanner(System.in);
		int num1=input.nextInt();
		input.nextLine();
		EtudiantDao.Lister_etudiant();
		System.out.println("entrer le numéro d'étudiant");
		
		String num2=input.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
		String user="root";
		String password="";
		Connection conn=DriverManager.getConnection(url,user,password);
		Statement st=conn.createStatement();
		EmpruntDao ed=new EmpruntDao();
		String requete="select count(numero_edition) from emprunt where numero_edition='"+num1+"' ";
		ResultSet n3=st.executeQuery(requete);
		while(n3.next()) {
			int valeur=n3.getInt(1);
			ed.setVALEUR(valeur);
		}
		String req1="select count(cin) from emprunt where cin='"+num2+"' ";
		ResultSet n2=st.executeQuery(req1);
		
		while(n2.next()) {
			int num=n2.getInt(1);
			ed.setNUM(num);
		}
		
		if(ed.getNUM()<3 && ed.getVALEUR()==0){
			
			String requet2="INSERT INTO emprunt VALUES('"+num1+"','"+num2+"','"+LocalDate.now()+"','"+"not_yet"+"');";
			int n1=st.executeUpdate(requet2);
			String requet4="UPDATE livre set stock=stock-1 WHERE numero_edition='"+num1+"'";
			int n4=st.executeUpdate(requet4);
			
		}	
		
		else 
			System.out.println("pardon ,vous ne pouvez pas emprunter ce livre");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return true;
}
public static void menu4() {
	try {
		
		EtudiantDao.Lister_etudiant();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3309/gestion_bibliothèque";
		String user="root";
		String password="";
		Connection conn=DriverManager.getConnection(url,user,password);
		Statement st=conn.createStatement();
		
		System.out.println("entrer le cin de l'etudiant");
		Scanner sc= new Scanner(System.in);
		 int ID=sc.nextInt();
		String requete=("SELECT numero_edition FROM emprunt WHERE cin ='"+ID+"'");
		ResultSet rs = st.executeQuery(requete);
		while(rs.next()) {
			int id =rs.getInt("numero_edition");
			System.out.println(id);
		}
		
		System.out.println("entrer le numero du livre à remettre");
		 int ID_livre=sc.nextInt();
		 String enreg_remise="okey";
			
		 String requet=("UPDATE emprunt SET remis_le ='"+enreg_remise+"' WHERE numero_edition ='"+ID_livre+"' and cin='"+ID+"'");
			int nbre =st.executeUpdate(requet);
			System.out.println("remise enregistrée!");
			
		
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}

}
	
}


