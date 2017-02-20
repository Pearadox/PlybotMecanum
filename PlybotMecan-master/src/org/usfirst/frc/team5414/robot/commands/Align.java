// 	package org.usfirst.frc.team5414.robot.commands;
//	
//	import edu.wpi.first.wpilibj.command.Command;
//	
//	import java.util.Arrays;
//	
//	import org.usfirst.frc.team5414.robot.Robot;
//	import org.usfirst.frc.team5414.robot.RobotMap;
//	
//	import edu.wpi.first.wpilibj.Preferences;
//	import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//	
//	/**
//	 *
//	 */
//	public class Align extends Command {
//	    	double error = 0;
//	     	double max = 0;
//	    	int maxind = 0;
//	    	double centerX = 0;
//	       	double LeftPanel = 0;
//	       	double RightPanel = 0;
//	    	double centerY = 0;
//	    	int left = 0;
//	    	int right = 1;
//	    	double minspeed = .2;
//	    	double maxspeed = .4;
//	    	double cameraWidthInPixels = 320;
//	    	double speed = 0;
//	    	double kp = (maxspeed - minspeed)/129;
//	    public Align() {
//	        // Use requires() here to declare subsystem dependencies
//	        // eg. requires(chassis);
//	    	requires(Robot.drivetrain);
//	    	
//	    }
//	
//	    // Called just before this Command runs the first time
//	    protected void initialize() {
//	
//	    	
//	    }
//	   
//	    protected void PivotToTargets(){
//	    	try {
//	    		double[] CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
//	    		double cameraViewCenter = cameraWidthInPixels / 2;
//	    		//print blob #	
//	    		//check if 2 blobs 
//			    	if(CenterArray.length > 2){
//			    		SmartDashboard.putNumber("onn", 1);
//			    		//if > 2, we need to find the two blobs on the same plan, w similar area
//			    		return;
//			    	}
//			    	if(CenterArray.length < 2){
//					 	    if (CenterArray.length == 0){
//					    		Turn(left, maxspeed);
//					    		SmartDashboard.putString("Robot Moving", "searching");
//					    		
//					    	}
//					    	else if(CenterArray.length == 1){
//					    		if(CenterArray[0] < cameraViewCenter){
//					    			Turn(right, maxspeed);
//					    			SmartDashboard.putString("Robot Moving", "searching right");
//					    		}
//					    		else {
//					    			Turn(left, maxspeed);
//					    			SmartDashboard.putString("Robot Moving", "searching left");
//					    		}
//					    	}
//	
//			    	}
//			} catch (Exception e) {
//				SmartDashboard.putBoolean("Errored", true);
//			}
//	    }
//	    
//	    protected void DriveToTarget()
//	    {
//	    	Robot.drivetrain.drive(-.4, -.4);
//	    	SmartDashboard.putString("Robot Moving", "To Target");
//	    }
//	    
//	    protected void PivotToCenter()
//	    {
//	    	double cameraViewCenter = cameraWidthInPixels / 2;
//	    	double[] CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
//	    	
//	    	if(CenterArray[0] < CenterArray[1]){
//	    		LeftPanel = CenterArray[0];
//	    		RightPanel = CenterArray[1];
//	    	}
//	    	else{
//	    		LeftPanel = CenterArray[1];
//	    		RightPanel = CenterArray[0];
//	    	}
//	    	
//	    	double CenterPanels = ((LeftPanel + RightPanel)/2);
//	    	try {
//	        	SmartDashboard.putNumber("CenterPanels", CenterPanels);
//	        	SmartDashboard.putNumber("LeftPanel", CenterArray[0]);
//	        	SmartDashboard.putNumber("RightPanel", CenterArray[1]);
//			} catch (Exception e) {
//				SmartDashboard.putBoolean("Errored", true);
//			}
//	    	// requirement left blob left of center(min <cameraViewCenter), right blob right of center(max>cameraViewCenter)
//	//    	SmartDashboard.putNumber("onn", 2);
//	    	//int left = 0 turn
//	    	//int right = 1 turn
//	    	//int, speed
//	    	
//	//    	try {
//	//		//TODO: consider putting in a while loop	
//	//    			if(LeftPanel < cameraViewCenter && RightPanel > cameraViewCenter) {
//	//		    	 		Robot.drivetrain.drive(0, 0);
//	//		    	 		SmartDashboard.putString("Robot Moving", "Stopped");
//	//		    	}
//	//		  		else if(LeftPanel < cameraViewCenter && RightPanel < cameraViewCenter){
//	//		  			Turn(1, speed);
//	//		    			SmartDashboard.putString("Robot Moving", "move right");
//	//		    	}
//	//		    	else if(LeftPanel > cameraViewCenter && RightPanel > cameraViewCenter){
//	//		    		Turn(0, speed);
//	//		    			SmartDashboard.putString("Robot Moving", "move left");
//	//		    	}
//	//    	} catch (Exception e) {
//	//			SmartDashboard.putBoolean("Errored", true);
//	//		}
//	    	
//	    	
//	    	try {
//	    		SmartDashboard.putString("Robot Moving", "trying to center");
//	    		error = Math.abs(cameraViewCenter - CenterPanels);
//	    		speed = error * kp +.3;
//	    		if(speed > maxspeed) {
//	    			speed = maxspeed;
//	    		}
//	    		else if(speed < minspeed) {
//	    			speed = minspeed;
//	    		}
//	    			if(CenterPanels < cameraViewCenter) {
//	    				new Turn(1, speed);
//	    				SmartDashboard.putString("Robot Moving", "centering right");
//	    			}
//	    			else if(CenterPanels < cameraViewCenter) {
//	    				new Turn(0, speed);
//	    					SmartDashboard.putString("Robot Moving", "centering left");
//	    			}
//	    			else if(CenterPanels == cameraViewCenter) {
//	    				Robot.drivetrain.drive(0, 0);
//		    	 		SmartDashboard.putString("Robot Moving", "centering stopped");
//	    			}
//	    	} catch (Exception e) {
//			SmartDashboard.putBoolean("Errored", true);
//		}
//	
//	    }
//	    
//	    protected void Turn(int direction, double speed)
//	    {
//	    	try{
//	    		if(direction == left) //invesion problem? - trying to switch - orignally this was left
//	    		{
//	    			Robot.drivetrain.drive(-speed, speed);
//	    		}
//	    		else if(direction == right)
//	    		{
//	    			Robot.drivetrain.drive(speed, -speed);
//	    		}
//	    	}
//	    	catch(Exception e)
//	    	{
//	    		SmartDashboard.putBoolean("Errored", true);
//	    	}
//	    }
//	    // Called repeatedly when this Command is scheduled to run
//	    protected void execute() {
//
//	    	double cameraViewCenter = cameraWidthInPixels / 2;
//	    	double[] CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
//	    	double[] AreaArray = Robot.table.getNumberArray("area", new double[0]);
//	    	SmartDashboard.putNumber("arraylength",CenterArray.length);
//	    	//SmartDashboard.putNumber("Max Speed Pref", .5);
//	    	//SmartDashboard.putNumber("Min Speed Pref", .3);
//	    	//maxspeed = SmartDashboard.getNumber("Max Speed Pref", .5);
//	    	//minspeed = SmartDashboard.getNumber("Min Speed Pref", .3);
//	    	double kp = ((maxspeed-minspeed) / 129);
//	    	SmartDashboard.putNumber("kp", kp);
//	    	SmartDashboard.putString("Robot Moving", " ");
//	
//	    	//TODO: how far away is the target
//	    	//if far drive to it
//	    	//get two targets on the screen
//	    	if(CenterArray.length != 2)
//	    		PivotToTargets();
//	    	else{
//	    		if(AmIThere()){
//	    			PivotToCenter();	
//	    		} else
//	    		{
//	    			DriveToTarget();
//	    		}
//	
//	    	}
//	    }
//	//    	if( CenterPanels <= 150 || CenterPanels >= 170 ){
//	//    		if(CenterPanels > cameraViewCenter){
//	//    			Robot.drivetrain.drive(-.4, .4);
//	//    		}
//	//    		
//	//    		else if(CenterPanels < cameraViewCenter){
//	//    			Robot.drivetrain.drive(.4, -.4);	
//	//    		}
//	    	//} //else if(CenterPanels == 160 ){
//	    		//Robot.drivetrain.drive(0,0);
//	    	
//	    	
//	
//	    	
//	    	
//	    	
//	////    	Preferences prefs = Preferences.getInstance();
//	//    	double Xmin = prefs.getDouble("Xmin", 380);
//	//    	double Xmax = prefs.getDouble("Xmax", 390);
//	//    	double kP = prefs.getDouble("TurnKp", 1.5);
//	//    	double speed = .55;
//	//    	double max = 0;
//	//    	int maxind = 0;
//	//    	error = Robot.centerX()-80;
//	//    	double[] areaarray  = Robot.table.getNumberArray("area", new double[0]);
//	//    	double[] centerXarray = Robot.table.getNumberArray("centerX", new double[0]);
//	//    	double[] centerYarray = Robot.table.getNumberArray("centerY", new double[0]);
//	//    	
//	//    	if(areaarray.length!=0)
//	//    	{
//	//    		max = areaarray[0];
//	//    		for (int i = 1; i<areaarray.length; i++)
//	//    		{
//	//    			if (areaarray[i]>max && areaarray[i]>400)
//	//    			{
//	//    				max = areaarray[i];
//	//    				maxind = i;
//	//    			}
//	//    		}
//	//    		centerX = centerXarray[maxind];
//	//    		centerY = centerYarray[maxind];
//	//    	}
//	//		SmartDashboard.putNumber("Align Max", max);
//	//		SmartDashboard.putNumber("Align CenterX", centerX);
//	//		
//	//		speed = Math.abs(centerX - ((Xmax+Xmin)/2)) * kP;
//	////		SmartDashboard.putNumber("Turn Speed", speed);
//	//		if (speed > 0.6)
//	//			speed = .6;
//	//		if(speed < 0.3 )
//	//			speed = .3;
//	//    	if(centerX <Xmin || centerX >Xmax)
//	//    	{
//	//        	if(centerX<Xmin )
//	//        	{
//	//        		 
//	////        		SmartDashboard.putString("ExecuteAlign", "<Xmin");
//	//        		Robot.drivetrain.drive(-speed, 0);
//	//        	}
//	//        	if(centerX>Xmax ){	
//	////        		SmartDashboard.putString("ExecuteAlign", ">Xmax");
//	//        		Robot.drivetrain.drive(0, -speed);	
//	//    	    	
//	//        	}	
//	//    	}
//	//    	else
//	//    	{
//	////    		SmartDashboard.putString("ExecuteAlign", "Other");	
//	//    	}
//	//    	if(centerX > Xmin && centerX < Xmax)
//	//    	{
//	//    		Robot.drivetrain.drive(0, 0);
//	//    		setTimeout(.5);
//	//    		
//	//    	}
//	    
//	
//	    // Make this return true when this Command no longer needs to run execute()
//	    protected boolean isFinished() {
//	       return !(Robot.oi.getJoystick1().getRawButton(RobotMap.Vision));
//	       
//	    }
//	
//	    // Called once after isFinished returns true
//	    protected void end() {
//	    	Robot.drivetrain.drive(0,0);
//	//    	SmartDashboard.putNumber("onn", 9001);
//	    }
//	
//	    // Called when another command which requires one or more of the same
//	    // subsystems is scheduled to run
//	    protected void interrupted() {
//	    }
//	}
