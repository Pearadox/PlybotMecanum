package org.usfirst.frc.team5414.robot;

import java.util.*;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = s1;
	// public static int rightMotor = 2;

	//Buttons for Joystick
	public static int BtnButterfly= 1;			//activates all butterfly wheels
	public static int BtnClimber = 2;
	public static int ServoClose = 3;
	public static int BtnOpen = 4;
	public static int half = 5;
	public static int BtnStop = 6;	
	
	public static int BtnLower = 9;
	public static int BtnRaise = 10;
	
	public static int BtnCollectGear = 11; 		
	public static int BtnCollectGearSpit = 12; 	
	//***clean****
	
	
	public static double wheelDiameter = 4.5 / 12;
	public static final double compBotEnc = 128;
	public static final int practiceBotEnc = 1440;
	public static int LightSolenoid = 0;
//	public static double EncoderTicks = compBotEnc / 4 * 26 / 42 * 118 / 100;					//make sure to swap these values later
	public static int EncoderTicks = 128;
	public static double EncoderTicksMechanum = compBotEnc / 4 * 26 / 16 * 118 / 100;
	public static double Circumference = (wheelDiameter * Math.PI);
	public static double LengthPerTick = Circumference / EncoderTicks; // this is only roughly true for traction wheels
	
	//shooter PID loop
	public static int shooterTalon = 1;
	public static double ShooterkP = 7.7;
	public static double ShooterkI = 0;
	public static double ShooterkD = 850;
	public static double ShooterF = 1.58;
	public static double ShooterRPM = 3000;
	
	//Closed-position loop for arm
	public static int ArmError = 0;
	public static int ArmProfile = 0;
	public static double ArmkF = 0;
	public static double ArmkP = 5;
	public static double ArmkI = 0.0002;
	public static double ArmkD = 130;
	
	//GyroPort
	public static int GyroPort = 0;
	
	
	//Driving ports
	public static int PWMRightFrontMotor = 2;
	public static int PWMRightBackMotor = 3;
	public static int PWMLeftFrontMotor = 0;
	public static int PWMLeftBackMotor = 1;
	
	//Shooter port
	public static int PDPShooter = 3;
	
	//pwm for collector wheels & arms
	public static int PWMGearWheels = 4;
	
	
	//arm & collector speeds
	public static double ArmPositionDown = .3;
	public static double ArmPositionUp = 0.06;
	public static double armTargetRotations = .3;
	public static double armRaiseSpeed= 0.3;
	public static double armLowerSpeed = -0.2;
	public static double intakeSpeed = -1;
	public static double outtakeSpeed = 1;
	
	//climber stuffs
	public static int PWMlifter = 6;
	
	public static int PDPclimber = 2;
	public static int climberCurrentSpike = 64;
	public static double lifterholdspeed = -0.4;
	public static double lifterLiftSpeed = -1.0;
	public static double lifterLimitSwitchSpeed = 1;
	
	//Autonomous settings
	public static double  goToPegSpeed= .7;
	
	//Servo Ports
	public static int ServoPort = 8;  		//Set to correct Port for servos for climber
	public static int ServoPort2 = 9; 		//Set to correct Port for servos for climber
	public static int Servo1AngleOpen = 155;	//set range of motion of the servos
	public static int Servo2AngleOpen = 60;
	public static int Servo1AngleClose = 35; 
	public static int Servo2AngleClose = 160;
	
	//Solenoid ports
	
	public static int SolenoidFLa = 3;
	public static int SolenoidFLb = 4;
	public static int SolenoidFRa = 2;
	public static int SolenoidFRb = 5;
	public static int SolenoidBRa = 0;
	public static int SolenoidBRb = 7;
	public static int SolenoidBLa = 1;
	public static int SolenoidBLb = 6;
	
	
	//Limit switch port
	public static int LimitInput = 10;  //Set limit to the digitalInput
	
	//DIO ports
	public static int DIOencoderFRa = 8;
	public static int DIOencoderFRb = 9;
	public static int DIOencoderFLa = 4;
	public static int DIOencoderFLb = 5;
	public static int DIOencoderBRa = 6;
	public static int DIOencoderBRb = 7;
	public static int DIOencoderBLa = 2;
	public static int DIOencoderBLb = 3;
	public static int DIOGearArm = 0;
	public static int DIOClimberLimit = 1;
	
	public static double GyrokP = 0.00005;
	public static double GyrokI = 0.00003;
	public static double GyrokD = 0.02;
	
	//Shooter Lookup Table
//	public static double[] area;
//	public static int[] rpm;
	public static ArrayList<Double> area = new ArrayList<Double>();
	public static ArrayList<Integer> rpm = new ArrayList<Integer>();
}
