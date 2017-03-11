package org.usfirst.frc.team5414.robot.subsystems;



import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavX extends Subsystem implements PIDSource{

//	AHRS ahrs;
	AnalogGyro ahrs;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
//    	ahrs = new AHRS(SPI.Port.kMXP);
    	ahrs = new AnalogGyro(RobotMap.GyroPort);		//declaring gyro
    	ahrs.initGyro();				//intitializing the gyro
    }
    
    public double getYaw()
    {
    	return ahrs.getAngle();			//getting the angle of the gyro
    }
    
    public void zeroYaw()
    {
//    	ahrs.zeroYaw();
    	ahrs.reset();					//resetting the gyro
    }
    
    public void reset()
    {
    	ahrs.reset();					//resetting the gyro
    }

	public void setPIDSourceType(PIDSourceType pidSource) {
		
		
	}

	public PIDSourceType getPIDSourceType() {
		
		return PIDSourceType.kRate;		//returns the source type of the PID loop
	}
	
	int times = 0;
	
	public double pidGet() {
		return getYaw();				//returns the yaw of the AnalogGyro
	}   
}