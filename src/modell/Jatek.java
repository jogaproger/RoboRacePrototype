package modell;


public class Jatek {
	private static Jatek instance = null;
	
	void ujJatek( String palya, int jatekosnum ){
		Logger.printCall(this, palya, ""+jatekosnum);
		
		Logger.printCallEnd();
	}
	
}
