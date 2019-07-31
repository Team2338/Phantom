package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Chopsticks;

/**
 * @author Patrick Ubelhor
 */
public class ChopsticksOpen extends Command {
	
	private final Chopsticks chopsticks;
	
	public ChopsticksOpen() {
		this.chopsticks = Chopsticks.getInstance();
		requires(chopsticks);
	}
	
	protected void initialize() {
		chopsticks.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
