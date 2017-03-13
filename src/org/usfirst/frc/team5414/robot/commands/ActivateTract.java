package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateTract extends Command {

    public ActivateTract() {
    	requires(Robot.drivetrain);
    }

 
    protected void initialize() {
    	Robot.drivetrain.FullTraction();		//sets the solonoids to all disengage and have all tractions on the ground
    }

 
    protected void execute() {
        //I'm not sure this will set the drive back to arcade since isFinished goes to true. 
        /** Might need one command that does all the solenoids just for autonomous
         * and one command that does all the solenoids and stays in the execute with out finishing
         * for teleop command
         */
    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick1());	//sets the drive back to arcade
    }

   
    protected boolean isFinished() {
        return true;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
