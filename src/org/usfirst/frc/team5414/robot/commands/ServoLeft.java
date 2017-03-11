package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoLeft extends Command {
int x = 0;
    public ServoLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.servo1);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	x = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("servo1Angle", Robot.servo1.servo.getAngle());
//    	Robot.servo1.setAngleLeft(x/1.4);
    	x++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.servo1.servo.getAngle() >= 100){
    		SmartDashboard.putString("servo", "done");
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
