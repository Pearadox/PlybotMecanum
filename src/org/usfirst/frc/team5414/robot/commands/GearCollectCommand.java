package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCollectCommand extends CommandGroup {

    public GearCollectCommand() {
    	
    	addSequential(new CollectGear());
    	
//    	addSequential(new RaiseArm());

    }
}
