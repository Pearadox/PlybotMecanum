package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateLeft extends Command {

	private double desiredAngle;
	private double changeInAngle;
	private double originalAngle;
	
    public RotateLeft(double angle) {
    	desiredAngle = angle;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	originalAngle = Robot.gyro.getYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	changeInAngle = Robot.gyro.getYaw() - originalAngle;
    	Robot.drivetrain.drive(.4, -.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(changeInAngle) >= desiredAngle)
		{
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

    }
}
