package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoToPeg extends CommandGroup {

    public GoToPeg() {
    	
    	addSequential(new LightOn());
    	
    	addSequential(new PivotToTargets());	//Rotate to targets
    	
    	addSequential(new PivotToCenter());		//Rotate to center of targets
    	
    	addSequential(new DriveToTarget());		//Drive to targets
    	
    	addSequential(new PivotToCenter());
    	
    	addSequential(new LightOff());
    	
    	return;
    }
}
