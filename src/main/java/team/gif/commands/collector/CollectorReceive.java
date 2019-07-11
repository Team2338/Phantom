package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.CollectorMotors;

/**
 * @author Patrick Ubelhor
 */
public class CollectorReceive extends Command {
	
	public CollectorReceive() {
		requires(Robot.collectorMotors);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Robot.collectorMotors.drive(CollectorMotors.Direction.IN);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
