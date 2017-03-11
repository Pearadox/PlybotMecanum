package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;
import org.usfirst.frc.team5414.robot.commands.ClimberLimitSwitch;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class Climber extends Subsystem {

	private SpeedController lifter;
	private DigitalInput limit; 
	public Climber() {
		super();
		lifter = new Victor(RobotMap.PWMlifter);
		limit = new DigitalInput(RobotMap.DIOClimberLimit);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new ClimberLimitSwitch());
    }
    
    public boolean isLimitSet(){
    	SmartDashboard.putBoolean("ClimberLimit", limit.get());		//publishes condition of limit switch to the smartdashboard
    	return limit.get();									// returns true or false depending on condition of switch
    }
    public void holdLifter() {
    	lifter.set(RobotMap.lifterholdspeed);		//sets the speed that the climber needs holds itself in place on the rope
    // 3.8 volts @ 20 amps holds lifter
    	// f = .3333 * 1023 / 20000 = .017033
    	
    }
    
    public void lift() {
    	lifter.set(RobotMap.lifterLiftSpeed);		//sets speed the robot needs to climb the rope
    }
    public void startPos() {
    	lifter.set(RobotMap.lifterLimitSwitchSpeed);
    }
    
    public void stop() {
    	lifter.set(0.0);							//sets the lifter speed to 0
    }
    public void lower() {
//        lifter.set(RobotMap.lifterLowerSpeed);
    }
}


