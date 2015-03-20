package skeleton;


public class Skeleton {

	
	public static void main( String[] args )
	{
		try{
			new Skeleton().A();
		}
		catch( Exception e )
		{
			e.printStackTrace();	
		}
	}
	
	void B(){
		Logger.printCall(this, "random string as B's param");
		Logger.printCallEnd();		
	}
	
	void C(){
		Logger.printCall(this);
		
		D(this, 3);
		
		Logger.printCallEnd();		
	}
	
	void D( Skeleton param, int i )
	{
		// Mindig thissel kezdõdik
		// az elsõ paraméter egy Skeletonobjektum, aminek neve van ezért simán átadjuk
		// A második egy sima érték, ezt stringgé konvertáljuk és úgy adjuk át
		Logger.printCall(this, param, ""+i );
		
		Logger.print("Egyéb szöveg kiírása D-bõl");
		
		Logger.printCallEnd();
	}
	
	void A(){
		Logger.printCall(this);
		
		B();
		C();
		
		Logger.printCallEnd();		
	}
	
}
