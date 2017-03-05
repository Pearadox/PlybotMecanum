package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.OI;
import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArm extends Subsystem {

	private CANTalon GearArm;
	private StringBuilder printer;
	private double targetPositionRotations;
	private int counter;
	
	
	public GearArm() {
		super();
		GearArm = new CANTalon(RobotMap.PWMGearArm);
		printer  = new StringBuilder();
		//declaring the location of the arm electrically
	}
    
	public double currentposition()
	{
		return GearArm.getPosition();
	}

	
    public void initDefaultCommand() {
//    	int absolutePosition = GearArm.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
    	GearArm.setPosition(0);
        /* choose the sensor and sensor direction */
        GearArm.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        GearArm.reverseSensor(false);

        /* set the peak and nominal outputs, 12V means full */
        GearArm.configNominalOutputVoltage(+0f, -0f);
        GearArm.configPeakOutputVoltage(+12f, -12f);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        GearArm.setAllowableClosedLoopErr(RobotMap.ArmError); 
        GearArm.setProfile(0);
        GearArm.setF(RobotMap.ArmkF);
        GearArm.setP(RobotMap.ArmkP);
        GearArm.setI(RobotMap.ArmkI); 
        GearArm.setD(RobotMap.ArmkD); 
    }
    public void setPosition(double rotations){
    	
    	double motorOutput = GearArm.getOutputVoltage()/GearArm.getBusVoltage(); 
        GearArm.changeControlMode(TalonControlMode.Position);
       	GearArm.set(targetPositionRotations); 
    }
    
    public void setTalonMode(){
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void raise() {
    	GearArm.changeControlMode(TalonControlMode.Position);
    	GearArm.set(0.25);			//sets the raising speed to the gear collector
    }
    public void lower() {

    	double motorOutput = GearArm.getOutputVoltage()/GearArm.getBusVoltage();
        	GearArm.changeControlMode(TalonControlMode.Position);
        	GearArm.set(0); 
    	
    }
}

