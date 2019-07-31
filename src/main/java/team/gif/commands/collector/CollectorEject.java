package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.CollectorMotors;

/**
 * @author Patrick Ubelhor
 */
public class CollectorEject extends Command {
	
	private final CollectorMotors collectorMotors;
	
	public CollectorEject() {
		this.collectorMotors = CollectorMotors.getInstance();
		requires(collectorMotors);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		collectorMotors.drive(CollectorMotors.Direction.OUT);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
