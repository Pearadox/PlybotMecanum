package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {

	private Spark gearwheels;
	
	public GearCollector() {
		super();
		gearwheels = new Spark(RobotMap.PWMGearWheels); 
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }
    
    public void StartIntake() {
    	gearwheels.set(RobotMap.intakeSpeed);
    }
    public void StartOuttake() {
    	gearwheels.set(RobotMap.outtakeSpeed);
    }
    
    public void Stop() {
    	gearwheels.set(0);
    }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


