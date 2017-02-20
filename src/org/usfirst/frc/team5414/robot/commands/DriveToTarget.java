package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTarget extends Command {

	
	double[] AreaArray;
	
    public DriveToTarget() {
	     requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try
    	{
	    	AreaArray = Robot.table.getNumberArray("area", new double[0]);
        Robot.drivetrain.drive( RobotMap.goToPegSpeed, RobotMap.goToPegSpeed);
	   	}
    	catch(Exception e)
    	{
    		DriverStation.reportWarning("Error at DriveToTarget Execute", true);
    	}
    }	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	try{
        	
	    	if(AreaArray.length == 2){ 
	    		if(AreaArray[0] > 3000 || AreaArray[1] > 3000){
	    			Robot.drivetrain.drive(0, 0);
	    			return true;
	    		}
	    	}
	    	else if(AreaArray.length >= 3) // If the spring splits one of the rectangles into two
	    	{
	    		if(AreaArray[0] > 3000 || AreaArray[1] > 3000 || AreaArray[3] > 3000)
	    		{
	    			Robot.drivetrain.drive(0, 0);
	    		}
	    	}
        	
    	}catch (Exception e) {
    		DriverStation.reportWarning("Error at DriveToTarget isFinished", true);
		}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.drive(0, 0);
    }
}
