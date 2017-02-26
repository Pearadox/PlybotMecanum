package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterToBoiler extends Command {

	double[] centerX;
	double[] AreaArray;
	double cameraViewPixels = 360;
	double cameraCenter = cameraViewPixels / 2;
	double Center;
	
    public CenterToBoiler() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try
    	{
    		centerX = Robot.table.getNumberArray("centerX", new double[0]);
    		AreaArray = Robot.table.getNumberArray("area", new double[0]);
    	} catch(Exception e){}
    	
    	//Find the Centers of the targets of x and 2x sizes with similar xcoords
    	double AreaThresholdPercentage = 25; // 25% threshold difference
    	double CenterXThreshold = 20;
    	boolean passed = false;
    	int index1 = 0, index2 = 0;
    	for(int i = 0; i < AreaArray.length; i++)
   		{
    		double area1 = AreaArray[i];
    		for(int j = 0; i < AreaArray.length; j++)
   			{
   				double area2 = AreaArray[j];
   				if(area1 * 2 >= area2 * (1 - AreaThresholdPercentage / 100) 
    			&& area1 * 2 <= area2 * (1 + AreaThresholdPercentage / 100))
    			{
   					if(centerX[i] - CenterXThreshold <= centerX[j] && centerX[j] <= centerX[i] + CenterXThreshold)
   					{
   						passed = true;
   						break;
   					}
   				}
    		}
    		if(passed) break;
    	}
    	Center = (centerX[index1] + centerX[index2])/2;
    	
    	if(Center < cameraCenter)
    	{
    		Robot.drivetrain.drive(-.4, .4);
    	}
    	else
    	{
    		Robot.drivetrain.drive(.4,-.4);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double thresholdPixels = 15;
    	return (Center >= cameraCenter - thresholdPixels) && (Center <= cameraCenter + thresholdPixels);
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
