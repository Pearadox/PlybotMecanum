package org.usfirst.frc.team5414.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team5414.robot.commands.ActivateTraction;
import org.usfirst.frc.team5414.robot.commands.Activatehalf;
import org.usfirst.frc.team5414.robot.commands.ClimberLimitSwitch;
//import org.usfirst.frc.team5414.robot.commands.ActivateButt;
//import org.usfirst.frc.team5414.robot.commands.ActivateTract;
//import org.usfirst.frc.team5414.robot.commands.Activatehalf;
import org.usfirst.frc.team5414.robot.commands.ClimberStop;
import org.usfirst.frc.team5414.robot.commands.CollectGear;
import org.usfirst.frc.team5414.robot.commands.DriveEncDist;
//import org.usfirst.frc.team5414.robot.commands.DriveEncDist;
import org.usfirst.frc.team5414.robot.commands.EncoderDrives;
import org.usfirst.frc.team5414.robot.commands.GearCollectCommand;
//import org.usfirst.frc.team5414.robot.commands.Align;
import org.usfirst.frc.team5414.robot.commands.GoToPeg;
import org.usfirst.frc.team5414.robot.commands.LiftingGroup;
import org.usfirst.frc.team5414.robot.commands.LowerArm;
import org.usfirst.frc.team5414.robot.commands.ScoringGearCommandGroup;
import org.usfirst.frc.team5414.robot.commands.RaiseArm;
import org.usfirst.frc.team5414.robot.commands.ServoClose;
import org.usfirst.frc.team5414.robot.commands.ServoCloseCommandGroup;
import org.usfirst.frc.team5414.robot.commands.ServoCommand;
import org.usfirst.frc.team5414.robot.commands.ServoIncremental;
import org.usfirst.frc.team5414.robot.commands.ServoZero;
import org.usfirst.frc.team5414.robot.commands.Shoot;
import org.usfirst.frc.team5414.robot.commands.SpitGear;
import org.usfirst.frc.team5414.robot.commands.ToggleLight;

import org.usfirst.frc.team5414.robot.commands.servoRotate;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	public static Joystick stick = new Joystick(0);
//	private Joystick stick2 = new Joystick(1);
	
	public OI(){

		
		JoystickButton half = new JoystickButton(stick, RobotMap.half);
		JoystickButton ActivateButterfly = new JoystickButton(stick, RobotMap.BtnButterfly);
		JoystickButton Climbing = new JoystickButton(stick, RobotMap.BtnClimber);
		JoystickButton ServoClose = new JoystickButton(stick, RobotMap.ServoClose);
		//		JoystickButton Shoot = new JoystickButton(stick,RobotMap.BtnShoot);
		JoystickButton ServoOpen = new JoystickButton(stick, RobotMap.BtnOpen);
//		JoystickButton TestingLimit = new JoystickButton(stick, RobotMap.BtnTestLimit);
		JoystickButton PlsStopClimbing = new JoystickButton(stick, RobotMap.BtnStop);
//		JoystickButton ToggleLight = new JoystickButton(stick, RobotMap.BtnLight);
		//		JoystickButton RobotAlign = new JoystickButton(stick, RobotMap.BtnVision);
		JoystickButton LowerArm = new JoystickButton(stick, RobotMap.BtnLower);
		JoystickButton RaiseArm = new JoystickButton(stick, RobotMap.BtnRaise);
		JoystickButton CollectGear = new JoystickButton(stick, RobotMap.BtnCollectGear);
		JoystickButton CollectGearSpitOut = new JoystickButton(stick, RobotMap.BtnCollectGearSpit);
		
		
		
//		JoystickButton servoSLowly = new JoystickButton(stick, RobotMap.servoSlow);
//		JoystickButton DriveOneRotation = new JoystickButton(stick, 12);
		
//		DriveOneRotation.whenPressed(new EncoderDrives(3.2));
		
		//Butterfly Drive commands for solonoids
		ActivateButterfly.whenPressed(new ActivateTraction());
		half.whenPressed(new Activatehalf());

//		Shoot.whenPressed(new Shoot());
		
		//Vision commands for light & Finding peg
//		RobotAlign.whenPressed(new GoToPeg());
//		ToggleLight.whenPressed(new ToggleLight());
//		TestingLimit.whenPressed(new ClimberLimitSwitch());
		
		//Code for Starting and stopping the climbing
		ServoOpen.whenPressed(new ServoZero());
		ServoClose.whenPressed(new ServoCloseCommandGroup());
//		servoSLowly.whenPressed(new ServoCommand());
		
		Climbing.whenPressed(new LiftingGroup());		
		PlsStopClimbing.whenPressed(new ClimberStop());		//Sets the climbing motor to 0
		
		//GearCollector intake & raise & lowering commands
		CollectGear.whenPressed(new GearCollectCommand()); 		//strats intake, stops when button released, then raises arm into limit switch
//		CollectGearSpitOut.whenPressed(new SpitGear());			//spits out gear
		CollectGearSpitOut.whenPressed(new DriveEncDist(15));
		LowerArm.whenPressed(new ScoringGearCommandGroup());
		RaiseArm.whenPressed(new RaiseArm());
	}
	public Joystick getJoystick1()
	{
		return stick;
	}
//	public Joystick getJoystick2()
//	{
//		return stick2;
//	}
	
	
	
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
