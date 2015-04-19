package modell.palya;

public class Sebesseg {

    int fel;
    int jobbra;
    
    public Sebesseg(int f, int j){
    	fel = f;
    	jobbra = j;
    }
    
    public Sebesseg(){
    	fel = jobbra = 0;    	
    }
    
    public static Sebesseg Sum( Sebesseg a, Sebesseg b ){
		return new Sebesseg( a.fel+b.fel, a.jobbra+b.jobbra );}

     /**
     *  Sebesseg nagysaganak lekerdezese
     * 
     * @return 
     */
    public double getNagysag() {
        return Math.sqrt(fel*fel+jobbra*jobbra); 
    }
        
    /**
    *  Irany modositasa 
    * 
    */
    public void modosit(Irany i) {
    	switch(i){
		case Balra:jobbra--;
			break;
		case BalraFel:jobbra--;fel++;
			break;
		case BalraLe:jobbra--;fel--;
			break;
		case Fel:fel++;
			break;
		case Jobbra:jobbra++;
			break;
		case JobbraFel:jobbra++;fel++;
			break;
		case JobbraLe:jobbra++;fel--;
			break;
		case Le:fel--;
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
        return fel == 0 && jobbra == 0;
    }
    /**
    *  Sebesseg felezese
    * 
    */
    public void felez() {
    	fel/=2;
    	jobbra/=2;
    }
    /**
    *  Sebesseg nullara allitasa
    * 
    */
    public void setNulla() {
    	jobbra = fel = 0;
    }

	@Override
	public String toString() {
		return "[" + fel + "," + jobbra + "]";
	}    
    
    

}
