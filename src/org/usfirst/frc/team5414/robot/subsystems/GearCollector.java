package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearCollector extends Subsystem {

	private Spark gearwheels;
//	private DigitalInput limitSwitch;
	
	public GearCollector() {
		super();
		gearwheels = new Spark(RobotMap.PWMGearWheels); 
//		limitSwitch = new DigitalInput(RobotMap.LimitInput);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.s

    public void initDefaultCommand() {
    }
    
    public void StartIntake() {
    	gearwheels.set(RobotMap.intakeSpeed);		//sets the speed for the Gear Collector wheels to intake
    }
    public void StartOuttake() {
    	gearwheels.set(RobotMap.outtakeSpeed);		//sets the speed for the Gear collector wheels to outake
    }
    public boolean isLimitSet(){
//    	SmartDashboard.putBoolean("Limit", limitSwitch.get());		//publishes condition of limit switch to the smartdashboard
    	return true;								// returns true or false depending on condition of switch
    }
   
    	
    public void Stop() {
    	gearwheels.set(0);		//sets the gear wheels speed to 0
    }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


