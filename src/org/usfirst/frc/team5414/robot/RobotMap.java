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
	public static int BtnHalf= 2;				//Activate half solonoids 
	public static int BtnLight= 3;				//button to turn on light
	public static int BtnVision = 4;			//starts vision code
	public static int BtnClimber = 5;			//climberbutton raise
	public static int BtnStop = 6;				//climber button stop, set motor 0
	public static int servo60 = 7;
	public static int encoderOn = 8;
	public static int BtnLower = 9;
	public static int servoSlow = 10;
	public static int BtnCollectGear = 11; 		//Will intake AND raise the assembly with limit switch
	public static int BtnCollectGearSpit = 12; 	//will lower the arm assembly at set speed no limitswitch
	
	public static double wheelDiameter = 6;
	public static int EncoderTicks = 1440;
	public static double lengthOfRotation = (wheelDiameter / 2) * (2 * Math.PI);
	public static double lengthOfTick = lengthOfRotation / EncoderTicks;
	
	//shooter PID loop
	public static double ShooterkP = 7.7;
	public static double ShooterkI = 0;
	public static double ShooterkD = 850;
	public static double ShooterF = 1.58;
	public static double ShooterRPM = 3000;
	
	//Closed-position loop for arm
	public static int ArmError = 205;
	public static int ArmProfile = 0;
	public static double ArmkF = 0;
	public static double ArmkP = 0.5;
	public static double ArmkI = 0;
	public static double ArmkD = 0;
	
	
	//Driving ports
	public static int PWMRightFrontMotor = 2;
	public static int PWMRightBackMotor = 3;
	public static int PWMLeftFrontMotor = 0;
	public static int PWMLeftBackMotor = 1;
	
	//Shooter port
	public static int PDPShooter = 3;
	
	//pwm for collector wheels & arms
	public static int PWMGearWheels = 4;
	public static int PWMGearArm = 0;
	
	//arm & collector speeds
	public static double armTargetRotations = .3;
	public static double armRaiseSpeed = 0.3;
	public static double armLowerSpeed = -0.2;
	public static double intakeSpeed = -1;
	public static double outtakeSpeed = .3;
	
	//climber stuffs
	public static int PWMlifter = 6;
	public static int PDPclimber = 2;
	public static int climberCurrentSpike = 64;
	public static double lifterholdspeed = -0.4;
	public static double lifterLiftSpeed = -1.0;
	
	//Autonomous settings
	public static double  goToPegSpeed= -.4;
	
	//Servo Ports
	public static int ServoPort = 8;  		//Set to correct Port for servos for climber
	public static int ServoPort2 = 9; 		//Set to correct Port for servos for climber
	public static int Servo1Angle = 90;	//set range of motion of the servos
	public static int Servo2Angle = 0;
	public static int Servo1Zero = 0;
	public static int Servo2Zero = 90;
	
	//Limit switch port
	public static int LimitInput = 10;  //Set limit to the digitalInput
	
	//encoder DIO ports
	public static int DIOencoderFRa = 8;
	public static int DIOencoderFRb = 9;
	public static int DIOencoderFLa = 4;
	public static int DIOencoderFLb = 5;
	public static int DIOencoderBRa = 6;
	public static int DIOencoderBRb = 7;
	public static int DIOencoderBLa = 2;
	public static int DIOencoderBLb = 3;
	
	//Shooter Lookup Table
	public static ArrayList<Double> distance = new ArrayList<Double>();
	public static ArrayList<Integer> rpm = new ArrayList<Integer>();
}
