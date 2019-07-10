package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
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
