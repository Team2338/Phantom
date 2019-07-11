package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class HolderOpen extends Command {
	
	public HolderOpen() {
		requires(Robot.holder);
	}
	
	protected void initialize() {
		Robot.holder.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
