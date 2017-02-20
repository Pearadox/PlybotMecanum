package org.usfirst.frc.team5414.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

//import org.usfirst.frc.team5414.robot.commands.ActivateButt;
//import org.usfirst.frc.team5414.robot.commands.ActivateTract;
//import org.usfirst.frc.team5414.robot.commands.Activatehalf;
import org.usfirst.frc.team5414.robot.commands.AutonomousLeftSide;
import org.usfirst.frc.team5414.robot.commands.ClimberStop;
import org.usfirst.frc.team5414.robot.commands.CollectGear;
//import org.usfirst.frc.team5414.robot.commands.Align;
import org.usfirst.frc.team5414.robot.commands.GoToPeg;
import org.usfirst.frc.team5414.robot.commands.LiftingGroup;
import org.usfirst.frc.team5414.robot.commands.ToggleLight;
import org.usfirst.frc.team5414.robot.commands.yolo;
import org.usfirst.frc.team5414.robot.commands.yolostop;

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

//		JoystickButton ActivateButterfly = new JoystickButton(stick, RobotMap.BtnButterfly);
		JoystickButton ToggleLight = new JoystickButton(stick, RobotMap.BtnLight);
//		JoystickButton ActivateHalf = new JoystickButton(stick, RobotMap.BtnHalf);
		JoystickButton RobotAlign = new JoystickButton(stick, RobotMap.BtnVision);
		JoystickButton Climbing = new JoystickButton(stick, RobotMap.BtnClimber);
		JoystickButton PlsStopClimbing = new JoystickButton(stick, RobotMap.BtnStop);
		JoystickButton CollectGear = new JoystickButton(stick, RobotMap.BtnCollectGear);

//		ActivateButterfly.whenPressed(new ActivateButt());
//		ActivateHalf.whenPressed(new Activatehalf());
//		ActivateButterfly.whenReleased(new ActivateButt());
//		ActivateHalf.whenReleased(new ActivateButt());
		RobotAlign.whenPressed(new GoToPeg());
		ToggleLight.whenPressed(new ToggleLight());
		Climbing.whenPressed(new LiftingGroup());
		PlsStopClimbing.whenPressed(new ClimberStop());
		CollectGear.whenPressed(new CollectGear());
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
