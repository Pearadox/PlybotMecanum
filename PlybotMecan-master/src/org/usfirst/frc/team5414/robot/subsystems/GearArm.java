package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArm extends Subsystem {

	private Spark arm;
	public GearArm() {
		super();
		arm = new Spark(RobotMap.PWMGearArm);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void raise() {
    	arm.set(RobotMap.armRaiseSpeed);
    }
    public void lower() {
    	arm.set(RobotMap.armLowerSpeed);
    }
}

