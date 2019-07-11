package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;

/**
 * @author Patrick Ubelhor
 */
public class Chopsticks extends Subsystem {
	
	private static final Solenoid chopsticksA = new Solenoid(0, RobotMap.CHOPSTICKS_A);
	private static final Solenoid chopsticksB = new Solenoid(1, RobotMap.CHOPSTICKS_B);
	
	public void open() {
		chopsticksA.set(false);
		chopsticksB.set(true);
	}
	
	public void close() {
		chopsticksB.set(false);
		chopsticksA.set(true);
	}
	
	@Override
	public void initDefaultCommand() {}
	
}
