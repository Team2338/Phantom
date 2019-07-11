package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class CollectorStandby extends Command {
	
	public CollectorStandby() {
		requires(Robot.collectorMotors);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Robot.collectorMotors.drive(0.0, 0.0);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}