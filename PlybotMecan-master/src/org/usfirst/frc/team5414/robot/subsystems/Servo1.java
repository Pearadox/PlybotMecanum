package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Servo1 extends Subsystem {

    public Servo servo;

	public void initDefaultCommand() {
        servo = new Servo(9); //DON'T FORGET TO CHANGE PORT #!
    }
	
	public void setAngle(double degrees)
	{
		servo.setAngle(degrees);
	}
	
	public void Zero()
	{
		servo.setAngle(0);
	}
	
}

