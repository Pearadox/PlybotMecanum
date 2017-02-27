package org.usfirst.frc.team5414.robot.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetShooterValues extends Command {

    public GetShooterValues() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
			Scanner input = new Scanner(new File("ShooterLookupTable.dat"));
			input.nextLine();
			while(input.hasNextLine())
			{
				RobotMap.distance.add(input.nextDouble());
				RobotMap.rpm.add(input.nextInt());
			}
		} catch (FileNotFoundException e) {DriverStation.reportWarning("SHOOTER FILE ERROR", true);}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
