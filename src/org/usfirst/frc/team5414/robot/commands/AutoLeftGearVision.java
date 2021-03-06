package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftGearVision extends CommandGroup {

    public AutoLeftGearVision() {
    
    	addSequential(new DriveEncDist(2));
    	
    	addSequential(new RotateLeft(45));
        
        //Can probably call the autoMidGear from this point. 
    	
    	addSequential(new GoToPeg());
    	
    	addSequential(new ScoringGearCommandGroup());
    	
    	addSequential(new DriveEncDist(-3));
    	
    	addSequential(new RotateRight(45));
    	
    	addParallel(new RaiseArm());
    	
    	addSequential(new DriveEncDist(3));
    	
    }
}
