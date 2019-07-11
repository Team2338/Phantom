package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class CollectorClose extends Command {
	
	public CollectorClose() {
		requires(Robot.collectorPneumo);
	}
	
	protected void initialize() {
		Robot.collectorPneumo.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
