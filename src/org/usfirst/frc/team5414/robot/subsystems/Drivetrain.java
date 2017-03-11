package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;
import org.usfirst.frc.team5414.robot.commands.DrivewithJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	private SpeedController rightf_motor, rightb_motor, leftf_motor, leftb_motor;
//	private CANTalon leftf_motor, leftb_motor;
    private RobotDrive drive;
    private Encoder encoderFR; 
    private Encoder encoderBR; 
    private Encoder encoderBL; 
    private Encoder encoderFL; 
    PIDController motorController;

	Solenoid LightSol;
	public static DoubleSolenoid FL,FR,BL,BR; 
    
    public Drivetrain()
    {
    	encoderFR = new Encoder(RobotMap.DIOencoderFRa, RobotMap.DIOencoderFRb, false, Encoder.EncodingType.k4X);
    	encoderBR = new Encoder(RobotMap.DIOencoderBRa, RobotMap.DIOencoderBRb, false, Encoder.EncodingType.k4X);
    	encoderBL = new Encoder(RobotMap.DIOencoderBLa, RobotMap.DIOencoderBLb, false, Encoder.EncodingType.k4X);
    	encoderFL = new Encoder(RobotMap.DIOencoderFLa, RobotMap.DIOencoderFLb, false, Encoder.EncodingType.k4X);
    	
    	encoderFR.reset();
    	encoderBR.reset();
    	encoderBL.reset();
    	encoderFL.reset();
    	
    	FL = new DoubleSolenoid(RobotMap.SolenoidFLa , RobotMap.SolenoidFLb );
    	FR = new DoubleSolenoid(RobotMap.SolenoidFRa,RobotMap.SolenoidFRb);
    	BL = new DoubleSolenoid(RobotMap.SolenoidBLa,RobotMap.SolenoidBLb);
    	BR = new DoubleSolenoid(RobotMap.SolenoidBRa,RobotMap.SolenoidBRb);

    	FL.set(DoubleSolenoid.Value.kForward);
    	FR.set(DoubleSolenoid.Value.kForward);
    	BL.set(DoubleSolenoid.Value.kForward);
    	BR.set(DoubleSolenoid.Value.kForward);

		leftb_motor = new Victor(RobotMap.PWMLeftBackMotor);
		leftf_motor = new Victor(RobotMap.PWMLeftFrontMotor);
		rightb_motor = new Victor(RobotMap.PWMRightBackMotor);
		rightf_motor = new Victor(RobotMap.PWMRightFrontMotor);
		leftf_motor.setInverted(Boolean.FALSE);
		leftb_motor.setInverted(Boolean.FALSE);
		rightf_motor.setInverted(Boolean.TRUE);
		rightb_motor.setInverted(Boolean.TRUE);
		drive = new RobotDrive(leftf_motor, leftb_motor, rightf_motor, rightb_motor);
		
//		LightSol = new Solenoid(RobotMap.LightSolenoid);
    }
    
    public int getEncoderBL()
    {
    	return -encoderBL.get();
    }
    
    public int getEncoderBR()
    {
    	return encoderBR.get();
    }
    
    public void zeroEncoderBL()
    {
    	encoderBL.reset();
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DrivewithJoystick());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
  
    
    public void arcadeDrive(Joystick stick){
    	SmartDashboard.putString("Drivemode", "Arcade"); //Displays the driving mode
    	double ax1; 	//X-axis of motion for robot
    	double ax2;		//Y-axis of motion for robot
    	
    	if(Math.abs(stick.getRawAxis(2)) < .087)	//Setting deadzone for the x-axis
    	{
    		ax1 = 0;
    	}
    	else
    	{
    		ax1 = stick.getRawAxis(2);
    	}
    	if(Math.abs(stick.getRawAxis(1)) < .18)		//Setting deazone for the y-axis
    	{
    		ax2 = 0;
    	}
    	else
    	{
    		ax2 = stick.getRawAxis(1);
    	}
    	
    	boolean ax1n = false, ax2n = false;
    	if(ax1 < 0) ax1n = true;
    	if(ax2 < 0) ax2n = true;
    	ax1 *= ax1; ax2 *= ax2; //scaling the output of the joystick to fine tune the end result
    	if(ax1n) ax1 *= -1;
    	if(ax2n) ax2 *= -1;
    	SmartDashboard.putNumber("EncoderBR", encoderBR.get());
    	SmartDashboard.putNumber("EncoderFR", encoderFR.get());
    	SmartDashboard.putNumber("EncoderFL", encoderFL.get());
    	SmartDashboard.putNumber("EncoderBL", encoderBL.get());
    	drive.arcadeDrive(-ax1,-ax2);
    }
    
    public void toggleLight()
    {
    	LightSol.set(!LightSol.get());
    }
    
    public void enableLight()
    {
    	LightSol.set(true);
    }
    
    public void disableLight()
    {
    	LightSol.set(false);
    }
    public void FullTraction(){

    	FL.set(DoubleSolenoid.Value.kReverse);		//this sets all of the solonoids to reverse so that tractions are engaged
    	FR.set(DoubleSolenoid.Value.kReverse);
    	BL.set(DoubleSolenoid.Value.kReverse);
    	BR.set(DoubleSolenoid.Value.kReverse);
    	
    } 
    public void FullButterfly(){

    	FL.set(DoubleSolenoid.Value.kForward);		//this sets all of the solonoids to full thrust, engaging the mecanum 
    	FR.set(DoubleSolenoid.Value.kForward);
    	BL.set(DoubleSolenoid.Value.kForward);
    	BR.set(DoubleSolenoid.Value.kForward);
    }
    public void HalfButterly(){
    	FL.set(DoubleSolenoid.Value.kForward);		//this code isnt used for mechanums, but for omnis, sets half of the solonoids to engage omni's
    	FR.set(DoubleSolenoid.Value.kForward);
    	BL.set(DoubleSolenoid.Value.kReverse);
    	BR.set(DoubleSolenoid.Value.kReverse);
    } 
    public void drive(double left, double right) {
    	double drivestraightconstant = 1; 
    	drive.tankDrive(left * drivestraightconstant, right);
    	
    }
    
    public void arcadeDrive(double throttle, double twist){
    	drive.arcadeDrive(throttle,twist);
    }
    
    public double getDistanceL()
	{
		return encoderBL.getDistance();
	}
	public double getDistanceR()
	{
		return encoderBR.getDistance();
	}
	public void reset()
	{
		encoderBL.reset();
		encoderBR.reset();
	}
	
    public void stop(){
    		drive.tankDrive(0,0);
    }	
    
    public void mecanumDrive(Joystick stick) {
    	SmartDashboard.putString("Drivemode", "Mecanum");  //publishing the drive mode to smartdashboard
    	double moveY; 	//X-axis of motion for robot
    	double Rotate;		//Rotation of motion for robot
    	
    	if(Math.abs(stick.getRawAxis(2)) < .37)	//Setting deadzone for the x-axis
    	{
    		Rotate = 0;
    	}
    	else
    	{
    		Rotate = stick.getRawAxis(2);
    	}
    	if(Math.abs(stick.getRawAxis(1)) < .18)		//Setting deazone for the y-axis
    	{
    		moveY = 0;
    	}
    	else
    	{
    		moveY = stick.getRawAxis(1);
    	}
    	
		double moveX = stick.getRawAxis(0);					//setting joystick values to the axis'
    	moveY = -moveY;
    	Rotate = -Rotate;
    	
    	int StrafeRight = 90;							//Sets POV values to variables 
    	int StrafeLeft = 270;
    	int MoveForward = 0;
    	int MoveBackward = 180;
    	
    	double FBFactor = 1;							//setting scaling factors for the POV, to change the speeds of each direction
    	double strafeFactor = 1;
    	double rotateFactor = 1.25;
    	
    	double countIterations = 0;						
    	double desiredHeading = 0;
    	
    	double moveSpeedPOV = .6;						//Speed of the POV directions 
    	
    	
    	
    	if(stick.getPOV() == StrafeRight){				//Checks POV direction of joystick. Sets movement values if true
    		moveX = moveSpeedPOV;
    		moveY = 0.0;
    		Rotate = 0.0;	
    	}
    	else if(stick.getPOV() == StrafeLeft){
    		moveX = -moveSpeedPOV;
    		moveY = 0.0;
    		Rotate = 0.0;	
    	}
    	else if(stick.getPOV() == MoveForward){
    		moveX = 0.0;
    		moveY = moveSpeedPOV;
    		Rotate = 0.0;	
    	}
    	else if(stick.getPOV() == MoveBackward){
    		moveX = 0.0;
    		moveY = -moveSpeedPOV;
    		Rotate = 0.0;	
    	}
    	
    	
    	
    	
    	if ((-0.2 < moveX) && (moveX < 0.2)) {			//declaring deadzones for mecanum 
			moveX = 0.0;
		}
		if ((-0.2 < moveY) && (moveY < 0.2)) {
			moveY = 0.0;
		}
		if ((-0.2 < Rotate) && (Rotate < 0.07)) {
			Rotate = 0.0;
		}
		
		
		
		moveX *= strafeFactor;							//scaling the movement factors 
		moveY *= FBFactor;
		Rotate *= rotateFactor;
		
		
		
		if ((-0.01 < Rotate) && (Rotate < 0.01)) {
			// Rotate is practically zero, so just set it to zero and
			// increment iterations
			Rotate = 0.0;
			countIterations++;
		} else {
			// Rotate is being commanded, so clear iteration counter
			countIterations = 0;
		}
		
		// preserve heading when recently stopped commanding rotations
				if (countIterations == 5) {
					desiredHeading = Robot.gyro.getYaw();
				} else if (countIterations > 5) {
					Rotate = (desiredHeading - Robot.gyro.getYaw()) / 40.0;
				}
				SmartDashboard.putNumber("EncoderBR", encoderBR.get());
		    	SmartDashboard.putNumber("EncoderFR", encoderFR.get());
		    	SmartDashboard.putNumber("EncoderFL", encoderFL.get());
		    	SmartDashboard.putNumber("EncoderBL", encoderBL.get());
				drive.mecanumDrive_Cartesian(moveX, moveY, Rotate,0);
	}	   	
}