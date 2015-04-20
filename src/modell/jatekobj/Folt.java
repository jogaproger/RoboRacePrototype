package modell.jatekobj;

import main.Main;
import modell.visitors.JOVisitor;

public abstract class Folt extends JatekObj {
	
	/** A folt "elete", szazalekban */
	protected double elet = 100;
	
	/** Ennyi idobe telik feltakaritani a foltot */
	protected double takaritidoSec = 2;
	
	protected void kill(){
		if( cella != null )
			cella.remove(this);
		cella = null;
	}
	
	public final void takarit() {
		
		double dt = 1.0 / Main.getTicksPerSecond();
		double takaritSebesseg = 100/takaritidoSec;
		elet -= dt * takaritSebesseg;
		if( elet < 0.0 ){
			elet = 0.0;
			kill();
		}
	}
	
	@Override
	public void accept( JOVisitor visitor ){
		visitor.visitFolt(this);
	}
	
	public final void info(){
		System.out.println( 
				getClass().getSimpleName() + " "+ (int)(elet)+ "/100" 
				);
		
	}

}
