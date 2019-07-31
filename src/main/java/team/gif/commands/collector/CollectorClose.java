package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;
import team.gif.subsystems.CollectorPneumatics;

/**
 * @author Patrick Ubelhor
 */
public class CollectorClose extends Command {
	
	private final CollectorPneumatics collectorPneumo;
	
	public CollectorClose() {
		this.collectorPneumo = CollectorPneumatics.getInstance();
		requires(collectorPneumo);
	}
	
	protected void initialize() {
		collectorPneumo.close();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
