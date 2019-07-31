package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.subsystems.Elevator;

/**
 *
 */
public class ElevBumpUp extends Command {
	
	private final Elevator elevator;
	
	public ElevBumpUp() {
		this.elevator = Elevator.getInstance();
		requires(elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		elevator.drive(elevator.getHeight() + 200);
		Globals.elevatorSetpoint = elevator.getSetpoint();
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
