package team.gif;

/**
 * This file defines the values used in each subsystem.
 * If a value is changed, code must be redeployed.
 * DO NOT EDIT UNLESS YOU KNOW WHAT YOU ARE DOING. PLEASE CONSULT SOMEONE WHO DOES.
 */
public class Globals {
	
	public static final double COLLECTOR_SPEED = 1;
	public static final double JOYSTICK_DEADBAND = 0.1;
	
	// Drivetrain variables
	public static class Drivetrain {
		public static final double P = 1;
		public static final double I = 0.0001;
		public static final double D = 0.0;
		public static final int I_ZONE = 1000;
		public static final boolean IS_REVERSED_LEFT_ENCODER = false;
		public static final boolean IS_REVERSED_LEFT_MOTOR = true;
		public static final boolean IS_REVERSED_RIGHT_ENCODER = true;
		public static final boolean IS_REVERSED_RIGHT_MOTOR = true;
	}
	
	// Elevator variables
	public static class Elevator {
		public static final double elevDownP = 8;
		public static final double elevDownI = 0;
		public static final double elevDownD = 0;
		public static final boolean elevatorMotorReversed = true;
		public static final boolean elevatorEncoderReversed = true;
		public static final double kElevatorLevel1 = 12;
		public static final double kElevatorLevel2 = 1000;
		public static final double kElevatorLevel3 = 2100;
		public static final double kElevatorLevel4 = 3200;
		public static final double kElevatorLevel5 = 4300;
	}
	
	// DON'T TOUCH THIS VALUE OR THE ROBOT WILL DIE:
	public static double elevatorSetpoint = 0;
	//public static boolean chopsticksOpen = true;
}