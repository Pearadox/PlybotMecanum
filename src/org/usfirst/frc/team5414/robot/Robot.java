
package org.usfirst.frc.team5414.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;

//import edu.wpi.first.wpilibj.
import java.util.*;
import org.opencv.core.Mat;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import org.usfirst.frc.team5414.robot.commands.AutonomousLeftSide;
import org.usfirst.frc.team5414.robot.commands.AutonomousMiddle;
import org.usfirst.frc.team5414.robot.commands.AutonomousRightSide;
import org.usfirst.frc.team5414.robot.subsystems.Climber;
import org.usfirst.frc.team5414.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5414.robot.subsystems.Electrical;
import org.usfirst.frc.team5414.robot.subsystems.GearArm;
import org.usfirst.frc.team5414.robot.subsystems.GearCollector;
import org.usfirst.frc.team5414.robot.subsystems.NavX;
import org.usfirst.frc.team5414.robot.subsystems.Servo1;
//import org.usfirst.frc.team5414.robot.subsystems.ShooterPID;
import org.usfirst.frc.team5414.robot.subsystems.WheelEncoder;

public class Robot extends IterativeRobot {
	
	public static Drivetrain drivetrain;
	public static Compressor compressor;
	public static NetworkTable table; 
	public static WheelEncoder encoder;
	public static OI oi;
	public static NavX navx;
	public static Climber climber;
	public static Electrical electrical;
	public static GearArm geararm;
	public static GearCollector gearcollector;
	public static REVDigitBoard revdigitboard;
	public static Servo1 servo1;
//	public static DigitalInput 
//	public static ShooterPID shootPID;
	Command autonomousCommand;
//	SendableChooser<Command> chooser = new SendableChooser<>();
	boolean currentButtonState=false;
    String test="";
    UsbCamera cam1;
    
    /**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		try{
			servo1 = new Servo1();
//			cam1 = new UsbCamera("cam1", 1); 
			CameraServer.getInstance().startAutomaticCapture(0);
			CameraServer.getInstance().startAutomaticCapture(1);
		} catch(Exception e){}
		revdigitboard = new REVDigitBoard();
		table = NetworkTable.getTable("GRIP/myContoursReport");
		geararm = new GearArm();
		gearcollector = new GearCollector();
		compressor = new Compressor(0);
//		shootPID = new ShooterPID();
		compressor.start();
		drivetrain = new Drivetrain();
		encoder = new WheelEncoder();
		climber = new Climber();
		electrical = new Electrical();
//		Robot.drivetrain.FullTraction();
		navx = new NavX();
//		shoot=new Wheel();
		oi = new OI();
//		for (double area:areas) 
//        {
//        	SmartDashboard.putNumber("Area", area);
//        }
//		chooser.addDefault("Default Auto", new ExampleCommand());
//		 chooser.addObject("My Auto", new MyAutoCommand());
//		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		revdigitboard.clear();
	}

	@Override
	public void disabledPeriodic() {
		double REVPot = revdigitboard.getPot(); //LEFT = .27 RIGHT = .25
		if(revdigitboard.getButtonA())
		{
			if(REVPot >= .26)
			{
				autonomousCommand = new AutonomousLeftSide();
				DriverStation.reportWarning("Autonomous mode set to: LEFT", true);
			}
			else
			{
				autonomousCommand = new AutonomousRightSide();
				DriverStation.reportWarning("Autonomous mode set to: RIGHT", true);
			}
		}
		if(revdigitboard.getButtonB())	
		{
			autonomousCommand = new AutonomousMiddle();
			DriverStation.reportWarning("Autonomous mode set to: MIDDLE", true);
		}
		
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		navx.zeroYaw();
		navx.reset();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	
//	double maxX = 9001;
//	double maxY = 9001;
//	double maxT = 9001;
	
	@Override
	public void teleopPeriodic() {
		
//		if(maxX == 9001) maxX = OI.stick.getRawAxis(0);
//		if(maxY == 9001) maxY = OI.stick.getRawAxis(1);
//		if(maxT == 9001) maxT = OI.stick.getRawAxis(2);
//		maxX = Math.max(Math.abs(maxX), Math.abs(OI.stick.getRawAxis(0)));
//		maxY = Math.max(Math.abs(maxY), Math.abs(OI.stick.getRawAxis(1)));
//		maxT = Math.max(Math.abs(maxT), Math.abs(OI.stick.getRawAxis(2)));
//		SmartDashboard.putNumber("Joystick X", OI.stick.getX());
//		SmartDashboard.putNumber("Joystick Y", OI.stick.getY());
//		SmartDashboard.putNumber("Joystick Twist", OI.stick.getTwist());
//		SmartDashboard.putNumber("max X", maxX);
//		SmartDashboard.putNumber("max Y", maxY);
//		SmartDashboard.putNumber("max Twist", maxT);
//		SmartDashboard.putNumber("servangle", ServoTest.serv.getAngle());
		
		double[] areas = table.getNumberArray("area", new double[0]);
		Scheduler.getInstance().run();
		currentButtonState = oi.getJoystick1().getRawButton(5);
    	
    		try {
				SmartDashboard.putString("Area: ", Arrays.toString(table.getNumberArray("area", new double[0])));
				SmartDashboard.putBoolean("Errored", false);
				SmartDashboard.putString("CenterX: ", Arrays.toString(table.getNumberArray("centerX", new double[0]))); 
				SmartDashboard.putString("CenterY", Arrays.toString(table.getNumberArray("centerY",new double[0])));
			} catch (Exception e) {
				SmartDashboard.putBoolean("Errored", true);
			}

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	public static boolean containsArea(){
		double[] thing  = table.getNumberArray("area", new double[0]);
//		SmartDashboard.putString("areaThing", Arrays.toString(thing));
//		SmartDashboard.putNumber("Thing length", thing.length);
		return thing.length==0;
	}
	public static double centerX(){
		double x = 0;
		double[] center = table.getNumberArray("centerX", new double[0]);
		if(center.length==1){
			x = center[0];
		}
		return x;
	}
}
