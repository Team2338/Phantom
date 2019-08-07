package team.gif;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.autocommands.AntiAuto;
import team.gif.autocommands.DrivePID;
import team.gif.autocommands.PullCans;
import team.gif.autocommands.WAITSTEPCAN;
import team.gif.commands.ChopsticksOpen;
import team.gif.commands.TankDriveLinear;
import team.gif.subsystems.Chopsticks;
import team.gif.subsystems.CollectorMotors;
import team.gif.subsystems.CollectorPneumatics;
import team.gif.subsystems.Drivetrain;
import team.gif.subsystems.Elevator;
import team.gif.subsystems.Holder;
import team.gif.subsystems.Hooks;
import team.gif.subsystems.Outriggers;

/**
 * @author Patrick Ubelhor
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
	
	public static final Elevator elevator = Elevator.getInstance();
	public static final Drivetrain chassis = Drivetrain.getInstance();
	public static final Chopsticks chopsticks = Chopsticks.getInstance();
	public static final CollectorMotors collectorMotors = CollectorMotors.getInstance();
	public static final CollectorPneumatics collectorPneumo = CollectorPneumatics.getInstance();
	public static final Outriggers outriggers = Outriggers.getInstance();
	public static final Holder holder = Holder.getInstance();
	public static final Hooks hooks = Hooks.getInstance();
	private static final Compressor compressor = new Compressor(RobotMap.COMPRESSOR_MODULE);
	public static OI oi;
	
	private SendableChooser<Command> autoChooser;
	private Command autoCommand;
	private Command teleCommand = new TankDriveLinear();
	
	@Override
	public void robotInit() {
		oi = new OI();
		
		autoChooser = new SendableChooser<>();
		autoChooser.setDefaultOption("No autonomous", new AntiAuto());
		autoChooser.addOption("Drive Forward", new DrivePID(4000, 4000));
		autoChooser.addOption("Step Cans", new PullCans());
		autoChooser.addOption("WAIT STEP CANS", new WAITSTEPCAN());
		autoChooser.addOption("TurnLeft90", new DrivePID(-1000, 1000));
		SmartDashboard.putData("Auto Mode", autoChooser);
	}
	
	@Override
	public void robotPeriodic() {
		chassis.displayMetrics();
		collectorMotors.displayMetrics();
		elevator.displayMetrics();
	}
	
	@Override
	public void autonomousInit() {
		(new ChopsticksOpen()).start();
		autoCommand = autoChooser.getSelected();
		autoCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putData(chassis);
	}
	
	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		teleCommand.start();
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledInit() {}
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {}
	
}
