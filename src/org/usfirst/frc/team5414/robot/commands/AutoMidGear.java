package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMidGear extends CommandGroup {

    public AutoMidGear() {
    	
//    	addSequential(new DriveEncDist(1));
    	
    	addSequential(new PivotToCenter());		//Rotate to center of targets
    	
    	addSequential(new DriveToTarget());		//Drive to targets
    	
    	addSequential(new PivotToCenter());
    	
    	return;
    }
}
