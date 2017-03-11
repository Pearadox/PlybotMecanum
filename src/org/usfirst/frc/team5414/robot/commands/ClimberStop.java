package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberStop extends Command {

    public ClimberStop() {
       
    	requires(Robot.climber);
    }

   
    protected void initialize() {
    }

   
    protected void execute() {
    	Robot.climber.stop();		//sets the climber motor speed to 0
    }

    
    protected boolean isFinished() {
        return true;
    }

    
    protected void end() {
    	Robot.climber.holdLifter();
    }

   
    protected void interrupted() {
    }
}
