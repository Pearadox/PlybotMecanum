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
    

	
    public void initDefaultCommand() {
    	int absolutePosition = GearArm.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        GearArm.setEncPosition(absolutePosition);
        
        /* choose the sensor and sensor direction */
        GearArm.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        GearArm.reverseSensor(false);

        /* set the peak and nominal outputs, 12V means full */
        GearArm.configNominalOutputVoltage(+0f, -0f);
        GearArm.configPeakOutputVoltage(+4f, -4f);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        GearArm.setAllowableClosedLoopErr(RobotMap.ArmError); 
        GearArm.setProfile(RobotMap.ArmProfile);
        GearArm.setF(RobotMap.ArmkF);
        GearArm.setP(RobotMap.ArmkP);
        GearArm.setI(RobotMap.ArmkI); 
        GearArm.setD(RobotMap.ArmkD); 
    }
    public void setPosition(){
    	
    	double motorOutput = GearArm.getOutputVoltage()/GearArm.getBusVoltage();
		printer.append("\tout:");
		printer.append(motorOutput);
        printer.append("\tpos:");
        printer.append(GearArm.getPosition() );
    	
    		/* Position mode - button just pressed */
        	targetPositionRotations = RobotMap.armRaiseSpeed * 1; /* 50 Rotations in either direction */
        	GearArm.changeControlMode(TalonControlMode.Position);
        	GearArm.set(targetPositionRotations); /* 50 rotations in either direction */
    	
    	if( GearArm.getControlMode() == TalonControlMode.Position) {
        	/* append more signals to print when in speed mode. */
        	printer.append("\terrNative:");
        	printer.append(GearArm.getClosedLoopError());
        	printer.append("\ttrg:");
        	printer.append(targetPositionRotations);
        }
    	if(++counter >= 10) {
        	counter = 0;
        	System.out.println(printer.toString());
        }
    	printer.setLength(0);
    }
    public void setTalonMode(){
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void raise() {
    	GearArm.set(RobotMap.armRaiseSpeed);			//sets the raising speed to the gear collector
    }
    public void lower() {

    	double motorOutput = GearArm.getOutputVoltage()/GearArm.getBusVoltage();
		printer.append("\tout:");
		printer.append(motorOutput);
        printer.append("\tpos:");
        printer.append(GearArm.getPosition() );
    	
    		/* Position mode - button just pressed */
        	targetPositionRotations = RobotMap.armLowerSpeed * .8; /* 50 Rotations in either direction */
        	GearArm.changeControlMode(TalonControlMode.Position);
        	GearArm.set(targetPositionRotations); /* 50 rotations in either direction */
    	
    	if( GearArm.getControlMode() == TalonControlMode.Position) {
        	/* append more signals to print when in speed mode. */
        	printer.append("\terrNative:");
        	printer.append(GearArm.getClosedLoopError());
        	printer.append("\ttrg:");
        	printer.append(targetPositionRotations);
        }
    	if(++counter >= 10) {
        	counter = 0;
        	System.out.println(printer.toString());
        }
    	printer.setLength(0);		//sets the lowering speed of the collector
    }
    public void stop() {
    	GearArm.set(0);									//sets the raising the arm speed to 0
    }
}

