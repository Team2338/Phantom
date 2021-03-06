package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;

/**
 * @author Patrick Ubelhor
 */
public class Hooks extends Subsystem {
	
	private static Hooks instance;
	
	public static Hooks getInstance() {
		if (instance == null)
			instance = new Hooks();
		
		return instance;
	}
	
	private final Solenoid leftHookA = new Solenoid(0, RobotMap.HOOKS_A);
	private final Solenoid leftHookB = new Solenoid(1, RobotMap.HOOKS_B);
	
	private Hooks() {}
	
	public void extend() {
		leftHookB.set(false);
		leftHookA.set(true);
	}
	
	public void retract() {
		leftHookA.set(false);
		leftHookB.set(true);
	}
	
	@Override
	public void initDefaultCommand() {}
	
}
