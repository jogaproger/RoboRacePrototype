package modell.palya;

import java.util.List;
import java.util.ArrayList;

public class Sebesseg {

    int x, y;
    
    public Sebesseg(int x, int y){
    	this.y = y;
    	this.x = x;
    }
    
    public Sebesseg(){
    	y = x = 0;    	
    }
    
    public static Sebesseg Sum( Sebesseg a, Sebesseg b ){
		return new Sebesseg( a.x+b.x, a.y+b.y );}

     /**
     *  Sebesseg nagysaganak lekerdezese
     * 
     * @return 
     */
    public double getNagysag() {
        return Math.sqrt(y*y+x*x); 
    }
        
    /**
    *  Irany modositasa 
    * 
    */
    public void modosit(Irany i) {
    	switch(i){
		case Balra:x--;
			break;
		case BalraFel:x--;y--;
			break;
		case BalraLe:x--;y++;
			break;
		case Fel:y--;
			break;
		case Jobbra:x++;
			break;
		case JobbraFel:x++;y--;
			break;
		case JobbraLe:x++;y++;
			break;
		case Le:y++;
			break;
		default:
			break;
    	}
    }
    /**
    *  Nulla-e az aktualis sebesseg?
    * 
    */
    public Boolean isNulla() {
        return y == 0 && x == 0;
    }
    /**
    *  Sebesseg felezese
    * 
    */
    public void felez() {
    	y/=2;
    	x/=2;
    }
    /**
    *  Sebesseg nullara allitasa
    * 
    */
    public void setNulla() {
    	x = y = 0;
    }

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	public List<Irany> iranySet() {
		ArrayList<Irany> ret = new ArrayList<Irany>();
		
		int a = x;
		int b = y;
		
		while( a > 0 ){
			a--;ret.add(Irany.Jobbra);
		}		
		while( a < 0 ){
			a++;ret.add(Irany.Balra);
		}
		
		while( b > 0 ){
			b--;ret.add(Irany.Le);
		}		
		while( b < 0 ){
			b++;ret.add(Irany.Fel);
		}
		
		return ret;
	}    
    
    

}
