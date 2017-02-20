package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectGear extends Command {
	
    public CollectGear() {
        requires(Robot.geararm);
        requires(Robot.gearcollector);
        
    }

    protected void initialize() {
    	

    }

    
    protected void execute() {

    	Robot.gearcollector.StartIntake();		//Starts the intake mechanism for the collector
    	
    }

   
    protected boolean isFinished() {
    	if(!Robot.oi.getJoystick1().getRawButton(RobotMap.BtnCollectGear)){			//stops command when BtnCollectGear is no longer being pressed 
    		return true;
    	}
        return false;
    }

   
    protected void end() {
    	Robot.gearcollector.Stop();			//sets the intake of the collecter to 0
    }

    
    protected void interrupted() {
    }
}
