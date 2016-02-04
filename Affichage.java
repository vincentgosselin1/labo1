
package labo1;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Affichage extends JFrame{
	
	private MyCanvas canvas = new MyCanvas();
	private Forme f = null;//Prochaine Forme a dessiner!
	
	private Forme[] listeFormes = new Forme[10];
	int i =0;
	
	//Couleur Aleatoire!
	Random nbAleatoire = new Random();
	Color laCouleur=null; 
	
	public static void main (String[] args)
	{
		Affichage A1 = new Affichage();
		Forme F1 = new Carre("","50","50","100","200");
		A1.afficherForme(F1);
		F1 = new Carre("","200","200","60","60");
		A1.afficherForme(F1);
	}
	
	public Affichage(){
		setLayout(new BorderLayout());
		setSize(500,500);
		setTitle("Producteur de Forme");
		add("Center",canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Another way to centre the screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void afficherForme(Forme F1)
	{
		 listeFormes[i] = F1;
		 i++;
		 if(i>9)
		 {
			 i=0;
		 }
		 repaint();//On dessine les formes dans le tableau.
	}
	
	private class MyCanvas extends JPanel
	{	
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			for(int y = 0; y<10;y++)
			{
				
				if( listeFormes[y] != null)//Si il y a une forme a dessiner.
				{
					f = listeFormes[y];
						switch(f.nom)
						{
						case "CARRE" : g.setColor(Color.BLACK);	g.drawRect(f.p1, f.p2, f.p3-f.p1, f.p4-f.p2);	g.fillRect(f.p1, f.p2, f.p3-f.p1, f.p4-f.p2);		break;
						case "RECTANGLE" : g.setColor(Color.BLUE);	g.drawRect(f.p1, f.p2, f.p3-f.p1, f.p4-f.p2);	g.fillRect(f.p1, f.p2, f.p3-f.p1, f.p4-f.p2);	break;
						case "OVALE" : g.setColor(Color.CYAN); g.drawOval(f.p1, f.p2, f.p3, f.p4); g.fillOval(f.p1, f.p2, f.p3, f.p4);		break;
						case "CERCLE" : g.setColor(Color.GREEN); g.drawOval(f.p1, f.p2, f.p3, f.p3); g.fillOval(f.p1, f.p2, f.p3, f.p3);		break;
						case "LIGNE" : g.setColor(Color.RED); g.drawLine(f.p1, f.p2, f.p3, f.p4);	break;
						}
				}
					
		}
	}
	}
}
