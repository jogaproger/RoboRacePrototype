

package modell.visitors;

import modell.jatekobj.AbstractRobot;
import modell.jatekobj.Blokk;
import modell.jatekobj.Folt;
/**
 * JatekObj-hoz tartozo visitor, amely fotipustol fuggoen viselkedik
 * @param r Latogatott abstract robot
 */
public interface JOVisitor {
	/**
	 * AbstractRobot vizitalasa
	 * @param r Latogatando abstract robot
	 */
	public void visitAbstractRobot( AbstractRobot r );
	/**
	 * Folt vizitalasa
	 * @param f Latogatando folt
	 */
	public void visitFolt( Folt f );
	/**
	 * Blokk vizitalasa
	 * @param b Latogatando blokk
	 */
	public void visitBlokk( Blokk b );
	
}
