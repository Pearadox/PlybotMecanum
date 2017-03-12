package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LowerArm extends Command {


    public LowerArm() {
    	requires(Robot.geararm);
    }

    
    protected void initialize() {
    	Robot.geararm.setPosition(RobotMap.ArmPositionDown);
//    	System.out.println("LowerArm");
    }

  
    protected void execute() {
    	
    }

    
    protected boolean isFinished() {
//        return isTimedOut();		//stops the command when the command times out
    	return true;
    }

 
    protected void end() {
//    	System.out.println("Current: " + Robot.geararm.currentposition() + "Target: " + RobotMap.ArmPositionDown);
//    	Robot.geararm.lower(); 		//sets the geararm motor to 0 after the command is done exexuting
    }

    
    protected void interrupted() {
    }
}
