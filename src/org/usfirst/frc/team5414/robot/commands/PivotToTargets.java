package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotToTargets extends Command {
	
	double error = 0;
 	double max = 0;
	int maxind = 0;
	double centerX = 0;
	double centerY = 0;
	int left = 0;
	int right = 1;
	double minspeed = .4;
	double maxspeed = .4;
	double cameraWidthInPixels = 360;
	double speed = .4;
	double kp = (maxspeed - minspeed)/129;
	double[] CenterArray;

    public PivotToTargets() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
    		CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
    		double cameraViewCenter = cameraWidthInPixels / 2;
    		//print blob #	
    		//check if 2 blobs 
//    		error = Math.abs(cameraViewCenter - CenterPanels);
//    		speed = error * kp +.3;
    		speed = .62;
//    		if(speed > maxspeed) {
//    			speed = maxspeed;
//    		}
//    		else if(speed < minspeed) {
//    			speed = minspeed;
//    		}
//	    	if(CenterArray.length > 2){
//	    		
//    		return;
//	    	}
	    	if(CenterArray.length < 2){
		 	    if (CenterArray.length == 0){
		 	    	Robot.drivetrain.drive(-speed, speed);
		    		
		    	}
		    	else if(CenterArray.length == 1){
		    		if(CenterArray[0] < cameraViewCenter){
		    			Robot.drivetrain.drive(speed, -speed);
		    		}
		    		else {
		    			Robot.drivetrain.drive(-speed, speed);
		    		}
		    	}	
	    	}
	    	
		} catch (Exception e) {
			DriverStation.reportWarning("Error at PivotToTargets", true);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(CenterArray.length >= 2){
    		if(Math.abs(CenterArray[0] - CenterArray[1]) <= CenterArray[0] * .4)
    			return true;
    			//if difference between 0 and 1 is less than 40% of 0
    			
    	}
//    	DriverStation.reportError("No targets found", CenterArray.length == 0);
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
