package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class servoRotate extends Command {
	
	int x=0;
	int y = 90;
    
	public servoRotate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.servo1);
    	setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.servo1.Zero();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.servo1.setAngle(x, x);
//    	SmartDashboard.putString("Working", "True");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString("Working", "done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	SmartDashboard.putString("Working", "True");
    }
}
