package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem{
	
	private CANTalon shooterwheels;
	
	
	public Shooter() {
		super();
		shooterwheels = new CANTalon(0);
	}
//     Put methods for controlling this subsystem
//     here. Call these from Commands.

    public void initDefaultCommand() {
    }
    
    public void shoot() {
    	
    	shooterwheels.set(RobotMap.shootSpeed);
    }
}



