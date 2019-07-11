package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.commands.HooksExtend;
import team.gif.commands.OutriggersExtend;

/**
 * @author Patrick Ubelhor
 *
 * Used in teleop to deploy outriggers.
 */
public class CanExtend extends CommandGroup {
	
	public CanExtend() {
		addSequential(new OutriggersExtend());
		addSequential(new WaitCommand(1));
		addSequential(new HooksExtend());
	}
}
