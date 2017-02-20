package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectGear extends Command {
	
    public CollectGear() {
        requires(Robot.geararm);
        requires(Robot.gearcollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.gearcollector.StartIntake();
    	Timer.delay(.25);
    	Robot.gearcollector.Stop();
    	Robot.geararm.raise();
    	
    	
//    	Robot.geararm.lower();
//    	Robot.gearcollector.StartIntake();
//    	Robot.geararm.raise();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
