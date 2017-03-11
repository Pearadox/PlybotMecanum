package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToBoiler extends Command {

	int topIndex, botIndex;
	double[] AreaArray;
	double[] CenterX;
	int cameraCenter = 180;
	boolean passed;
	double CenterThreshold = 10;
	double kP = 0.003;
	
    public TurnToBoiler() {
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(6);
    	passed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try{
    		AreaArray = Robot.table.getNumberArray("area", new double[0]);
    		CenterX = Robot.table.getNumberArray("centerX", new double[0]);
    	} catch(Exception e) {}
    	
//    	First check if there are 2 targets
    	
//    	>>>If there are, loop through all area pairs and check
//    	   to see if one area is ~2x the size of another
    	
//    	>>>>>>If there is a correct area pair, check for similar x centers
    	
//    	>>>If there aren't any area pairs meeting the threshold,
//    	  	  continue turning
    	
//    	If there aren't 2 targets, continue turning
    	
    	double AreaThresholdPercentage = 25; // 25% threshold difference
    	double CenterXThreshold = 20;
    	try{
    	for(int i = 0; i < AreaArray.length; i++)
   		{
    		double area1 = AreaArray[i];
   			for(int j = 0; j < AreaArray.length; j++)
   			{
   				double area2 = AreaArray[j];
   				if(area1 * 2 >= area2 * (1 - AreaThresholdPercentage / 100) 
    			&& area1 * 2 <= area2 * (1 + AreaThresholdPercentage / 100))
    			{
   					if(CenterX[i] - CenterXThreshold <= CenterX[j] && CenterX[j] <= CenterX[i] + CenterXThreshold)
   					{
   						topIndex = j;
   						botIndex = i;
   						passed = true;
   						break;
   					}
   				}
    		}
    		if(passed) break;
   		}
    	} catch(Exception e) {SmartDashboard.putBoolean("Errored", true);}
    	double error;
    	try{
    	error = Math.abs(CenterX[0] - cameraCenter);
    	double speed = error * kP;
    	if(CenterX[0] >= cameraCenter + CenterXThreshold && passed) // Need to turn right 
    	{
    		Robot.drivetrain.drive(speed, -speed);
    	}
    	else if(CenterX[0] <= cameraCenter - CenterXThreshold && passed) // Need to turn left
    	{
    		Robot.drivetrain.drive(-speed, speed);
    	}
    	} catch(Exception e) {SmartDashboard.putBoolean("Errored", true);}
    	DriverStation.reportWarning(passed + "", true);
    	if(!passed) 
    	{
    		Robot.drivetrain.drive(-.45, .45);
    		DriverStation.reportWarning("404", true);
    	}
    	 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(CenterX.length > 1)
        {
        	if(cameraCenter + CenterThreshold >= CenterX[topIndex]
        		&& cameraCenter - CenterThreshold <= CenterX[topIndex])
        	{
        		DriverStation.reportWarning("Finished", true);
        		return true;
        	}
        }
        else if(isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
