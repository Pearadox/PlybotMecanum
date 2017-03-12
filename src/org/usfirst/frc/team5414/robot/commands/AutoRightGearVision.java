package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightGearVision extends CommandGroup {

    public AutoRightGearVision() {
    
    	addSequential(new DriveEncDist(2));
    	
    	addSequential(new RotateRight(45));
    	
    	addSequential(new GoToPeg());
    	
    	addSequential(new ScoringGearCommandGroup());
    	
    	addSequential(new DriveEncDist(-3));
    	
    	addSequential(new RotateLeft(45));
    	
    	addSequential(new DriveEncDist(3));

    	
    }
}
