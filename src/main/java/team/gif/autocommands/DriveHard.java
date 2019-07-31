package team.gif.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.subsystems.Drivetrain;

/**
 * @author Patrick Ubelhor
 *
 * Uses dead-reckoning to drive forward.
 */
public class DriveHard extends Command {
	
	private double initTime = 0;
	private double endTime;
	private double speed;
	
	public DriveHard(double speed, double time) {
		requires(Drivetrain.getInstance());
		this.speed = speed;
		this.endTime = time;
	}
	
	protected void initialize() {
		initTime = Timer.getFPGATimestamp();
	}
	
	protected void execute() {
		Drivetrain.getInstance().setPercentOutput(speed, speed);
	}
	
	protected boolean isFinished() {
		return (Timer.getFPGATimestamp() - initTime > endTime);
	}
	
	protected void end() {
		Drivetrain.getInstance().setPercentOutput(0, 0);
	}
	
	protected void interrupted() {}
	
}
