package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.subsystems.Elevator;

/**
 * @author Armaan Shah, Patrick Ubelhor
 */
public class ElevatorStandby extends Command {
	
	private final Elevator elevator;
	
	public ElevatorStandby() {
		this.elevator = Elevator.getInstance();
		requires(elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		elevator.drive(Globals.elevatorSetpoint);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
