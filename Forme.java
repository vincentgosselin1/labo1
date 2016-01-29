package labo1;

public abstract class Forme {
	private int p1,p2,p3,p4;
	
	Forme(String s1,String s2,String s3,String s4)
	{
		p1 = Integer.parseInt(s1);//Parametre 1.
		p2 = Integer.parseInt(s2);//Parametre 2.
		p3 = Integer.parseInt(s3);//Parametre 3.
		p4 = Integer.parseInt(s4);//Parametre 4.
	}
	public void sayHi()
	{
		System.out.println("I am Alive!");
		System.out.println("And my dimensions are " + p1+ " " + p2 + " "+ p3 + " " + p4 + " ");
	}
}
