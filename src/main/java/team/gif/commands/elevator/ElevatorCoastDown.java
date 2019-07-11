package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author NotPatrick (Ryan Guinn), Patrick Ubelhor
 */
public class ElevatorCoastDown extends Command {
	
	public ElevatorCoastDown() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		// Causes a quick coast down until close to bottom, then slowly approaches limit switch
		if (Robot.elevator.getHeight() > 250) {
			Robot.elevator.drive(Robot.elevator.getHeight() - 325);
		} else {
			Robot.elevator.drive(Robot.elevator.getHeight() - 150);
		}
	}
	
	protected boolean isFinished() {
		if (Robot.elevator.getMin()) {
			Robot.elevator.reset();
			return true;
		}
		return false;
	}
	
	protected void end() {
		Globals.elevatorSetpoint = 0;
	}
	
	protected void interrupted() {
		Globals.elevatorSetpoint = Robot.elevator.getHeight();
	}
	
}
