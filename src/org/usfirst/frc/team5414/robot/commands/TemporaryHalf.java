package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TemporaryHalf extends Command {

    public TemporaryHalf() {
    	requires(Robot.drivetrain);
    }

  
    protected void initialize() {
    	Robot.drivetrain.HalfButterfly();		//sets robot to half traction half omni wheels
    }

    
    protected void execute() {

    	Robot.drivetrain.mecanumDrive(Robot.oi.getJoystick1());		//sets drivestrain to mechanum drive
    }

    
    protected boolean isFinished() {
    	if(!Robot.oi.getJoystick1().getRawButton(RobotMap.half)){ 		//stops command when BtnHalf is no longer being pressed
    		return true;
    	}
        return false;
    }

    
    protected void end() {
    	Robot.drivetrain.FullTraction();							//sets the robot back into all traction wheels
    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoystick1());		// sets drivetrain back to arcade drive
    }

   
    protected void interrupted() {
    }
}
