package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoringGearCommandGroup extends CommandGroup {

    public ScoringGearCommandGroup() {
    	addParallel(new SpitGear());
    	
    	addParallel(new LowerArm());
    	
//    	addSequential(new EncoderDrives(-1));
    }
}
