package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.subsystems.Elevator;

/**
 * @author NotPatrick (Ryan Guinn), Patrick Ubelhor
 */
public class ElevatorCoastDown extends Command {
	
	private final Elevator elevator;
	
	public ElevatorCoastDown() {
		this.elevator = Elevator.getInstance();
		requires(elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		// Causes a quick coast down until close to bottom, then slowly approaches limit switch
		if (elevator.getHeight() > 250) {
			elevator.drive(elevator.getHeight() - 325);
		} else {
			elevator.drive(elevator.getHeight() - 150);
		}
	}
	
	protected boolean isFinished() {
		if (elevator.getMin()) {
			elevator.reset();
			return true;
		}
		return false;
	}
	
	protected void end() {
		Globals.elevatorSetpoint = 0;
	}
	
	protected void interrupted() {
		Globals.elevatorSetpoint = elevator.getHeight();
	}
	
}
