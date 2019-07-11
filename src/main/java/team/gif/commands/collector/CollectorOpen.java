package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class CollectorOpen extends Command {
	
	public CollectorOpen() {
		requires(Robot.collectorPneumo);
	}
	
	protected void initialize() {
		Robot.collectorPneumo.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
