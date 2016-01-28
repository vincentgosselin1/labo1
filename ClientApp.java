package labo1;

import java.io.IOException;
import java.net.UnknownHostException;

import ca.etsmtl.log.util.IDLogger;

public class ClientApp {
	public int ID;//Pour IDLogger
	public String[] forme_a_dessiner = new String[5];// (String)Rectange ; (int)p1 ; (int)p2 ; (int)p3 ; (int)p4.
	Connection C1;//Seulement 1 connection par Client
	Affichage A1;//Seulement 1 affichage par Client
	
	ClientApp(){
		C1 = new Connection();//Cree la connection client/serveur.
		A1 = new Affichage();//Cree la fenetre pour l'affichage.
	}
	
	private void Decode(String reponse_serveur)
	{
		//On enleve les < > et on s'epare le string en plusieurs strings pour un array.
		String temp[] = reponse_serveur.replaceFirst("<"," ").replaceFirst(">"," ").split("\\s+");
		//On enleve le ID.
		ID = Integer.parseInt(temp[0]);
		//On copie le restant du string dans forme_a_dessiner.
		for(int i=1;i<6;i++)//seulement les infos de 1 a 5 nous sont utiles soit le NOM, p1,p2,p3,p4.
		{
			forme_a_dessiner[i-1]=temp[i];
		}
	}
	
	public void Print(String[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
	}
	
	public static void main (String[] args) throws UnknownHostException, IOException{
		//IDLogger I1 = IDLogger.getInstance();
		ClientApp App = new ClientApp();
		App.C1.etablirConnection();
		App.Decode(App.C1.request());
		App.C1.close();
		//I1.logID(App.ID);
		App.Print(App.forme_a_dessiner);
	}
}
