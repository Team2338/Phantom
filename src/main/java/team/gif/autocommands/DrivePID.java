package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.Drivetrain;

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
		requires(Drivetrain.getInstance());
		this.leftSetpoint = leftSetpoint;
		this.rightSetpoint = rightSetpoint;
	}
	
	protected void initialize() {
		Drivetrain.getInstance().resetEncoders();
		Drivetrain.getInstance().setLeftPosition(leftSetpoint);
		Drivetrain.getInstance().setRightPosition(rightSetpoint);
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return (Drivetrain.getInstance().getLeftError() < TOLERANCE
				&& Drivetrain.getInstance().getRightError() < TOLERANCE);
	}
	
	protected void end() {
		Drivetrain.getInstance().setPercentOutput(0, 0);
	}
	
	protected void interrupted() {}
	
}
