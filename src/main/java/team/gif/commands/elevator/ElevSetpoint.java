package team.gif.commands.elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.subsystems.Elevator;

/**
 * @author Patrick Ubelhor
 */
public class ElevSetpoint extends Command {
	
	private final Elevator elevator;
	private double setpoint;
	private double initTime;
	
	public ElevSetpoint(double setpoint) {
		this.elevator = Elevator.getInstance();
		this.setpoint = setpoint;
		requires(elevator);
	}
	
	protected void initialize() {
		Globals.elevatorSetpoint = setpoint;
		initTime = Timer.getFPGATimestamp();
	}
	
	protected void execute() {
		elevator.drive(setpoint);
	}
	
	protected boolean isFinished() {
		if (elevator.getMin()) {
			elevator.reset();
			return true;
		}
		
		return (Math.abs(elevator.getError()) < 100 && Timer.getFPGATimestamp() - initTime > 0.01);
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
