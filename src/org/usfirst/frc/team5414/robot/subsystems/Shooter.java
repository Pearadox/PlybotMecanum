package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.*;

import org.usfirst.frc.team5414.robot.Robot;
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
    
    public void shoot()
    {
    	double[] areas = Robot.table.getNumberArray("area", new double[0]);
    	double area = 200;
    	try{
    		double a1 = areas[0];
    		double a2 = areas[1];
    		area = Math.max(a1, a2);
    	} catch(Exception e) {}
    	
//    	talon.set(speed);
    	SmartDashboard.putNumber("Shooter RPM", getRPM(area));
    	
    }
    
    public double getRPM(double CurrentArea)
    {
    	double RPM = 2500;
    	int index = 0;
    	ArrayList<Double> areas = RobotMap.area;
    	while(CurrentArea > areas.get(index) && index< areas.size()-1)
    	{
    		index++;
    	}
    	if(index == 0)
    	{
    		RPM = RobotMap.rpm.get(0);
    	}
    	else if(index == areas.size()-1)
    	{
    		RPM = RobotMap.rpm.get(areas.size()-1);
    	}
    	else
    	{
    		double low = areas.get(index - 1);
    		double high = areas.get(index);
    		double percent = (high-low)/high;
    		RPM = (percent * (CurrentArea - RobotMap.rpm.get(index-1)) + RobotMap.rpm.get(index-1));
//    		RPM = RobotMap.rpm.get(index);
    	}
    	return RPM;
    }
    
    public void stop()
    {
    	talon.set(0);
    }
}

