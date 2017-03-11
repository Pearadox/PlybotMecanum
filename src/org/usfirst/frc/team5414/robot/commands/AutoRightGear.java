package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightGear extends CommandGroup {

    public AutoRightGear() {
    
//    	addSequential(new DriveEncDist(2));
    	addSequential(new RotateRight(45));
    	addSequential(new GoToPeg());

    	
    }
}
