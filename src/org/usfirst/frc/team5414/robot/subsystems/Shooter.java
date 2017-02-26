package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
/**
 *
 */
public class Shooter extends Subsystem {

	CANTalon talon;

    public void initDefaultCommand() {
        
    	talon = new CANTalon(1);
    	talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	talon.reverseSensor(false);
    	talon.configEncoderCodesPerRev(20);
    	talon.configNominalOutputVoltage(+0.0f, -0.0f);
    	talon.configPeakOutputVoltage(+12.0f, 0.0f);
    	talon.setProfile(0);
    	talon.setF(RobotMap.ShooterF);
    	talon.setP(RobotMap.ShooterkP);
    	talon.setI(RobotMap.ShooterkI);
    	talon.setD(RobotMap.ShooterkD);
    	talon.changeControlMode(TalonControlMode.Speed);
    	
    }
    
    public void shoot(double speed)
    {
    	talon.set(speed);
    }
    
    public void stop()
    {
    	talon.set(0);
    }
}

