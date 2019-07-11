package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author NotPatrick (Ryan Guinn), Patrick
 */
public class ElevatorCoastUp extends Command {
	
	private static double topVal = 7992;
	
	public ElevatorCoastUp() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		if (Robot.elevator.getHeight() < 4700) {
			Robot.elevator.drive(Robot.elevator.getHeight() + 325);
		} else {
			Robot.elevator.drive(Robot.elevator.getHeight() + 50);
		}
	}
	
	protected boolean isFinished() {
		if (Robot.elevator.getMax()) {
			topVal = Robot.elevator.getHeight();
			Robot.elevator.drive(topVal);
			return true;
		}
		return false;
	}
	
	protected void end() {
		Globals.elevatorSetpoint = topVal;
	}
	
	protected void interrupted() {
		Globals.elevatorSetpoint = Robot.elevator.getHeight();
	}
	
}
