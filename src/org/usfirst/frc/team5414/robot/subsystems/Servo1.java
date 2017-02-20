package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Servo1 extends Subsystem {

    public Servo servo,servo2;

	public void initDefaultCommand() {
        servo = new Servo(RobotMap.ServoPort);
        servo2 = new Servo(RobotMap.ServoPort2);//DON'T FORGET TO CHANGE PORT #!
    }
	
	public void setAngle(double degrees)
	{
		servo.setAngle(RobotMap.ServoDegrees);		//may have to inverse depending on which servo is which
		servo2.setAngle(-RobotMap.ServoDegrees);
	}
	
	public void Zero()
	{
		servo.setAngle(0);							//sets the angle of both of the gyros equal to 0. Essentially just resets the gyro
		servo2.setAngle(0);
	}
	
}

