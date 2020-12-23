package exo.planche.Application;

public class Calcul {
	
	public static double calculerNombreDePlanche(double surface) {//méthode
			
			double planche = 0.31;
			double nombrePlanche = surface / planche;
			double marge = (nombrePlanche * 10) / 100;
			
			return marge + nombrePlanche;
			
		}
	

}
