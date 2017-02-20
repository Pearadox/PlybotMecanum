package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Holding extends Command {

    public Holding() {
    	requires(Robot.climber);
    }

    
    protected void initialize() {
    }

    
    protected void execute() {
    	Robot.climber.holdLifter();		//sets the climber motor to a set speed in order to keep it from sliding down the rope
    }

  
    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
