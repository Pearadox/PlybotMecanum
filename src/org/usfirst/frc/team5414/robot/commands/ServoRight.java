package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoRight extends Command {
int x =0;
    public ServoRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.servo1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	x = 0;
    	setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Servo2Angle", Robot.servo1.servo2.getAngle());
    	if(Robot.servo1.servo.getAngle()  <= 100){
//    		Robot.servo1.setAngleRight(90-(x/2));
    		x++;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Robot.servo1.servo.getAngle() >= 100)&& isTimedOut()){
    		SmartDashboard.putString("servo", "done");
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.servo1.Zero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
