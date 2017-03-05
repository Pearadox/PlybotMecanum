package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseArm extends Command {

	boolean islimitpressed =false;
    public RaiseArm() {
      
    	requires(Robot.geararm);
    	requires(Robot.gearcollector);
    }


    protected void initialize() {
//    	islimitpressed = Robot.gearcollector.isLimitSet();  //makes a boolean that will be used to stop the function if the limit is pressed before command starts
    }


    protected void execute() {
//    	if (islimitpressed == false)				//if the limit had been pressed intially, it executes nothing for the program and eventually times out
//    		Robot.geararm.raise();			//if the limit isnt pressed initially, raise the arm
    	Robot.geararm.raise();
   	}
    	


    protected boolean isFinished() {
//    	if(!Robot.gearcollecto?r.isLimitSet()){		//if the limit switch has been pressed, this stops the command
    		return true;
//    	}
//        return isTimedOut();						//stops the command after 5 seconds
    }

  
    protected void end() {
//    	Robot.geararm.setTalonMode();
    	Robot.geararm.raise();						//after command has ended the gear arm motor is set to 0
    	
    }


    protected void interrupted() {
    }
}
