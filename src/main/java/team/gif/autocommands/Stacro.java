package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.commands.ChopsticksClose;
import team.gif.commands.ChopsticksOpen;
import team.gif.commands.elevator.ElevSetpoint;
import team.gif.commands.elevator.ElevatorCoastDown;

/**
 * @author Patrick Ubelhor
 */
public class Stacro extends CommandGroup {
	
	public Stacro() {
		
		// Place stack on new tote
		addSequential(new ElevSetpoint(Globals.Elevator.LEVEL_2));
		addSequential(new ChopsticksOpen());
		addSequential(new WaitCommand(0.18));
		
		// Lift new stack a bit above level 2 (to clear lip of next inbound tote)
		addSequential(new ElevSetpoint(Globals.Elevator.LEVEL_1));
		addSequential(new ElevatorCoastDown());
		addSequential(new ChopsticksClose());
		addSequential(new WaitCommand(.25));
		addSequential(new ElevSetpoint(Globals.Elevator.LEVEL_2_BUMP));
	}
}
