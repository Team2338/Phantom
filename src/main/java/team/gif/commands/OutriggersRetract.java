package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Outriggers;

/**
 * @author Patrick Ubelhor
 */
public class OutriggersRetract extends Command {
	
	private final Outriggers outriggers;
	
	public OutriggersRetract() {
		this.outriggers = Outriggers.getInstance();
		requires(outriggers);
	}
	
	protected void initialize() {
		outriggers.raise();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
