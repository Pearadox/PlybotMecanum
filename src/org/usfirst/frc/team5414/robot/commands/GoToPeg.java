package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class GoToPeg extends CommandGroup {

    public GoToPeg() {
    	
    	addSequential(new ActivateTract());
    	
    	addSequential(new PivotToCenter());		//Rotate to center of targets
    	
//    	addSequential(new DriveToTarget());		//Drive to targets
    	
//    	addSequential(new PivotToCenter());
    	
//    	addSequential(new PivotToCenter());
    	
//    	addSequential(new PivotToCenter());
    	
//    	addSequential(new DriveToTarget());
    	
//    	addSequential(new ActivateHalf());    	
    }
}
