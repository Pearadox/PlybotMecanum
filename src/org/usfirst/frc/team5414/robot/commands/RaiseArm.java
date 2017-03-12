package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RaiseArm extends Command {

	double upPos = 0.0;
	boolean islimitpressed =false;
	double CurrentPos = 0;
	
    public RaiseArm() {
      
    	requires(Robot.geararm);
    }


    protected void initialize() {
    	Robot.geararm.setPosition(RobotMap.ArmPositionUp);
//    	upPos = Robot.prefs.getDouble("UpPosition", RobotMap.ArmPositionDown);
//    	System.out.println("RaiseArm");
//    	islimitpressed = Robot.gearcollector.isLimitSet();  //makes a boolean that will be used to stop the function if the limit is pressed before command starts
    
    }


    protected void execute() {
//    	CurrentPos = Robot.geararm.GearArm.getPulseWidthPosition()  & 0xFFF;
//    	SmartDashboard.putNumber("CurrentArmPosition", CurrentPos);
//    	if (islimitpressed == false)				//if the limit had been pressed intially, it executes nothing for the program and eventually times out
//    		Robot.geararm.raise();			//if the limit isnt pressed initially, raise the arm
//    	Robot.geararm.raise(upPos);
   	}
    	


    protected boolean isFinished() {

//    	CurrentPos = Robot.geararm.GearArm.getPulseWidthPosition() & 0xFFF; 
//    	if(!Robot.gearcollector.isLimitSet()){		//if the limit switch has been pressed, this stops the command
//    	if (CurrentPos < 5)	
    		return true;
//    	else
//    		return false;
//    	}
//        return isTimedOut();						//stops the command after 5 seconds
    }

  
    protected void end() {
//    	Robot.geararm.setTalonMode();
//    	Robot.geararm.raise(upPos);						//after command has ended the gear arm motor is set to 0
//    	Robot.geararm.stop();
    }


    protected void interrupted() {
//    	end();
    }
}
