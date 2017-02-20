package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLeftSide extends CommandGroup {

    public AutonomousLeftSide() {
    
    	addSequential(new DriveEncDist(2));
    	
    	addSequential(new RotateLeft(45));
    	
    	addSequential(new GoToPeg());

    	
    }
}
