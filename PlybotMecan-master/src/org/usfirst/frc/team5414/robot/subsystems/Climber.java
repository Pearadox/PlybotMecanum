package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private SpeedController lifter;
	public Climber() {
		super();
//		lifter = new Victor(RobotMap.PWMlifter);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void holdLifter() {
    	lifter.set(RobotMap.lifterholdspeed);
    // 3.8 volts @ 20 amps holds lifter
    	// f = .3333 * 1023 / 20000 = .017033
    	
    }
    
    public void lift() {
    	lifter.set(RobotMap.lifterLiftSpeed);
    }
    
    public void stop() {
    	lifter.set(0.0);
    }
   // public void lower() {
   // 	lifter.set(RobotMap.lifterLowerSpeed);
  ///  }
}


