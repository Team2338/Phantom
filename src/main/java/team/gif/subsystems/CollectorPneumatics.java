package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;

/**
 * @author Patrick Ubelhor
 */
public class CollectorPneumatics extends Subsystem {
	
	// A extends, B retracts
	private static final Solenoid collectorA = new Solenoid(0, RobotMap.COLLECTOR_A);
	private static final Solenoid collectorB = new Solenoid(1, RobotMap.COLLECTOR_B);
	
	public void close() {
		collectorA.set(false);
		collectorB.set(true);
	}
	
	public void open() {
		collectorB.set(false);
		collectorA.set(true);
	}
	
	@Override
	public void initDefaultCommand() {}
	
}
