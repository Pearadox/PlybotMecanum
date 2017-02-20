package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Electrical extends Subsystem {
    
	PowerDistributionPanel pdp = new PowerDistributionPanel();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new getCurrents_Command());
    }
    public void putCurrent(){
//    	double triggerCurrent = pdp.getCurrent(1);
//    	double intakeCurrent = pdp.getCurrent(0);
//    	double collectorCurrent = pdp.getCurrent(2);
//    	double wheelCurrent = pdp.getCurrent(3);
//    	
//    	SmartDashboard.putNumber("Trigger Current", triggerCurrent);
//    	SmartDashboard.putNumber("Intake Current", intakeCurrent);
//    	SmartDashboard.putNumber("Collector Current", collectorCurrent);
//    	SmartDashboard.putNumber("Wheel Current", wheelCurrent);
//    	
    	}
    
    public double getClimberCurrent() {
    	return pdp.getCurrent(RobotMap.PDPclimber);
    }  
}