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
	
	Encoder encoderL, encoderR;
	
	public WheelEncoder()
	{
//		encoderL = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
//		encoderR = new Encoder(2, 3, false, Encoder.EncodingType.k2X);
		
	}
	 
	public double getDistanceL()
	{
		return encoderL.getDistance();
	}
	public double getDistanceR()
	{
		return encoderR.getDistance();
	}
	
	public double getRateL()
	{
		return encoderL.getRate();
	}
	
	public double getRateR()
	{
		return encoderR.getRate();
	}

	public void reset()
	{
		encoderL.reset();
		encoderR.reset();
	}
	
	public int getL()
	{
		return encoderL.get();
	}
	public int getR()
	{
		return encoderR.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

