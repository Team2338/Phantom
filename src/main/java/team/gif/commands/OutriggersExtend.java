package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class OutriggersExtend extends Command {
	
	public OutriggersExtend() {
		requires(Robot.outriggers);
	}
	
	protected void initialize() {
		Robot.outriggers.lower();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
