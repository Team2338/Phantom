package team.gif.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.CollectorStandby;

/**
 * @author Patrick Ubelhor
 */
public class CollectorMotors extends Subsystem {
	
	private static final TalonSRX left = new TalonSRX(RobotMap.COLLECTOR_LEFT);
	private static final TalonSRX right = new TalonSRX(RobotMap.COLLECTOR_RIGHT);
	private static final DigitalInput limit = new DigitalInput(RobotMap.COLLECTOR_LIMIT);
	
	public CollectorMotors() {
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
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new CollectorStandby());
	}
}
