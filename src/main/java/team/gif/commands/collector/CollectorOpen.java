package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.CollectorPneumatics;

/**
 * @author Patrick Ubelhor
 */
public class CollectorOpen extends Command {
	
	private final CollectorPneumatics collectorPneumo;
	
	public CollectorOpen() {
		this.collectorPneumo = CollectorPneumatics.getInstance();
		requires(collectorPneumo);
	}
	
	protected void initialize() {
		collectorPneumo.open();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
