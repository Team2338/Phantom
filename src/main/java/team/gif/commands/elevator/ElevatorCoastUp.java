package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.subsystems.Elevator;

/**
 * @author NotPatrick (Ryan Guinn), Patrick
 */
public class ElevatorCoastUp extends Command {
	
	private final Elevator elevator;
	private static double topVal = 7992;
	
	public ElevatorCoastUp() {
		this.elevator = Elevator.getInstance();
		requires(elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		if (elevator.getHeight() < 4700) {
			elevator.drive(elevator.getHeight() + 325);
		} else {
			elevator.drive(elevator.getHeight() + 50);
		}
	}
	
	protected boolean isFinished() {
		if (elevator.getMax()) {
			topVal = elevator.getHeight();
			elevator.drive(topVal);
			return true;
		}
		return false;
	}
	
	protected void end() {
		Globals.elevatorSetpoint = topVal;
	}
	
	protected void interrupted() {
		Globals.elevatorSetpoint = elevator.getHeight();
	}
	
}
