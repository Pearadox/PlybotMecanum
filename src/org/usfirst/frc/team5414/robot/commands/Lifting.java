package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lifting extends Command {

    public Lifting() {
       requires(Robot.climber);
       requires(Robot.electrical);
       requires(Robot.servo1);
    }

    
    protected void initialize() {
    	Robot.servo1.Zero();		//resets the servos if they were out of position
    }

   
    protected void execute() {
//    	Robot.servo1.setAngle(RobotMap.Servo1Angle, RobotMap.Servo2Angle);		//moves the servos to grab the rope
    	Robot.climber.lift();								//sets the climber to a set speed to initialize climbing
    }

    
    protected boolean isFinished() {
    	if (Robot.electrical.getClimberCurrent() > RobotMap.climberCurrentSpike) {		//when it hits the top, stop climbing
    		return true;
    	}
    	
    		return false;
    	
    	
    }

    protected void end() {
    	Robot.climber.holdLifter();			//when the robot hits the very top, the climber will be given a set speed in order to maintain its height
    }

    
    protected void interrupted() {
    }
}
