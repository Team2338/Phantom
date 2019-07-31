package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.Hooks;

/**
 * @author Patrick Ubelhor
 */
public class HooksExtend extends Command {
	
	private final Hooks hooks;
	
	public HooksExtend() {
		this.hooks = Hooks.getInstance();
		requires(hooks);
	}
	
	protected void initialize() {
		hooks.extend();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
