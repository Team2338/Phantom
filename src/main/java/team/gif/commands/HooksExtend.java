package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class HooksExtend extends Command {
	
	public HooksExtend() {
		requires(Robot.hooks);
	}
	
	protected void initialize() {
		Robot.hooks.extend();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
