package labo1;

public class CreateurForme {
	
	public Forme nouvelleForme(String s[]){
		
		Forme F1 = null;	
		
		switch(s[0])
		{
		case "CARRE":	F1 = new Carre(s[1],s[2],s[3],s[4]); 			break;
		case "RECTANGLE" : F1 = new Rectangle(s[1],s[2],s[3],s[4]); 	break;
		case "CERCLE" : F1 = new Cercle(s[1],s[2],s[3],"-1");			break;
		case "OVALE" : F1 = new Ovale(s[1],s[2],s[3],s[4]);				break;
		case "LIGNE" : F1 = new Ligne(s[1],s[2],s[3],s[4]);				break;
		default : System.out.println("heyy");							break;
		}
		return F1;
	}
	public static void main (String[] args){
		CreateurForme F1 = new CreateurForme();
		String[] a = new String[5];
		a[0]="CERCLE";
		a[1]="154";
		a[2]="154";
		a[3]="198";
		a[4]="/CERCLE";
		F1.nouvelleForme(a).sayHi();
	}
}
