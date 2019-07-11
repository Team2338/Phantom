package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 */
public class OutriggersRetract extends Command {
	
	public OutriggersRetract() {
		requires(Robot.outriggers);
	}
	
	protected void initialize() {
		Robot.outriggers.raise();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
