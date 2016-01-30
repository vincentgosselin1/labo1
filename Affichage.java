package labo1;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Affichage extends JFrame{
	
	private MyCanvas canvas = new MyCanvas();
	private Forme f = null;//Prochaine Forme a dessiner!
	
	private Forme t[] = new Forme[10];//Tableau de 10 formes.
	private int i = 0;//Index pour fill le tableau de formes.
	
	
	//Couleur Aleatoire!
	Random nbAleatoire = new Random();
	Color laCouleur=null; 
	
	public static void main (String[] args)
	{
		Affichage A1 = new Affichage();
		Forme F1 = new Carre("","50","50","100","200");
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
		t[i] = F1;//Fill le tableau de formes.
		f = t[i];
		canvas.repaint();//On dessine les formes dans le tableau.
		i++;
	}
	
	private class MyCanvas extends Canvas
	{	
		public void update(Graphics g)
		{
				if(f != null)//Si il y a une forme a dessiner.
				{
						switch(f.nom)
						{
						case "CARRE" : g.setColor(Color.BLACK);	g.drawRect(f.p1, f.p2, f.p3, f.p4);	g.fillRect(f.p1, f.p2, f.p3, f.p4);		break;
						case "RECTANGLE" : g.setColor(Color.BLUE);	g.drawRect(f.p1, f.p2, f.p3, f.p4);	g.fillRect(f.p1, f.p2, f.p3, f.p4);	break;
						case "OVALE" : g.setColor(Color.CYAN); g.drawOval(f.p1, f.p2, f.p3, f.p4); g.fillOval(f.p1, f.p2, f.p3, f.p4);		break;
						case "CERCLE" : g.setColor(Color.GREEN); g.drawOval(f.p1, f.p2, f.p3, f.p3); g.fillOval(f.p1, f.p2, f.p3, f.p3);		break;
						case "LIGNE" : g.setColor(Color.RED); g.drawLine(f.p1, f.p2, f.p3, f.p4);	break;
						}
				}
					
		}
	}
}


