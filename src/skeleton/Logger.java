package skeleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Logger {

	private static Map<Object, String> names = new HashMap<Object, String>();
	private static final int tab = 10;		// Egy fuggvenyhivas ennyi behuzas
	private static int behuzas = 0;
	private static boolean enabled = true;	// Engedelyezve van-e?
	private static int maxDepth = 100;
	public static int depth = 0;

	
	
	/**
	 * Kiiras melysegenek meghatarozasa, mennyire menjunk bele also szintu
	 * fuggvenyhivasokba
	 * @depth Ennyi db fuggvenyhivas melyre megyunk
	 */	
	public static void setMaxDepth(int depth){
		maxDepth = depth;
	}
	
	/**
	 * Nevtar elengedese, mert a) nem hasznaljuk a neveket
	 * b) Nem akarjuk hogy a nevtar miatt a hasznalatlan objektumok
	 * ne szabaduljanak fel
	 */
	public static void releaseNames(){
		names = new HashMap<Object, String>();
	}
	
	
	/**
	 * Engedelyezi/letiltja a kiirast es a hozza tartozo funkciokat
	 * 
	 * @param value ha true, engedelyezi, ha false, letiltja
	 */
	public static void setEnabled( boolean value ){
		enabled = value;		
	}
	
	/**
	 * Megadja az objektumhoz tartozo nevet, amit kiiratunk
	 * Ha nincs meg neve, gyart egyet OsztalynevSorszam
	 * mintara
	 *
	 * @param obj  Az objektum, amelynek ismerni szeretnenk a nevet
	 */
	public static String resolveName( Object obj ){
		if( obj == null )
			return "null";
		
		String name = names.get(obj);
		
		// Ha name==null, nekunk kell nevet alkotnunk
		for( int i = 1 ; name == null ; i++ ){
			String next = obj.getClass().getSimpleName().toLowerCase();
			// Ha i>1, akkor sorszamot kap az objektum
			if( i>1 )
				next = next+i;
			// Ha szabad a nev, hasznaljuk, egyebkent keresunk tovabb
			if( !names.containsValue(next) )
				name = next;
			else
				name = null;	// menjen tovabb a kereses
		}
		
		// Ha meg nem tettuk bele a nevet, most beletesszuk
		names.put( obj, name );
		return name;
		
	}
	/**
	 * Beallitja egy objektum nevet és ha van valami tulajdonosa 
	 * akkor beveszi a nevebe
	 *
	 * @param o  Az objektum, amelynek beallitjuk a nevet
	 * @param name  Az objektum uj neve
	 * @param owner Tulajdonos objektum(Ha van)
	 */
	public static void setName( Object o, String name, Object owner ){
		if( owner == null )
			names.put(o, name);
		else
			names.put(o, resolveName(owner)+"."+name);
	}

	/**
	 * Kiirja a behuzasnak megfelelo szamu space-et
	 * 
	 */
	private static void printTab(){
		if( !enabled || maxDepth<depth )
			return;
			
		for( int i = 0 ; i < behuzas ; i++ )	
			System.out.print(" ");
	}
	/**
	 * Egy tabnyi jobbra nyilat rajzol
	 * 
	 */
	private static void printArrowRight(){
		if( !enabled || maxDepth<depth )
			return;
			
		for( int i = 0 ; i < tab-1 ; i++ )	
			System.out.print("-");
		System.out.print(">");
	}
	/**
	 * Egy tabnyi balra nyilat rajzol
	 * 
	 */
	private static void printArrowLeft(){
		if( !enabled || maxDepth<depth )
			return;
			
		System.out.print("<");
		for( int i = 0 ; i < tab+3 ; i++ )	
			System.out.print("-");
	}
	/**
	 * Kiirja a szoveget, ha engedelyezett a loggolas
	 * 
	 */
	private static void print(String param){
		if( !enabled || maxDepth<depth )
			return;
			
		System.out.print(param);
	}
	/**
	 * Kiirja a szoveget sortoressel, ha engedelyezett a loggolas
	 * 
	 */
	private static void println(String param){
		if( !enabled || maxDepth<depth )
			return;
			
		System.out.println(param);
	}
	/**
	 * Kerdest tesz fel a felhasznalonak
	 * 
	 * @param question Feltett kerdes
	 * @param answers Valasztasi lehetosegek
	 * @return
	 */
	public static int askQuestion(String question, String... answers){
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		printMessage(question);
		for( int i = 0 ; i < answers.length ; i++ )
		{
			printMessage(""+(i+1)+"."+answers[i]);
		}
		try{
			printTab();
			int i = Integer.parseInt(br.readLine());
			if( i < 1 || i > answers.length )
			{
				return 0;
			}
			return i;
		}
		catch(Exception e){
		}
		return 0;
	}
	
	/**
	 * Noveli a behuzast es kiiratja a hivo metodus meghivasat stacktrace alapjan
	 *
	 * @param obj hivo metodus this objektuma
	 * @param arguments argumentumlista, string eseten ertek, objektum eseten nev irodik ki
	 */
	public static void printCall( Object obj, Object... arguments ){
		depth++;
		// Lekerjuk a StackTrace-bol a 2vel fentebbi metodushivast
		StackTraceElement call = Thread.currentThread().getStackTrace()[2];
		
		String methodName = call.getMethodName();
		// Konstruktorokat nem <init>, hanem Osztalynev(..) modon jelenitjuk meg
		// Valamint feleirjuk a <<create>> szignaturat
		if( methodName.equals("<init>") ){
			methodName = obj.getClass().getSimpleName();
			printTab();
			println("  <<create>>");			
		}
		
		printTab();
		printArrowRight();
		behuzas += tab;		
		print( resolveName(obj) + "."+methodName+"(");
		
		// Argumentumokat vesszovel elvalasztva kiirjuk
		for( int i = 0 ; i < arguments.length; i++ )
		{
			// 2. elemtol fogva vesszot is irunk ele
			if( i>0 )
				print(", ");	
			Object param = arguments[i];
			
			// Ha a parameter string, akkor erteket szeretnenk kiiratni
			if( param instanceof String )
				print( (String)param );
			else
				print( resolveName(param) );
			
		}
		
		println(")");
		
	}
	
	/**
	 * Kiiratja a megadott sztringet az adott behuzas mellett
	 * @param str Kiirando sztring
	 *
	 */
	public static void printMessage(String str){
		printTab();
		println(str);
	}
	/**
	 * Jeloli a metodushivas veget es csokkenti a behuzast
	 *
	 */
	public static void printCallEnd(){
		behuzas -= tab;
		printTab();
		printArrowLeft();	
		println("");
		depth--;
	}
	
	
}
