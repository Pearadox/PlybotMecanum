package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveEncDist extends Command implements PIDOutput{
	double initDistance;
	double distance;
	double originalAngle;
	double kP = 0.00005;
	double kI = 0.00003;
	double kD = 0.02;
	final double kToleranceDegrees = 0.0f;
	double speed = 0.5;
	Preferences prefs;
	PIDController twistpid;
	double PIDOut;
	
    public DriveEncDist(double d) {
    	distance = d / RobotMap.LengthPerTick;
    	requires(Robot.drivetrain);
    	requires(Robot.gyro);
    	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.FullButterfly();
    	prefs = Preferences.getInstance();
    	prefs.getDouble("kP", kP);
    	prefs.getDouble("kI", kI);
    	prefs.getDouble("kD", kD);
    	Robot.gyro.zeroYaw();
    	
    	originalAngle = Robot.gyro.getYaw();
    	initDistance = Robot.drivetrain.getEncoderBL();
    	twistpid = new PIDController(kP, kI, kD, Robot.gyro, this, .01);
    	twistpid.setInputRange(-360, 360);
    	twistpid.setOutputRange(-1.0, 1.0);
    	twistpid.setContinuous(true);
    	twistpid.setAbsoluteTolerance(kToleranceDegrees);
    	twistpid.setSetpoint(originalAngle);
    	twistpid.enable();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double changeInAngle = Robot.gyro.getYaw()-originalAngle;
    	if(Robot.drivetrain.getEncoderBL() < (distance + initDistance))
    	{
    		Robot.drivetrain.arcadeDrive(-1*changeInAngle*kP,.7);
    	}
//    	kP = prefs.getDouble("Drive kP", kP);
//    	kI = prefs.getDouble("Drive kI", kI);
//    	kD = prefs.getDouble("Drive kD", kD);
//    	speed = prefs.getDouble("Speed", speed);
//    	SmartDashboard.putNumber("(prefs) Drive kP", kP);
//    	SmartDashboard.putNumber("(prefs) Drive kI", kI);
//    	SmartDashboard.putNumber("(prefs) Drive kD", kD);
//    	SmartDashboard.putNumber("(prefs)", speed);
    	SmartDashboard.putNumber("Difference In Angle", Robot.gyro.getYaw() - originalAngle);
//    	System.out.println("DRIVE");
//    	twistpid.setPID(kP, kI, kD);
//    	twistpid.setSetpoint(originalAngle);
//    	twistpid.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.drivetrain.getEncoderBL() >= initDistance + distance){
    		return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	twistpid.disable();
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	twistpid.disable();
    	end();
    }

	int times = 0;
	public void pidWrite(double output) {		
		PIDOut = output;
	}
}
