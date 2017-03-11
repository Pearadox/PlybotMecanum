package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderDrives extends Command {

	double distance, speedL, speedR, ultError;
	double errorL, errorR;
	double encDistL, encDistR;
	double kP = .00043333;
	
    public EncoderDrives(double d) {
        distance = d * RobotMap.EncoderTicks;
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    /	SmartDashboard.putNumber("encdist", Robot.drivetrain.getDistanceL());
    	SmartDashboard.putNumber("targetdist", distance);
    	encDistL = Robot.drivetrain.getDistanceL();
    	encDistR = Robot.drivetrain.getDistanceR() *1.5;
    	errorR = (distance - encDistR);
    	errorL = (distance - encDistL);
    	ultError = (100-((encDistL*100)/encDistR));
    	SmartDashboard.putNumber("encdistL", encDistL);
    	SmartDashboard.putNumber("encdistR", encDistR);
    
    	
    	speedL=errorL*kP;
    	speedR = errorR*kP;
    	
    	if(speedL >.7){
    		speedL = .7;
    	}
    	if(speedL <.5){
    		speedL = .5;
    	}
    	if(speedR >.7){
    		speedR = .7;
    	}
    	if(speedR <.5){
    		speedR = .5;
    	}
    	SmartDashboard.putNumber("difference", ultError);
    	SmartDashboard.putNumber("errorL", errorL);
    	SmartDashboard.putNumber("errorR", errorR);
    	SmartDashboard.putNumber("speedL", speedL);
    	SmartDashboard.putNumber("speedR", speedR);
    	if(distance>0){
    		Robot.drivetrain.drive(-speedL,speedR);
    	}else{
    		Robot.drivetrain.drive(speedL,-speedR);
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(Robot.drivetrain.getDistanceL()) >= distance){
    		return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
