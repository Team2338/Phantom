package team.gif.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.elevator.ElevatorStandby;

/**
 * Doin' Elevator Stuff....
 *
 * @author Armaan Shah, Patrick Ubelhor
 */
public class Elevator extends Subsystem {
	
	private static Elevator instance;
	
	public static Elevator getInstance() {
		if (instance == null)
			instance = new Elevator();
		
		return instance;
	}
	
	private static final TalonSRX elevator = new TalonSRX(RobotMap.ELEVATOR);
	private static final DigitalInput elevatorMax = new DigitalInput(RobotMap.ELEVATOR_MAX);
	private static final DigitalInput elevatorMin = new DigitalInput(RobotMap.ELEVATOR_MIN);
	private static double prevSet = 0;
	
	private Elevator() {
		super();
		elevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		elevator.setSensorPhase(Globals.Elevator.IS_ENCODER_REVERSED);
		elevator.setInverted(Globals.Elevator.IS_MOTOR_REVERSED);
		elevator.setSelectedSensorPosition(0);
		elevator.config_kP(0, Globals.Elevator.kP);
		elevator.config_kI(0, Globals.Elevator.kI);
		elevator.config_kD(0, Globals.Elevator.kD);
		elevator.config_kF(0, Globals.Elevator.kF);
		elevator.config_IntegralZone(0, Globals.Elevator.I_ZONE);
	}
	
	public double getSetpoint() {
		return elevator.getClosedLoopTarget();
	}
	
	public double getError() {
		return elevator.getClosedLoopError();
	}
	
	public double getIAccum() {
		return elevator.getIntegralAccumulator();
	}
	
	public boolean getMin() {
		return !elevatorMin.get();
	}
	
	public boolean getMax() {
		return !elevatorMax.get();
	}
	
	public double getHeight() {
		return elevator.getSelectedSensorPosition();
	}
	
	public void drive(double setpoint) {
		if (setpoint != prevSet)
			elevator.setIntegralAccumulator(0);
		
		prevSet = setpoint;
		elevator.set(ControlMode.Position, setpoint);
	}
	
	public void reset() {
		elevator.setSelectedSensorPosition(0);
		drive(0);
	}
	
	public void displayMetrics() {
		SmartDashboard.putNumber("ElevSetpoint", getSetpoint());
		SmartDashboard.putNumber("ElevPosition", getHeight());
		SmartDashboard.putBoolean("ElevMin", getMin());
		SmartDashboard.putBoolean("ElevMax", getMax());
		SmartDashboard.putNumber("ElevOutput", elevator.getMotorOutputPercent());
		SmartDashboard.putNumber("ElevGainP", getError() * Globals.Elevator.kP);
		SmartDashboard.putNumber("ElevGainI", getIAccum() * Globals.Elevator.kI);
		SmartDashboard.putNumber("ElevGainD", elevator.getErrorDerivative() * Globals.Elevator.kD);
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStandby());
	}
	
}
