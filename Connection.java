package labo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class Connection{
	
	private static final String SOCKET_HOST = "localhost";
	private static final int SOCKET_PORT = 10000;
	
	Socket client;					// Socket pour lire et écrire sur ServeurForme
	PrintWriter out;				// Pour écrire au Socket client
	BufferedReader in;				// Pour lire le Socket client
	
	String ligne;					// ligne lue du serveur 

	public void etablirConnection() throws UnknownHostException, IOException
	{
		// Ouvrir le Socket et établir la connexion avec le serveur ServeurForme
		client = new Socket (SOCKET_HOST, SOCKET_PORT);
		// Établir un BufferedReader sur le Socket client
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		// Établir un PrintWriter sur le Socket client
		out = new PrintWriter(client.getOutputStream(), true);
	}
	public String request() throws UnknownHostException, IOException
	{
		// Passer la ligne "commande>"		
		in.readLine();
		// Envoyer la commande "GET" au serveur
		out.println("GET");
		// Récuperer la chaine de caractére et l'afficher à l'écran
		ligne = in.readLine();
		// Indiquer au serveur ServeurForme que la session est finie
		out.println("END");
		return ligne;
		
	}
	public void close() throws UnknownHostException, IOException{
		// Fermer le Socket
		client.close();
	}
}
