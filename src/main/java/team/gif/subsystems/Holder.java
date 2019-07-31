package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.HolderClose;

/**
 * @author Patrick Ubelhor
 */
public class Holder extends Subsystem {
	
	private static Holder instance;
	
	public static Holder getInstance() {
		if (instance == null)
			instance = new Holder();
		
		return instance;
	}
	
	private static Solenoid canHolderA = new Solenoid(0, RobotMap.HOLDER_A);
	private static Solenoid canHolderB = new Solenoid(1, RobotMap.HOLDER_B);
	
	private Holder() {}
	
	public void open() {
		canHolderB.set(false);
		canHolderA.set(true);
	}
	
	public void close() {
		canHolderA.set(false);
		canHolderB.set(true);
	}
	
	// TODO: Why is this the default? Would this not cause a dry fire?
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new HolderClose());
	}
	
}
