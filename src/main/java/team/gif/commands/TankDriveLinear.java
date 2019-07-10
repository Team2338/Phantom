package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.OI;
import team.gif.Robot;

/**
 * @author PatrickUbelhor
 */
public class TankDriveLinear extends Command {
	
	private final double dBand;
	
	public TankDriveLinear(double deadband) {
		requires(Robot.chassis);
		dBand = deadband;
	}
	
	protected void initialize() {
		Robot.chassis.enableManualControl();
	}
	
	protected void execute() {
		if (Math.abs(OI.leftStick.getY()) > dBand) {
			Robot.chassis.driveLeft(OI.leftStick.getY());
		} else {
			Robot.chassis.driveLeft(0);
		}
		
		if (Math.abs(OI.rightStick.getY()) > dBand) {
			Robot.chassis.driveRight(OI.rightStick.getY());
		} else {
			Robot.chassis.driveRight(0);
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
