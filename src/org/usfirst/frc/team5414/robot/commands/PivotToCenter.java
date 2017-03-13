package org.usfirst.frc.team5414.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

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
//	final double cameraViewCenter = 180;
	final double cameraViewCenter = 160;
	double[] CenterArray;
//	double[] AreaArray = Robot.table.getNumberArray("area", new double[0]);
	double CenterPanels;
	boolean CenteredDone = false;
	boolean onlyOne;
	double[] AreaArray;
	
	
    public PivotToCenter() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriverStation.reportWarning("PivotToCenter", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//SELECT CENTERS
    	
    	CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
    	
    	if(CenterArray.length < 2) 
    	{	
    		DriverStation.reportWarning("can't find 2", true);
    		Robot.drivetrain.drive(-.67, .67);
    		CenterPanels = 0;
    	}
        //may want to consider doing the below only for if there are two panels
        //and creating a separate else that is trying to guess which two are the right 
        //ones if there are 3 or more
        else
        {
            try{
                LeftPanel = CenterArray[0];
                RightPanel = CenterArray[1];

            }catch(Exception e){
                DriverStation.reportWarning("Error at PivotToCenter (Select Centers)", true);
            }

            //DESIGNATE SPEED BASED ON ERROR (PID)
            CenterPanels = ((LeftPanel + RightPanel)/2.);
            //ROTATE TO THE CENTER OF THE TARGET
            try {
                if(CenterPanels >= cameraViewCenter + 20) { //Centering Right
                    DriverStation.reportWarning("Centering Right", true);
                    Robot.drivetrain.drive(-.6, .6);
                    }
                    else if(CenterPanels < cameraViewCenter - 20) { //Centering left
                        DriverStation.reportWarning("Centering Left", true);
                        Robot.drivetrain.drive(.6, -.6); 
                }
                else { //centerPanels is cameraViewCenter +/- 20
                    Robot.drivetrain.drive(-RobotMap.goToPegSpeed, -RobotMap.goToPegSpeed);
                }
            }catch (Exception e) {
                    DriverStation.reportWarning("Error at PivotToCenter (Rotate To Center)", true);
            }
        }
    }
	
	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
            //the gotoPegSpeed should be done in the execute, not in the is finished
	    	if(CenterPanels < (cameraViewCenter + 20) && CenterPanels > (cameraViewCenter - 20)){
	    	//	Robot.drivetrain.drive(-RobotMap.goToPegSpeed, -RobotMap.goToPegSpeed);
//	    		DriverStation.reportWarning("PivToCenter Done", true);
	    		AreaArray = Robot.table.getNumberArray("area", new double[0]);
	    		if(AreaArray.length == 2){ 
		    		if(AreaArray[0] > 3000 || AreaArray[1] > 3000){
		    			Robot.drivetrain.stop();
		    			return true;
		    		}
		    	}
		    	else if(AreaArray.length >= 3) // If the spring splits one of the rectangles into two
		    	{
		    		if(AreaArray[0] > 3000 || AreaArray[1] > 3000 || AreaArray[3] > 3000)
		    		{
		    			Robot.drivetrain.stop();
		    			return true;
		    		}
		    	}
	    		return false;
	    	}
	        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.drive(0, 0);
    }
}
