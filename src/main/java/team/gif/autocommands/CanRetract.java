package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.commands.HooksRetract;
import team.gif.commands.OutriggersRetract;

/**
 *
 */
public class CanRetract extends CommandGroup {
	
	public CanRetract() {
		addSequential(new HooksRetract());
		addSequential(new WaitCommand(2));
		addSequential(new OutriggersRetract());
	}
}
