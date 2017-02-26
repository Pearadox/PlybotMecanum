package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterBoilerGroup extends CommandGroup {

    public CenterBoilerGroup() {

    	addSequential(new TurnToBoiler());
    	
    	addSequential(new CenterToBoiler());
    }
}
