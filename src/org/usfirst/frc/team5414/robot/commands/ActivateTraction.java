package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateTraction extends Command {

    public ActivateTraction() {
      
    	requires(Robot.drivetrain);
    }

   
    protected void initialize() {
    	Robot.drivetrain.FullTraction();  	//sets the solonoids to all mecanums engaged with the ground
    }

  
    protected void execute() {

    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick1());		//sets the drivetrain to be mecanum drive
    }

    
    protected boolean isFinished() {
    	if(!Robot.oi.getJoystick1().getRawButton(RobotMap.BtnButterfly)){		//Stops the command when the BtnButterfly is no longer being pressed
    		return true;
    	}
        return false;
    }


    protected void end() {
    	Robot.drivetrain.FullButterfly();							//sets the bot back to full traction wheels 
    	Robot.drivetrain.mecanumDrive(Robot.oi.getJoystick1());		//sets the drive back to arcade
    }

   
    protected void interrupted() {
    }
}
