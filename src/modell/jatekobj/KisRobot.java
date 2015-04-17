package modell.jatekobj;

import modell.palya.Cella;
import modell.visitors.TakaritoVisitor;

public class KisRobot extends AbstractRobot {

	@Override
	protected void onErkezes(Cella c) {		
	}

	@Override
	public void ralep(Robot r) {
		kill();		
	}
	
	@Override
	public void simulate(){
		super.simulate();
		if( allapot==RobotAllapot.ALLO )
			cella.accept( new TakaritoVisitor() );
		
	}

	@Override
	public void info() {
				
	}

}
