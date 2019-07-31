package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.subsystems.Elevator;

/**
 *
 */
public class ElevBumpDown extends Command {
	
	private final Elevator elevator;
	
	public ElevBumpDown() {
		this.elevator = Elevator.getInstance();
		requires(elevator);
	}
	
	protected void initialize() {
		elevator.drive(elevator.getHeight() - 200);
		Globals.elevatorSetpoint = elevator.getSetpoint();
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return true;
	}
	
	// Called once after isFinished returns true
	protected void end() {}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {}
	
}
