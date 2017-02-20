//package org.usfirst.frc.team5414.robot.subsystems;
//
//import org.usfirst.frc.team5414.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.Preferences;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
//
///**
// *
// */
//public class ShooterPID extends PIDSubsystem {
//
//	static Preferences prefs;
//	private double PIDOutput;
//	
//    // Initialize your subsystem here
//    public ShooterPID() {
//    	super("Shooter", prefs.getDouble("Shooter kP", RobotMap.ShooterkP), 
//    			prefs.getDouble("Shooter kI", RobotMap.ShooterkI), 
//    			prefs.getDouble("Shooter kD", RobotMap.ShooterkD));
//        
//    	setSetpoint(prefs.getDouble("Shooter Speed",RobotMap.shootSpeed));
//    	enable();
//    }
//
//    public void initDefaultCommand() {
//    }
//
//    protected double returnPIDInput() {
//        // Return Talon Speed
//        return 0.0;
//    }
//
//    protected void usePIDOutput(double output) {
//        PIDOutput = output;
//    }
//    
//    public double getPIDOutput()
//    {
//    	return PIDOutput;
//    }
//}
