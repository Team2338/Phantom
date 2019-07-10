package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author PatrickUbelhor
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
