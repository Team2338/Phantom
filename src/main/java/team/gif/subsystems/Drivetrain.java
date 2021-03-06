package team.gif.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.RobotMap;

/**
 * @author Patrick Ubelhor
 */
public class Drivetrain extends Subsystem {
	
	private static Drivetrain instance;
	
	public static Drivetrain getInstance() {
		if (instance == null)
			instance = new Drivetrain();
		
		return instance;
	}
	
	private static final TalonSRX leftMaster = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_MASTER);
	private static final TalonSRX leftSlave = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_SLAVE);
	private static final TalonSRX rightMaster = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_MASTER);
	private static final TalonSRX rightSlave = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_SLAVE);
	
	private Drivetrain() {
		super();
		
		leftMaster.setNeutralMode(NeutralMode.Brake);
		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		leftMaster.setSensorPhase(Globals.Drivetrain.IS_REVERSED_LEFT_ENCODER);
		leftMaster.setInverted(Globals.Drivetrain.IS_REVERSED_LEFT_MASTER_MOTOR);
		leftMaster.setSelectedSensorPosition(0);
		leftMaster.config_kP(0, Globals.Drivetrain.P);
		leftMaster.config_kI(0, Globals.Drivetrain.I);
		leftMaster.config_kD(0, Globals.Drivetrain.D);
		rightMaster.config_IntegralZone(0, Globals.Drivetrain.I_ZONE);
		
		rightMaster.setNeutralMode(NeutralMode.Brake);
		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		rightMaster.setSensorPhase(Globals.Drivetrain.IS_REVERSED_RIGHT_ENCODER);
		rightMaster.setInverted(Globals.Drivetrain.IS_REVERSED_RIGHT_MASTER_MOTOR);
		rightMaster.setSelectedSensorPosition(0);
		leftMaster.config_kP(0, Globals.Drivetrain.P);
		leftMaster.config_kI(0, Globals.Drivetrain.I);
		leftMaster.config_kD(0, Globals.Drivetrain.D);
		rightMaster.config_IntegralZone(0, Globals.Drivetrain.I_ZONE);
		
		leftSlave.follow(leftMaster);
		leftSlave.setInverted(Globals.Drivetrain.IS_REVERSED_LEFT_SLAVE_MOTOR);
		
		rightSlave.follow(rightMaster);
		rightSlave.setInverted(Globals.Drivetrain.IS_REVERSED_RIGHT_SLAVE_MOTOR);
	}
	
	
	public double getLeftError() {
		return leftMaster.getClosedLoopError();
	}
	
	public double getRightError() {
		return rightMaster.getClosedLoopError();
	}
	
	public void setPercentOutput(double left, double right) {
		setLeftPercentOutput(left);
		setRightPercentOutput(right);
	}
	
	public void setLeftPercentOutput(double setpoint) {
		leftMaster.set(ControlMode.PercentOutput, setpoint);
	}
	
	public void setRightPercentOutput(double setpoint) {
		rightMaster.set(ControlMode.PercentOutput, setpoint);
	}
	
	public void setPosition(double left, double right) {
		setLeftPosition(left);
		setRightPosition(right);
	}
	
	public void setLeftPosition(double setpoint) {
		leftMaster.set(ControlMode.Position, setpoint);
	}
	
	public void setRightPosition(double setpoint) {
		rightMaster.set(ControlMode.Position, setpoint);
	}
	
	public double getLeftDistance() {
		return leftMaster.getSelectedSensorPosition();
	}
	
	public double getRightDistance() {
		return rightMaster.getSelectedSensorPosition();
	}
	
	public void resetEncoders() {
		leftMaster.setSelectedSensorPosition(0);
		rightMaster.setSelectedSensorPosition(0);
	}
	
	public void displayMetrics() {
		SmartDashboard.putNumber("DriveLeftPosition", getLeftDistance());
		SmartDashboard.putNumber("DriveRightPosition", getRightDistance());
	}
	
	@Override
	public void initDefaultCommand() {}
	
}
