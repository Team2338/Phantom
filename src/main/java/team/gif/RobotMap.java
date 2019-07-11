package team.gif;

/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public abstract class RobotMap {
	
	// CAN addresses
	public static final int COLLECTOR_RIGHT = 2;
	public static final int COLLECTOR_LEFT = 3;
	public static final int ELEVATOR = 4;
	public static final int DRIVETRAIN_RIGHT_MASTER = 5;
	public static final int DRIVETRAIN_RIGHT_SLAVE = 6;
	public static final int DRIVETRAIN_LEFT_MASTER = 7;
	public static final int DRIVETRAIN_LEFT_SLAVE = 8;
	
	// DIO ports
	public static final int ELEVATOR_MIN = 0;
	public static final int ELEVATOR_MAX = 1;
	public static final int COLLECTOR_LIMIT = 4;
	
	// Relay ports (solenoids)
	public static final int COLLECTOR_A = 0;
	public static final int COLLECTOR_B = 0;
	public static final int HOOKS_A = 3;
	public static final int HOOKS_B = 3;
	public static final int HOLDER_A = 2;
	public static final int HOLDER_B = 2;
	public static final int OUTRIGGERS_A = 1;
	public static final int OUTRIGGERS_B = 1;
	public static final int CHOPSTICKS_A = 4;
	public static final int CHOPSTICKS_B = 4;
	
}
