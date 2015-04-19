package modell.jatekobj;

import main.Logger;
import modell.palya.Cella;
import modell.palya.Sebesseg;
import modell.visitors.JOVisitor;


public abstract class AbstractRobot extends JatekObj{

	/**
	 * Robot allapotat leiro belso enumeracio
	 */
	protected enum RobotAllapot{
		HALOTT, ALLO, UGRO		
	};
	/** Robot allapota */
	protected RobotAllapot allapot;
	
	/** Ugras eseten ahonnan elugrunk */
	private Cella forras;
	/** Ugras eseten ahova erkezni fogunk */
	private Cella cel;
	/** mennyi ideje van a robot a levegoben */
	protected int ugrasido;
	
	/** Robot sebessege */
	Sebesseg seb;
	
	public AbstractRobot(){
		seb = new Sebesseg();		
	}
	
	/**
	 * Robot elpusztitasa
	 */
	public void kill(){
		Logger.printCall(this);
		allapot = RobotAllapot.HALOTT;
		Logger.printCallEnd();
	}

	protected void ugrik(Sebesseg seb){
		ugrik( cella.getKov(seb) );
	}

	protected void ugrik(Cella celcella){
		cella.remove(this);
		forras = cella;
		cel = celcella;
		allapot = RobotAllapot.UGRO;	
	}
	
	/**
	 * Robot pillanatnyi mukodesenek vegrehajtasa
	 */
	public void simulate(){
		Logger.printCall(this);
		switch( allapot ){
		case ALLO:
			if( !seb.isNulla() )
				ugrik(seb);
			break;
		case HALOTT:
			break;
		case UGRO:
				ugrasido++;
			break;
		default:
			break;		
		
		}
		if( !seb.isNulla )
		Logger.printCallEnd();
	}
	
	/**
	 * Akkor hivodik meg, amikor az abstract robot leer a cellara
	 * @param c Celcella
	 */
	protected abstract void onErkezes( Cella c );
	
	public void accept(JOVisitor visitor){
		visitor.visitAbstractRobot( this );
	}
	
}
