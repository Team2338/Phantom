package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;

/**
 * @author Patrick Ubelhor
 */
public class Outriggers extends Subsystem {
	
	private static final Solenoid outriggersA = new Solenoid(1, RobotMap.OUTRIGGERS_A);
	private static final Solenoid outriggersB = new Solenoid(0, RobotMap.OUTRIGGERS_B);
	
	public void lower() {
		outriggersB.set(false);
		outriggersA.set(true);
	}
	
	public void raise() {
		outriggersA.set(false);
		outriggersB.set(true);
	}
	
	@Override
	public void initDefaultCommand() {}
	
}
