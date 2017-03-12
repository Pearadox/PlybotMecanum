//package org.usfirst.frc.team5414.robot.commands;
//
//import org.usfirst.frc.team5414.robot.Robot;
//import org.usfirst.frc.team5414.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class DriveToTarget extends Command {
//
//	
//	double[] AreaArray;
//	
//    public DriveToTarget() {
//	     requires(Robot.drivetrain);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	DriverStation.reportWarning("DriveToTarget", true);
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	try
//    	{
//	    	AreaArray = Robot.table.getNumberArray("area", new double[0]);
//        Robot.drivetrain.drive( -RobotMap.goToPegSpeed, -RobotMap.goToPegSpeed);
//	   	}
//    	catch(Exception e)
//    	{
//    		DriverStation.reportWarning("Error at DriveToTarget Execute", true);
//    	}
//    }	
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//    	
//    	try{
//        	
//	    	if(AreaArray.length == 2){ 
//	    		if(AreaArray[0] > 1500 || AreaArray[1] > 1500){
//	    			Robot.drivetrain.stop();
//	    			Robot.drivetrain.drive0, right);
//	    		}
//	    	}
//	    	else if(AreaArray.length >= 3) // If the spring splits one of the rectangles into two
//	    	{
//	    		if(AreaArray[0] > 1500 || AreaArray[1] > 1500 || AreaArray[3] > 1500)
//	    		{
//	    			Robot.drivetrain.stop();
//	    			return true;
//	    		}
//	    	}
//	    	else
//	    	{
//	    		Robot.drivetrain.drive(.6, .6);
//	    		return true;
//	    	}
//        	
//    	}catch (Exception e) {
//    		DriverStation.reportWarning("Error at DriveToTarget isFinished", true);
//		}
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.drivetrain.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	Robot.drivetrain.stop();
//    }
//}
