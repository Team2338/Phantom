package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author PatrickUbelhor
 */
public class ChopsticksClose extends Command {
	
	public ChopsticksClose() {
		requires(Robot.chopsticks);
	}
	
	protected void initialize() {
		Robot.chopsticks.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
