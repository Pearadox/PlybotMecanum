package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerGear extends Command {

    public LowerGear() {
    	requires(Robot.geararm);
    	setTimeout(4);				//sets the command to end after 4 seconds
    }

    
    protected void initialize() {
    	
    }

  
    protected void execute() {
    	Robot.geararm.lower();		//tells the geararm to go back down to the ground
    }

    
    protected boolean isFinished() {
        return isTimedOut();		//stops the command when the command times out
    }

 
    protected void end() {
    	Robot.geararm.stop(); 		//sets the geararm motor to 0 after the command is done exexuting
    }

    
    protected void interrupted() {
    }
}
