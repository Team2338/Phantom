package team.gif.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.subsystems.CollectorMotors;

/**
 * @author Patrick Ubelhor
 *
 * While this command is running, it will automatically call Stacro when
 * a tote hits the collector limit switch.
 */
public class QuickStack extends Command {
	
	private boolean toggle = false;
	private Command stacro;
	private double initTime = 0;
	
	public QuickStack() {}
	
	protected void initialize() {
		stacro = new Stacro();
	}
	
	protected void execute() {
		if (CollectorMotors.getInstance().getLimit()
				&& !toggle
				&& !stacro.isRunning()
				&& Timer.getFPGATimestamp() - initTime > 2) {
			
			stacro.start();
			toggle = true;
			initTime = Timer.getFPGATimestamp();
		} else {
			if (!CollectorMotors.getInstance().getLimit()) {
				toggle = false;
			}
		}
		SmartDashboard.putBoolean("toggle", toggle);
		SmartDashboard.putBoolean("StacroRunning", stacro.isRunning());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
}
