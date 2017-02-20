package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.commands.DrivewithJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 */
public class Drivetrain extends Subsystem {

	private SpeedController rightf_motor, rightb_motor, leftf_motor, leftb_motor;
//	private CANTalon leftf_motor, leftb_motor;
    private RobotDrive drive;

	Solenoid sol;
	public static DoubleSolenoid s1, s2,s3,s4; 
    
    public Drivetrain()
    {
    	
    	s1 = new DoubleSolenoid(0,1);
    	s3 = new DoubleSolenoid(2,3);
    	s2 = new DoubleSolenoid(4,5);
    	s4 = new DoubleSolenoid(6,7);

    	s1.set(DoubleSolenoid.Value.kReverse);
    	s2.set(DoubleSolenoid.Value.kForward);
    	s3.set(DoubleSolenoid.Value.kReverse);
    	s4.set(DoubleSolenoid.Value.kForward);

		leftb_motor = new Victor(0);
		leftf_motor = new Victor(1);
		rightb_motor = new Victor(2);
		rightf_motor = new Victor(3);
		leftf_motor.setInverted(Boolean.FALSE);
		leftb_motor.setInverted(Boolean.FALSE);
		rightf_motor.setInverted(Boolean.FALSE);
		rightb_motor.setInverted(Boolean.FALSE);
		drive = new RobotDrive(leftf_motor, leftb_motor, rightf_motor, rightb_motor);
    	
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DrivewithJoystick());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
  
    
//    public void arcadeDrive(Joystick stick){
//    	double ax1;
//    	double ax2;
//    	if(Math.abs(stick.getRawAxis(1)) < .087)
//    	{
//    		ax1 = 0;
//    	}
//    	else
//    	{
//    		ax1 = stick.getRawAxis(1);
//    	}
//    	if(Math.abs(stick.getRawAxis(2)) < .18)
//    	{
//    		ax2 = 0;
//    	}
//    	else
//    	{
//    		ax2 = stick.getRawAxis(2);
//    	}
//    	boolean ax1n = false, ax2n = false;
//    	if(ax1 < 0) ax1n = true;
//    	if(ax2 < 0) ax2n = true;
//    	ax1 *= ax1; ax2 *= ax2;
//    	if(ax1n) ax1 *= -1;
//    	if(ax2n) ax2 *= -1;
//    	drive.arcadeDrive(ax1,ax2);
//    }
    
    public void toggleLight()
    {
    	sol.set(!sol.get());
    }
    
    public void enableLight()
    {
    	sol.set(true);
    }
    
    public void disableLight()
    {
    	sol.set(false);
    }
    public void FullButterfly(){

    	s1.set(DoubleSolenoid.Value.kReverse);
    	s2.set(DoubleSolenoid.Value.kForward);
    	s3.set(DoubleSolenoid.Value.kReverse);
    	s4.set(DoubleSolenoid.Value.kForward);
    	
    	s1.set(DoubleSolenoid.Value.kForward);
    	s2.set(DoubleSolenoid.Value.kForward);
    	s3.set(DoubleSolenoid.Value.kReverse);
    	s4.set(DoubleSolenoid.Value.kReverse);
    } 
    public void FullTraction(){

    	s1.set(DoubleSolenoid.Value.kForward);
    	s2.set(DoubleSolenoid.Value.kReverse);
    	s3.set(DoubleSolenoid.Value.kForward);
    	s4.set(DoubleSolenoid.Value.kReverse);
    }
    public void HalfButterly(){
    	s1.set(DoubleSolenoid.Value.kForward);
    	s2.set(DoubleSolenoid.Value.kForward);
    	s3.set(DoubleSolenoid.Value.kReverse);
    	s4.set(DoubleSolenoid.Value.kReverse);
    } 
    public void drive(double left, double right) {
    	
    	double drivestraightconstant = 1;
    	drive.tankDrive(left * drivestraightconstant, right);
    	
    }
    
    public void arcadeDrive(double throttle, double twist){
//    	drive.arcadeDrive(throttle,twist);
    }
    
    
    
    public void stop(){
    		drive.tankDrive(0,0);
    }	
    
public void mecanumDrive(Joystick stick) {
		
		double ax0;
    	double ax1;
    	double ax2;
    	if(Math.abs(stick.getRawAxis(0)) < .168)
    	{	
    		ax0 = 0;
    	}
    	else
    	{
    		ax0 = stick.getRawAxis(0);
    	}
    	
    	if(Math.abs(stick.getRawAxis(1)) < .087)
    	{
    		ax1 = 0;
    	}
    	else
    	{
    		ax1 = stick.getRawAxis(1);
    	}
    	
    	if(Math.abs(stick.getRawAxis(2)) < .18)
    	{
    		ax2 = 0;
    	}
    	else
    	{
    		ax2 = stick.getRawAxis(2);
    	}
    	
		drive.mecanumDrive_Cartesian(ax0, ax1, ax2, 0);
		
	}	
    	
}

