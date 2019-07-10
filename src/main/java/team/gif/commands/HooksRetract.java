package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class HooksRetract extends Command {
	
	public HooksRetract() {
		requires(Robot.hooks);
	}
	
	protected void initialize() {
		Robot.hooks.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
