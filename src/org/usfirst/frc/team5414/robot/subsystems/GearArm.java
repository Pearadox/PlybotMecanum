package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArm extends Subsystem {

	public CANTalon GearArm;
	
	
	public GearArm() {
		super();
		GearArm = new CANTalon(RobotMap.DIOGearArm);
		//declaring the location of the arm electrically
	}
    
	public double currentposition()
	{
		return GearArm.getPosition();
	}

	
    public void initDefaultCommand() {
    	GearArm.setPosition(0);
        GearArm.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        GearArm.reverseSensor(false);
        GearArm.configNominalOutputVoltage(+0f, -0f);
        GearArm.configPeakOutputVoltage(+12f, -12f);
        GearArm.setAllowableClosedLoopErr(RobotMap.ArmError); 
        GearArm.setProfile(0);
        GearArm.setF(RobotMap.ArmkF);
        GearArm.setP(RobotMap.ArmkP);
        GearArm.setI(RobotMap.ArmkI); 
        GearArm.setD(RobotMap.ArmkD); 
    }
    public void setPosition(double targetPositionRotations){
    	
        GearArm.changeControlMode(TalonControlMode.Position);
       	GearArm.set(targetPositionRotations); 
    }
    
    public void setTalonMode(){
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void raise(double upPos) {
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(-0.3);			//sets the raising speed to the gear collector
    }
    public void lower(double downPos) {
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(0.3);
    }
    public void stop() {
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(0);
    }
}

