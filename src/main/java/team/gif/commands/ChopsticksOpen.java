package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class ChopsticksOpen extends Command {
	
	public ChopsticksOpen() {
		requires(Robot.chopsticks);
	}
	
	protected void initialize() {
		Robot.chopsticks.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
