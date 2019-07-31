package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.OI;
import team.gif.subsystems.Drivetrain;

/**
 * @author Patrick Ubelhor
 */
public class TankDriveLinear extends Command {
	
	private final Drivetrain chassis;
	
	public TankDriveLinear() {
		this.chassis = Drivetrain.getInstance();
		requires(chassis);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		chassis.setPercentOutput(OI.getLeftY(), OI.getRightY());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
