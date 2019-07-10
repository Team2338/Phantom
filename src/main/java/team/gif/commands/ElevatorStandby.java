package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author Armaan
 */
public class ElevatorStandby extends Command {
	
	private double position = 0;
	
	public ElevatorStandby() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {
		Robot.elevator.enablePositionControl();
		position = Globals.elevatorSetpoint;
	}
	
	protected void execute() {
		Robot.elevator.drive(position);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
