package team.gif;

/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public abstract class RobotMap {
	
	// CAN addresses
	public static final int collectorRight = 2;
	public static final int collectorLeft = 3;
	public static final int elevator = 4;
	public static final int DRIVETRAIN_RIGHT_MASTER = 5;
	public static final int DRIVETRAIN_RIGHT_SLAVE = 6;
	public static final int DRIVETRAIN_LEFT_MASTER = 7;
	public static final int DRIVETRAIN_LEFT_SLAVE = 8;
	
	// DIO ports
	public static final int elevatorMin = 0;
	public static final int elevatorMax = 1;
	public static final int collectorLimit = 4;
	
	// Relay ports (solenoids)
	public static final int collectorA = 0;
	public static final int collectorB = 0;
	public static final int hooksA = 3;
	public static final int hooksB = 3;
	public static final int holderA = 2;
	public static final int holderB = 2;
	public static final int outriggersA = 1;
	public static final int outriggersB = 1;
	public static final int chopSticksA = 4;
	public static final int chopSticksB = 4;
	
}
