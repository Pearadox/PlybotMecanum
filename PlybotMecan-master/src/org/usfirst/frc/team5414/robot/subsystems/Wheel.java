package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Wheel extends Subsystem {
	private SpeedController wheel = new Victor(4);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FullSpeed(){
    	wheel.set(5);
    }
    
    public void StopWheel(){
    	wheel.set(0);
    }

	public void changeWheelMode() {
	//	wheel.changeControlMode(com.ctre.CANTalon.TalonControlMode.Voltage);
	}
}

