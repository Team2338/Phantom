package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.OI;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class TankDriveLinear extends Command {
	
	
	public TankDriveLinear() {
		requires(Robot.chassis);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Robot.chassis.setPercentOutput(OI.getLeftY(), OI.getRightY());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
