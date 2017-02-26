package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToBoiler extends Command {

	double[] AreaArray;
	double[] CenterX;
	boolean passed = false;
	
    public TurnToBoiler() {
        
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
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
    	boolean passed = false;
    	for(int i = 0; i < AreaArray.length; i++)
   		{
    		double area1 = AreaArray[i];
   			for(int j = 0; i < AreaArray.length; j++)
   			{
   				double area2 = AreaArray[j];
   				if(area1 * 2 >= area2 * (1 - AreaThresholdPercentage / 100) 
    			&& area1 * 2 <= area2 * (1 + AreaThresholdPercentage / 100))
    			{
   					if(CenterX[i] - CenterXThreshold <= CenterX[j] && CenterX[j] <= CenterX[i] + CenterXThreshold)
   					{
   						passed = true;
   						break;
   					}
   				}
    		}
    		if(passed) break;
   		}
    	if(!passed) Robot.drivetrain.drive(-.6, .6);
    	else Robot.drivetrain.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return passed;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
