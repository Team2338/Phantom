package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Chopsticks;

/**
 * @author Patrick Ubelhor
 */
public class ChopsticksClose extends Command {
	
	private final Chopsticks chopsticks;
	
	public ChopsticksClose() {
		this.chopsticks = Chopsticks.getInstance();
		requires(chopsticks);
	}
	
	protected void initialize() {
		chopsticks.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
