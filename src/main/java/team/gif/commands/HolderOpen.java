package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Holder;

/**
 * @author Patrick Ubelhor
 */
public class HolderOpen extends Command {
	
	private final Holder holder;
	
	public HolderOpen() {
		this.holder = Holder.getInstance();
		requires(holder);
	}
	
	protected void initialize() {
		holder.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
