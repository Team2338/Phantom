package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author Armaan Shah, Patrick Ubelhor
 */
public class ElevatorStandby extends Command {
	
	public ElevatorStandby() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Robot.elevator.drive(Globals.elevatorSetpoint);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
