package modell.palya;

public class Sebesseg {

    int fel;
    int jobbra;

     /**
     *  Sebesseg nagysaganak lekerdezese
     * 
     * @return 
     */
    public int getNagysag() {
        return 0; 
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

}
