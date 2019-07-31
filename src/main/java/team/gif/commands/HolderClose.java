package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.Holder;

/**
 * @author Patrick Ubelhor
 */
public class HolderClose extends Command {
	
	private final Holder holder;
	
	public HolderClose() {
		this.holder = Holder.getInstance();
		requires(holder);
	}
	
	protected void initialize() {
		holder.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
