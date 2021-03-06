package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team.gif.autocommands.CanExtend;
import team.gif.autocommands.CanRetract;
import team.gif.autocommands.QuickStack;
import team.gif.autocommands.Stacro;
import team.gif.commands.ChopsticksClose;
import team.gif.commands.ChopsticksOpen;
import team.gif.commands.HolderOpen;
import team.gif.commands.collector.CollectorClose;
import team.gif.commands.collector.CollectorEject;
import team.gif.commands.collector.CollectorOpen;
import team.gif.commands.collector.CollectorReceive;
import team.gif.commands.collector.CollectorRotateLeft;
import team.gif.commands.collector.CollectorRotateRight;
import team.gif.commands.elevator.ElevSetpoint;
import team.gif.commands.elevator.ElevatorCoastDown;

/**
 * @author Patrick Ubelhor
 *
 * This class designates the ports for the joysticks and the location for each button.
 * Buttons can be programmed to run a command in the constructor.
 */
public class OI {
	
	private static final Joystick leftStick = new Joystick(0);
	private static final Joystick rightStick = new Joystick(1);
	private static final Joystick auxStick = new Joystick(2);

	public static Button leftTrigger = new JoystickButton(leftStick, 1);
	private static Button left2 = new JoystickButton(leftStick, 2);
	private static Button left3 = new JoystickButton(leftStick, 3);
	private static Button left4 = new JoystickButton(leftStick, 4);
	private static Button left5 = new JoystickButton(leftStick, 5);

	private static Button rightTrigger = new JoystickButton(rightStick, 1);
	private static Button right2 = new JoystickButton(rightStick, 2);
	private static Button right3 = new JoystickButton(rightStick, 3);
	private static Button right4 = new JoystickButton(rightStick, 4);
	private static Button right5 = new JoystickButton(rightStick, 5);

	private static Button auxTrigger = new JoystickButton(auxStick, 1);
	private static Button aux2 = new JoystickButton(auxStick, 2);
	private static Button aux3 = new JoystickButton(auxStick, 3);
	private static Button aux4 = new JoystickButton(auxStick, 4);
	private static Button aux5 = new JoystickButton(auxStick, 5);
	private static Button aux6 = new JoystickButton(auxStick, 6);
	private static Button aux7 = new JoystickButton(auxStick, 7);
	private static Button aux8 = new JoystickButton(auxStick, 8);
	private static Button aux9 = new JoystickButton(auxStick, 9);
	private static Button aux10 = new JoystickButton(auxStick, 10);
	private static Button aux11 = new JoystickButton(auxStick, 11);
	
	public OI() {
		left4.whenPressed(new CanRetract());
		left5.whenPressed(new CanExtend());

		rightTrigger.whenPressed(new CollectorOpen());
		rightTrigger.whenReleased(new CollectorClose());
		right2.whileHeld(new CollectorReceive());
		right3.whileHeld(new CollectorEject());
		right4.whileHeld(new CollectorRotateLeft());
		right5.whileHeld(new CollectorRotateRight());

		auxTrigger.whenPressed(new ChopsticksClose());
		aux2.whenReleased(new ElevatorCoastDown());
		//aux3.whenReleased(new ElevatorCoastUp());
		aux4.whenPressed(new ChopsticksOpen());
		aux5.whenPressed(new Stacro());
		aux6.whileHeld(new QuickStack());
		aux7.whenPressed(new ElevSetpoint(Globals.Elevator.LEVEL_2));
		aux8.whenPressed(new ElevSetpoint(Globals.Elevator.LEVEL_3));
		aux9.whenPressed(new ElevSetpoint(Globals.Elevator.LEVEL_4));
		aux10.whenPressed(new ElevSetpoint(Globals.Elevator.LEVEL_5));
		aux11.toggleWhenPressed(new HolderOpen());
	}
	
	public static double getLeftY() {
		if (Math.abs(OI.leftStick.getY()) > Globals.JOYSTICK_DEADBAND) {
			return -leftStick.getY();
		}
		return 0;
	}
	
	public static double getRightY() {
		if (Math.abs(OI.rightStick.getY()) > Globals.JOYSTICK_DEADBAND) {
			return -rightStick.getY();
		}
		return 0;
	}
	
}
