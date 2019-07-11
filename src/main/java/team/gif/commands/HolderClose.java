package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class HolderClose extends Command {
	
	public HolderClose() {
		requires(Robot.holder);
	}
	
	protected void initialize() {
		Robot.holder.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
