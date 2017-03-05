package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerGear extends Command {

    public LowerGear() {
//    	requires(Robot.geararm);
    }

    
    protected void initialize() {
    	
    }

  
    protected void execute() {
    	Robot.geararm.lower();
    }

    
    protected boolean isFinished() {
//        return isTimedOut();		//stops the command when the command times out
    	return true;
    }

 
    protected void end() {
//    	Robot.geararm.lower(); 		//sets the geararm motor to 0 after the command is done exexuting
    }

    
    protected void interrupted() {
    }
}
