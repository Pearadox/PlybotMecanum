package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpitGear extends Command {

    public SpitGear() {
        
 
        requires(Robot.gearcollector);
    	
    }

   
    protected void initialize() {
    }

    
    protected void execute() {
    	Robot.gearcollector.StartOuttake();			//sets the GearWheelMotors to spit out the gear that has been collected
    }

    
    protected boolean isFinished() {
        //this command probably wont work in autonomous because the button isn't pushed, causing it to immediately be finished. 
    	if(!Robot.oi.getJoystick1().getRawButton(RobotMap.BtnLower)){			//stops the command if the button BtnCollectGearSpit is no longer being pressed 
    		return true;
    	}
        return false;
    }

    
    protected void end() {
    	Robot.gearcollector.Stop();			//stops the gear intake & outake motors
    }	

    
    protected void interrupted() {
    }
}
