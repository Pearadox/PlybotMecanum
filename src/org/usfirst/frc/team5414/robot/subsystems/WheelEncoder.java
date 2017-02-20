package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WheelEncoder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Encoder encoder;
	
	public WheelEncoder()
	{
		encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
		
	}
	 
	public double getDistance()
	{
		return encoder.getDistance();
	}
	
	public double getRate()
	{
		return encoder.getRate();
	}

	public void reset()
	{
		encoder.reset();
	}
	public int get()
	{
		return encoder.get();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

