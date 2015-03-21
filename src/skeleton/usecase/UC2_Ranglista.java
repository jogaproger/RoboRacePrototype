package skeleton.usecase;

import modell.Ranglista;
import skeleton.Logger;

public class UC2_Ranglista extends UseCase {

	@Override
	public void execute() {
		Logger.setEnabled(false);
		Ranglista r = new Ranglista();
		
		Logger.setEnabled(true);
		r.megjelenit();
	}

	@Override
	public String getName() {
		return "Ranglista";
	}

}
