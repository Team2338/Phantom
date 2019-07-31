package team.gif.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.collector.CollectorStandby;

/**
 * @author Patrick Ubelhor
 */
public class CollectorMotors extends Subsystem {
	
	public static enum Direction {
		IN, OUT, LEFT, RIGHT
	}
	
	private static CollectorMotors instance;
	
	public static CollectorMotors getInstance() {
		if (instance == null)
			instance = new CollectorMotors();
		
		return instance;
	}
	
	private static final TalonSRX left = new TalonSRX(RobotMap.COLLECTOR_LEFT);
	private static final TalonSRX right = new TalonSRX(RobotMap.COLLECTOR_RIGHT);
	private static final DigitalInput limit = new DigitalInput(RobotMap.COLLECTOR_LIMIT);
	
	private CollectorMotors() {
		super();
		
		left.setNeutralMode(NeutralMode.Brake);
		left.setInverted(Globals.Collector.IS_LEFT_REVERSED);

		right.setNeutralMode(NeutralMode.Brake);
		right.setInverted(Globals.Collector.IS_RIGHT_REVERSED);
	}
	
	/**
	 * @return Whether the arcade button on the collector is pressed.
	 */
	public boolean getLimit() {
		return !limit.get();
	}
	
	/**
	 * Sets the speed of both motors.
	 * Positive speed collects, negative speed ejects.
	 *
	 * @param leftSpeed The speed of the left motor
	 * @param rightSpeed The speed of the right motor
	 */
	public void drive(double leftSpeed, double rightSpeed) {
		left.set(ControlMode.PercentOutput, leftSpeed);
		right.set(ControlMode.PercentOutput, rightSpeed);
	}
	
	public void drive(Direction direction) {
		double leftSpeed = Globals.Collector.SPEED;
		double rightSpeed = Globals.Collector.SPEED;
		
		if (direction == Direction.OUT || direction == Direction.LEFT) {
			leftSpeed *= -1;
		}
		
		if (direction == Direction.OUT || direction == Direction.RIGHT) {
			rightSpeed *= -1;
		}
		
		drive(leftSpeed, rightSpeed);
	}
	
	public void displayMetrics() {
		SmartDashboard.putBoolean("CollectorLimit", getLimit());
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new CollectorStandby());
	}
}
