package view;

import java.sql.SQLException;
import java.util.Scanner;

import beans.Etudiant;
import beans.Livre;
import dao.EmpruntDao;
import dao.EtudiantDao;
import dao.LivreDao;


public class Menu{
public static void  Menup() throws ClassNotFoundException, SQLException{
    
	System.out.println("MENU:\n"
			+ "1-	Gérer les livres\r\n"
			+ "2-	Gérer les étudiants\r\n"
			+ "3-	Emprunter un livre\r\n"
			+ "4-	Remettre un livre\r\n"
			+ "5-	Enregistrer les données dans des fichiers CSV.\r\n"
			+ " quel est votre choix:");
	
	Scanner  input =new Scanner(System.in);
	int choix=input.nextInt();
	switch(choix) {
	case 1:
		
		Menu1();
		
		break;
	case 2:
		Menu2();
		break;
	case 3:
		Menu3();
		break;
	case 4:
		Menu4();
		break;
	case 5:
		Menu5();
		break;
	default:
		return;
		
	}
	
}
public static void  Menu1(){
	while(true) {
	System.out.println("1-	Lister les livres\r\n"
			+ "2-	Alimenter le stock d’un livre\r\n"
			+ "3-	Ajouter un livre\r\n"
			+ "4-	Modifier un livre \r\n"
			+ "5-	Supprimer un livre\r\n"
			);
	Scanner  input =new Scanner(System.in);
	int choix=input.nextInt();
	Livre L=new Livre();
	switch(choix) {
	case 1:
		LivreDao.Lister_livre();
		break;
	case 2:
		LivreDao.alimenter_stock();
		break;
	case 3:
		LivreDao.ajouter_livre(L);
		break;
	case 4:
		LivreDao.modifier_livre(L);
		break;
	case 5:
		LivreDao.supprimer_livre(L);
		break;
	default:
			return;
	}
}
	}
public  static void  Menu2() throws ClassNotFoundException, SQLException{
	while(true) {
	System.out.println("1-	Lister les étudiants\r\n"
			+ "2-	Ajouter un étudiant\r\n"
			+ "3-	Modifier un étudiant\r\n"
			+ "4-	Supprimer un étudiant\r\n"
			+ "");
	Scanner  input =new Scanner(System.in);
	int choix=input.nextInt();
	Etudiant E=new Etudiant();
	switch(choix) {
	case 1:
		//EtudiantDao.Lister_etudiant();
		EtudiantDao.Lister_etudiant();
		break;
	case 2:
		EtudiantDao.ajouter_etudiant(E);
		break;
	
	case 3:
		
		EtudiantDao.modifier_etudiant(E);
		break;
	case 4:
		
		EtudiantDao.supprimer_etudiant(E);
		break;
		default:
			return;
	}
}
}
public static void  Menu3() throws ClassNotFoundException, SQLException{	
	EmpruntDao.enregitre_emprunt();
}

public static void  Menu4(){	
	EmpruntDao.menu4();
}
public static void  Menu5(){
	
}

}
