package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Outriggers;

/**
 * @author Patrick Ubelhor
 */
public class OutriggersExtend extends Command {
	
	private final Outriggers outriggers;
	
	public OutriggersExtend() {
		this.outriggers = Outriggers.getInstance();
		requires(outriggers);
	}
	
	protected void initialize() {
		outriggers.lower();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
