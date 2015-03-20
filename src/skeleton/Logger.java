package skeleton;
import java.util.HashMap;
import java.util.Map;

public class Logger {

	private static Map<Object, String> names = new HashMap<Object, String>();
	private static final int tab = 10;		// Egy fuggvenyhivas ennyi behuzas
	private static int behuzas = 0;
	private static boolean enabled = true;	// Engedélyezve van-e?

	/**
	 * Engedélyezi/letiltja a kiírást és a hozzá tartozó funkciókat
	 * @param value ha true, engedélyezi, ha false, letiltja
	 */
	public static void setEnabled( boolean value ){
		enabled = value;		
	}
	
	/**
	 * Megadja az objektumhoz tartozó nevet, amit kiíratunk
	 * Ha nincs még neve, gyárt egyet OsztálynévSorszám
	 * mintára
	 *
	 * @param obj  Az objektum, amelynek ismerni szeretnénk a nevét
	 */
	public static String resolveName( Object obj ){
		if( obj == null )
			return "null";
		
		String name = names.get(obj);
		
		for( int i = 0 ; name == null ; i++ ){
			String next = obj.getClass().getSimpleName().toLowerCase() + i;
			if( !names.containsValue(next) )
				name = next;
			else
				name = null;	// menjen tovább a keresés
		}
		names.put( obj, name );
		return name;
		
	}
	/**
	 * Beállítja egy objektum nevét
	 *
	 * @param o  Az objektum, amelynek beállítjuk a nevét
	 * @param name  Az objektum új neve
	 * @param owner Tulajdonos objektum(Ha van)
	 */
	public static void setName( Object o, String name, Object owner ){
		if( !enabled )
			return;
		if( owner == null )
			names.put(o, name);
		else
			names.put(o, resolveName(owner)+"."+name);
	}

	/**
	 * Kiírja a behúzásnak megfelelõ számú space-et
	 * 
	 */
	private static void printTab(){
		for( int i = 0 ; i < behuzas ; i++ )	
			System.out.print(" ");
	}
	/**
	 * Egy tabnyi jobbra nyilat rajzol
	 * 
	 */
	private static void printArrowRight(){
		for( int i = 0 ; i < tab-1 ; i++ )	
			System.out.print("-");
		System.out.print(">");
	}
	/**
	 * Egy tabnyi balra nyilat rajzol
	 * 
	 */
	private static void printArrowLeft(){
		System.out.print("<");
		for( int i = 0 ; i < tab+3 ; i++ )	
			System.out.print("-");
	}
	
	/**
	 * Növeli a behúzást és kiíratja a hívó metódus meghívását stacktrace alapján
	 *
	 * @param obj hívó metódus this objektuma
	 * @param arguments argumentumlista, string esetén érték, objektum esetén név íródik ki
	 */
	public static void printCall( Object obj, Object... arguments ){
		if( !enabled )
			return;
		printTab();
		printArrowRight();
		behuzas += tab;
		StackTraceElement call = Thread.currentThread().getStackTrace()[2];
		
		System.out.print( resolveName(obj) + "."+call.getMethodName()+"(");
		for( int i = 0 ; i < arguments.length; i++ )
		{
			if( i>0 )
				System.out.print(", ");
			Object param = arguments[i];
			
			if( param instanceof String )
				System.out.print( (String)param );
			else
				System.out.print( resolveName(param) );
			
		}
		
		System.out.println(")");
		
	}
	
	/**
	 * Kiíratja a megadott sztringet az adott behúzás mellett
	 * @param str Kiírandó sztring
	 *
	 */
	public static void print(String str){
		if( !enabled )
			return;
		printTab();
		System.out.println(str);
	}
	/**
	 * Jelöli a metódushívás végét és csökkenti a behúzást
	 *
	 * 
	 */
	public static void printCallEnd(){
		if( !enabled )
			return;
		behuzas -= tab;
		printTab();
		printArrowLeft();	
		System.out.println();
	}
	
	
}
