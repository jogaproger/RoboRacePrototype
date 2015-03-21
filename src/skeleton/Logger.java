package skeleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Logger {

	private static Map<Object, String> names = new HashMap<Object, String>();
	private static final int tab = 15;		// Egy fuggvenyhivas ennyi behuzas
	private static int behuzas = 0;
	private static boolean enabled = true;	// Engedélyezve van-e?
	private static int maxDepth = 100;
	public static int depth = 0;

	
	
	/**
	 * Kiírás mélységének meghatározása, mennyire menjünk bele alsó szintû
	 * függvényhívásokba
	 * @depth Ennyi db függvényhívás mélyre megyünk
	 */	
	public static void setMaxDepth(int depth){
		maxDepth = depth;
	}
	
	/**
	 * Névtár elengedése, mert a) nem használjuk a neveket
	 * b) Nem akarjuk hogy a névtár miatt a használatlan objektumok
	 * ne szabaduljanak fel
	 */
	public static void releaseNames(){
		names = new HashMap<Object, String>();
	}
	
	
	/**
	 * Engedélyezi/letiltja a kiírást és a hozzá tartozó funkciókat
	 * 
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
		
		// Ha name==null, nekünk kell nevet alkotnunk
		for( int i = 0 ; name == null ; i++ ){
			String next = obj.getClass().getSimpleName().toLowerCase();
			// Ha i>0, akkor sorszámot kap az objektum
			if( i>0 )
				next = next+i;
			// Ha szabad a név, használjuk, egyébként keresünk tovább
			if( !names.containsValue(next) )
				name = next;
			else
				name = null;	// menjen tovább a keresés
		}
		
		// Ha még nem tettük bele a nevet, most beletesszük
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
	 * Kiírja a szöveget, ha engedélyezett a loggolás
	 * 
	 */
	private static void print(String param){
		if( !enabled || maxDepth<depth )
			return;
			
		System.out.print(param);
	}
	/**
	 * Kiírja a szöveget sortöréssel, ha engedélyezett a loggolás
	 * 
	 */
	private static void println(String param){
		if( !enabled || maxDepth<depth )
			return;
			
		System.out.println(param);
	}
	/**
	 * Kérdést tesz fel a felhasználónak
	 * 
	 * @param question Feltett kérdés
	 * @param answers Választási lehetõségek
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
	 * Növeli a behúzást és kiíratja a hívó metódus meghívását stacktrace alapján
	 *
	 * @param obj hívó metódus this objektuma
	 * @param arguments argumentumlista, string esetén érték, objektum esetén név íródik ki
	 */
	public static void printCall( Object obj, Object... arguments ){
		depth++;
		// Lekérjük a StackTrace-bõl a 2vel fentebbi metódushívást
		StackTraceElement call = Thread.currentThread().getStackTrace()[2];
		
		String methodName = call.getMethodName();
		// Konstruktorokat nem <init>, hanem Osztálynév(..) módon jelenítjük meg
		// Valamint feléírjuk a <<create>> szignatúrát
		if( methodName.equals("<init>") ){
			methodName = obj.getClass().getSimpleName();
			printTab();
			println("  <<create>>");			
		}
		
		printTab();
		printArrowRight();
		behuzas += tab;		
		print( resolveName(obj) + "."+methodName+"(");
		
		// Argumentumokat vesszõvel elválasztva kiírjuk
		for( int i = 0 ; i < arguments.length; i++ )
		{
			// 2. elemtõl fogva vesszõt is írunk elé
			if( i>0 )
				print(", ");	
			Object param = arguments[i];
			
			// Ha a paraméter string, akkor értéket szeretnénk kiíratni
			if( param instanceof String )
				print( (String)param );
			else
				print( resolveName(param) );
			
		}
		
		println(")");
		
	}
	
	/**
	 * Kiíratja a megadott sztringet az adott behúzás mellett
	 * @param str Kiírandó sztring
	 *
	 */
	public static void printMessage(String str){
		printTab();
		println(str);
	}
	/**
	 * Jelöli a metódushívás végét és csökkenti a behúzást
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
