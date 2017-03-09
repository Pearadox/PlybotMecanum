package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoIncremental extends Command {
	int x = 0;
	int y = 0;
	int v = 90;
    public ServoIncremental() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.servo1);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	x=0;
    	y=0;
//    	y=90;
    	Robot.servo1.Zero();
//    	setTimeout(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	SmartDashboard.putString("servo", "started");
//    	if((Robot.servo1.servo.getAngle() <= 90) && (Robot.servo1.servo2.getAngle() >= 0)){
//    		Robot.servo1.setSpeed();
//    		SmartDashboard.putString("servo", "working");
//    	}
    	
//    	SmartDashboard.putString("servo", "started");
//    	if(isTimedOut()==true){
//    		setTimeout(1);
//    		x+=10;
//    		y-=10;
//    		Robot.servo1.setAngle(x, x);
//    		SmartDashboard.putString("servo", "working");
//    		
//    	}
    	
    	
//    		Robot.servo1.setAngle(x/1.4, (90-(x/1.4)));
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
    	Robot.servo1.Zero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
