package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author Patrick Ubelhor
 *
 * Uses PID on drive encoders to move the bot.
 * NOTE: No gyro is used, so this is not guaranteed to drive straight.
 */
public class DrivePID extends Command {
	
	private static final double TOLERANCE = 200;
	private double leftSetpoint;
	private double rightSetpoint;
	
	public DrivePID(double leftSetpoint, double rightSetpoint) {
		requires(Robot.chassis);
		this.leftSetpoint = leftSetpoint;
		this.rightSetpoint = rightSetpoint;
	}
	
	protected void initialize() {
		Robot.chassis.resetEncoders();
		Robot.chassis.setLeftPosition(leftSetpoint);
		Robot.chassis.setRightPosition(rightSetpoint);
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return (Robot.chassis.getLeftError() < TOLERANCE
				&& Robot.chassis.getRightError() < TOLERANCE);
	}
	
	protected void end() {
		Robot.chassis.setPercentOutput(0, 0);
	}
	
	protected void interrupted() {}
	
}
