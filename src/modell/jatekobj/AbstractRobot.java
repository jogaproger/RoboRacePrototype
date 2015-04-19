package modell.jatekobj;

import main.Logger;
import main.Main;
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
	protected Cella forras;
	/** Ugras eseten ahova erkezni fogunk */
	protected Cella cel;
	/** mennyi ideje van a robot a levegoben */
	protected int ugrasidoTick;
	
	/** Robot sebessege */
	Sebesseg seb;
	
	/** Robot ugrási ideje */
	double totalUgrasIdoSec = 1;
	
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
		ugrasidoTick = 0;
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
				ugrasidoTick++;
				if( ugrasidoTick > totalUgrasIdoSec * Main.getTicksPerSecond() )
				{
					erkezik( cel );
					allapot = RobotAllapot.ALLO;
				}
				
			break;
		default:
			break;		
		
		}
		Logger.printCallEnd();
	}
	
	/**
	 * Akkor hivodik meg, amikor az abstract robot leer a cellara
	 * @param c Celcella
	 */
	protected abstract void erkezik( Cella c );
	
	/**
	 * Visitor fogadasa
	 */
	public void accept(JOVisitor visitor){
		visitor.visitAbstractRobot( this );
	}
	
}
