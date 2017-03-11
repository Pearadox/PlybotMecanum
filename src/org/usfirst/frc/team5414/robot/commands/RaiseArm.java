package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RaiseArm extends Command {

	double downPos = 0.0;
	
    public RaiseArm() {
    	requires(Robot.geararm);
    }

    
    protected void initialize() {
    	downPos = Robot.prefs.getDouble("DownPosition", RobotMap.ArmPositionUp);
    }

  
    protected void execute() {
    	SmartDashboard.putNumber("CurrentArmPosition", Robot.geararm.GearArm.getPulseWidthPosition());
    	Robot.geararm.setPosition(downPos);
    }

    
    protected boolean isFinished() {
//        return isTimedOut();		//stops the command when the command times out
    	return true;
    }

 
    protected void end() {
//    	Robot.geararm.lower(); 		//sets the geararm motor to 0 after the command is done exexuting
    }

    
    protected void interrupted() {
    }
}
