import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args){
		
		
		ProfilChooser pc = new ProfilChooser();
		String chemin = pc.cheminProfil();
		
		if(chemin==null)
			System.exit(1);
		Profil profil;
		try{
			profil = new Profil(chemin);
			/********* detection du groupe ****/
			StringTokenizer st = new StringTokenizer(chemin,"/");
			String tmp, ancien;
			ancien = null;
			tmp = null;
			while(st.hasMoreElements()){
				ancien = tmp;
				tmp = (String) st.nextToken();
			}
			profil.setGroupe(ancien);
			
			DPartie partie = new DPartie(9,9,10);
		
			DFenetre fenetre = new DFenetre(partie,profil);
		
	
			EcouteurGo e = new EcouteurGo(fenetre,partie);
			fenetre.getGo().addActionListener(e);
		
			EcouteurFenetre ecouteurFenetre = new EcouteurFenetre(fenetre);
			fenetre.addWindowListener(ecouteurFenetre);
		
			EcouteurMenu ecouteurMenu = new EcouteurMenu(fenetre,partie);
			fenetre.ecouterMenu(ecouteurMenu);
		} 
		catch(IOException ioe){ 
			System.out.println("erreur de chargement de profil");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Le profil n'a pas pu etre chargé");
		}
		

		
		
	}
	
	
}