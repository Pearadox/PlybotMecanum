package org.usfirst.frc.team5414.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

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
    	ahrs = new AnalogGyro(0);
    	ahrs.initGyro();
    }
    
    public double getYaw()
    {
    	return ahrs.getAngle();
    }
    
    public void zeroYaw()
    {
//    	ahrs.zeroYaw();
    	ahrs.reset();
    }
    
    public void reset()
    {
    	ahrs.reset();
    }

	public void setPIDSourceType(PIDSourceType pidSource) {
		
		
	}

	public PIDSourceType getPIDSourceType() {
		
		return PIDSourceType.kRate;
	}
	
	int times = 0;
	
	public double pidGet() {
		return getYaw();
	}   
}