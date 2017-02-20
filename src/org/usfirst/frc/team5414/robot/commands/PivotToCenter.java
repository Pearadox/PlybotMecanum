package org.usfirst.frc.team5414.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class PivotToCenter extends Command {
	
	double error = 0;
 	double max = 0;
	int maxind = 0;
	double centerX = 0;
   	double LeftPanel = 0;
   	double RightPanel = 0;
	double centerY = 0;
	int left = 0;
	int right = 1;
	double minspeed = .2;
	double maxspeed = .5;
	final double cameraWidthInPixels = 360;	
	double speed = 0;
	double kp;
	final double cameraViewCenter = 180;
	double[] CenterArray;
//	double[] AreaArray = Robot.table.getNumberArray("area", new double[0]);
	double CenterPanels;
	boolean CenteredDone = false;
	
    public PivotToCenter() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    	//SELECT CENTERS
//    	try{
    		CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
//    		if(CenterArray.length > 2)	//Pick 2 largest, center onto those TODO
//    		{
//    			double temp2 = CenterArray[CenterArray.length-1];
//    			double temp1 = CenterArray[CenterArray.length-2];
//    			CenterArray[0] = temp1;
//    			CenterArray[1] = temp2;
//    		}
    		if(CenterArray[0] < CenterArray[1])
    		{
    			LeftPanel = CenterArray[0];
	    		RightPanel = CenterArray[1];
    		}
    		else
    		{
    			LeftPanel = CenterArray[1];
	    		RightPanel = CenterArray[0];
    		}
//	    	DriverStation.reportWarning(Arrays.toString(CenterArray), true);
//    	}catch(Exception e){
//    		DriverStation.reportWarning("Error at PivotToCenter (Select Centers)", true);
//    	}
	    
    	
    	//DESIGNATE SPEED BASED ON ERROR (PID)
    	CenterPanels = ((LeftPanel + RightPanel)/2.);
//    	try {
//        	error = Math.abs(cameraViewCenter - CenterPanels);
//        	kp = (maxspeed - minspeed)/129;
//    		speed = error * kp +.3;
//    		if(speed > maxspeed) {
//    			speed = maxspeed;
//    		}
//    		else if(speed < minspeed) {
//    			speed = minspeed;
//    		}
//    		kp = (maxspeed - minspeed)/129;
//    		CenterPanels = (LeftPanel + RightPanel)/2;
//    	}
//    	catch(Exception e) 
//    	{
//    		DriverStation.reportWarning("Error at PivotToCenter (PID)", true);
//    	}
    	//add pid closed loop TODO
    	
    	
    	
    	//ROTATE TO THE CENTER OF THE TARGET
    	try {
    		if(CenterPanels <= cameraViewCenter) {
    	   		Robot.drivetrain.drive(-.35, .35);
   			}
   			else if(CenterPanels > cameraViewCenter) { //Centering left
   	   			Robot.drivetrain.drive(.35, -.35); 
    		}
    	} 
    	catch (Exception e) {
    		DriverStation.reportWarning("Error at PivotToCenter (Rotate To Center)", true);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(CenterPanels < (cameraViewCenter + 15) && CenterPanels > (cameraViewCenter - 15)){
    		Robot.drivetrain.drive(0, 0);
    		return true;
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
