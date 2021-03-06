
package org.usfirst.frc.team5414.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import java.util.*;
import org.opencv.core.Mat;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import org.usfirst.frc.team5414.robot.commands.AutoLeftGearVision;
import org.usfirst.frc.team5414.robot.commands.AutoRightGearVision;
import org.usfirst.frc.team5414.robot.commands.AutoMidGearVision;
import org.usfirst.frc.team5414.robot.commands.EncoderDrives;
import org.usfirst.frc.team5414.robot.commands.RaiseArm;
import org.usfirst.frc.team5414.robot.subsystems.Climber;
import org.usfirst.frc.team5414.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5414.robot.subsystems.Electrical;
import org.usfirst.frc.team5414.robot.subsystems.GearArm;
import org.usfirst.frc.team5414.robot.subsystems.GearCollector;
import org.usfirst.frc.team5414.robot.subsystems.Gyro;
import org.usfirst.frc.team5414.robot.subsystems.Servo1;
import org.usfirst.frc.team5414.robot.subsystems.Shooter;
import org.usfirst.frc.team5414.robot.subsystems.WheelEncoder;

//import com.autodesk.bxd.EmulatorControl;

public class Robot extends IterativeRobot {
	
	public static Drivetrain drivetrain;
	public static Compressor compressor;
	public static NetworkTable table; 
	public static WheelEncoder encoder;
	public static OI oi;
	public static Gyro gyro;
	public static Climber climber;
	public static Electrical electrical;
	public static GearArm geararm;
	public static GearCollector gearcollector;
	public static REVDigitBoard revdigitboard;
	public static Servo1 servo1;
	public static Preferences prefs;
//	public static DigitalInput 
	public static Shooter shooter;
	Command autonomousCommand;
	SendableChooser<Command> AutoChooser = new SendableChooser<>();
	boolean currentButtonState=false;
    String test="";
    UsbCamera cam1;
    
    /**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		try{
			//Not sure what this is before - if this was just for testing, we should remove it.
			//Need to have the servos in the climbing subsystem
			servo1 = new Servo1();
//			cam1 = new UsbCamera("cam0", 0);
//			cam1.setResolution(320	, 270);
//			CameraServer.getInstance().startAutomaticCapture(cam1);
//			CameraServer.getInstance().startAutomaticCapture(1);
		} catch(Exception e){}
		//Should probably remove the digiboard as we are unlikely to use it. 
		revdigitboard = new REVDigitBoard();
		table = NetworkTable.getTable("GRIP/myContoursReport");
		geararm = new GearArm();
		gearcollector = new GearCollector();
		compressor = new Compressor(0);
		shooter = new Shooter();
		compressor.start();
		drivetrain = new Drivetrain();
		encoder = new WheelEncoder();
		climber = new Climber();
		electrical = new Electrical();
//		Robot.drivetrain.FullTraction();
		gyro = new Gyro();
//		shoot=new Wheel();
		oi = new OI();
		AutoChooser.addDefault("Left Side", new AutoLeftGearVision());
		
		//These can't all be defaults. It should become AutoChooser.addObject();
		/** Should add a command that just drives forward for a set amount of second 
		  * so that we have a auto mode that gets us the 5 pt bonus for driving forward
		  */
		AutoChooser.addDefault("Middle", new AutoRightGearVision());
		AutoChooser.addDefault("Right Side", new AutoMidGearVision());
		
		//Should also add an autonomous mode that does nothing. Just in Case
		SmartDashboard.putData("Autonomous Mode", AutoChooser);
		prefs = Preferences.getInstance();
		prefs.putString("Areas", "172,272,372,472");
		prefs.putString("RPMs", "4000,3500,3000,2500");
		prefs.putDouble("GyrokP", RobotMap.GyrokP);
		prefs.putDouble("GyrokI", RobotMap.GyrokI);
		prefs.putDouble("GyrokD", RobotMap.GyrokD);
		getAreas();
		getRPMs();
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
		climber.stop();
	}

	@Override
	public void disabledPeriodic() {
//		double REVPot = revdigitboard.getPot(); //LEFT = .27 RIGHT = .25
//		if(revdigitboard.getButtonA())
//		{
//			if(REVPot >= .26)
//			{
//				autonomousCommand = new AutonomousLeftSide();
//				DriverStation.reportWarning("Autonomous mode set to: LEFT", true);
//			}
//			else
//			{
//				autonomousCommand = new AutoRightGear();
//				DriverStation.reportWarning("Autonomous mode set to: RIGHT", true);
//			}
//		}
//		if(revdigitboard.getButtonB())	
//		{
//			autonomousCommand = new AutonomousMiddle();
//			DriverStation.reportWarning("Autonomous mode set to: MIDDLE", true);
//		}
		
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		gyro.reset();
		
		//This currently ignores anything chosen by the smartDashboard and would just drive forward. 
		autonomousCommand = (Command) new EncoderDrives(3.2);
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
		SmartDashboard.putString("Area", Arrays.toString(areas));
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
    		
    		SmartDashboard.putNumber("Gyro Angle", gyro.getYaw());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	public static boolean containsArea(){
		double[] thing  = table.getNumberArray(""
				+ "", new double[0]);
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
	
	public void getAreas()
	{
		prefs = Preferences.getInstance();
		String raw = prefs.getString("Areas", "");
		ArrayList<Double> toReturn = new ArrayList<Double>();
		StringTokenizer st = new StringTokenizer(raw, ",");
		while(st.hasMoreTokens())
		{
			toReturn.add(Double.parseDouble(st.nextToken().trim()));
		}
		
		RobotMap.area = toReturn;
	}

	public void getRPMs()
	{
		prefs = Preferences.getInstance();
		String raw = prefs.getString("RPMs", "");
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(raw, ",");
		while(st.hasMoreTokens())
		{
			toReturn.add(Integer.parseInt(st.nextToken().trim()));
		}
		RobotMap.rpm = toReturn;
	}
}
