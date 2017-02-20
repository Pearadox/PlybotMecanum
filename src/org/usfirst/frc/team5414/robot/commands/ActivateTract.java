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

    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick1());	//sets the drive back to arcade
    }

   
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
