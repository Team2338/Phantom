package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.CollectorMotors;

/**
 * @author Patrick Ubelhor
 */
public class CollectorStandby extends Command {
	
	private final CollectorMotors collectorMotors;
	
	public CollectorStandby() {
		this.collectorMotors = CollectorMotors.getInstance();
		requires(collectorMotors);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		collectorMotors.drive(0.0, 0.0);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
