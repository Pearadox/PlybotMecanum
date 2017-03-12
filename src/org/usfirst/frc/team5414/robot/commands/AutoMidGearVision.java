package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMidGearVision extends CommandGroup {

    public AutoMidGearVision() {
        
    	addSequential(new DriveEncDist(6));
    	
    	addSequential(new GoToPeg());
    	
//    	addSequential(new DriveEncDist(1));
    	
    	addSequential(new ScoringGearCommandGroup());
    	
//    	addSequential(new DriveEncDist(-3));
//    	
//    	addSequential(new RotateRight(90));
//    	
//    	addParallel(new RaiseArm());
//    	
//    	addSequential(new DriveEncDist(4));
//    	
//    	addSequential(new RotateLeft(90));
//    	
//    	addSequential(new DriveEncDist(5));
    }
}
