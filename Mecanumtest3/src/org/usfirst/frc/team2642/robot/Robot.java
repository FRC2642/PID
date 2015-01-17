
package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	RobotDrive drive;
	Joystick stick;
	int autoLoopCounter;
	Encoder encoder1;
	Encoder encoder2;
	Encoder encoder3;
	Encoder encoder4;
    public void robotInit() {
    	drive = new RobotDrive(2, 3, 1, 0);
    	stick = new Joystick(0);
    	encoder1 = new Encoder(0 ,1, true, Encoder.EncodingType.k4X);
    	encoder2 = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
    	encoder3 = new Encoder(4, 5, true, Encoder.EncodingType.k4X);
    	encoder4 = new Encoder(6, 7, true, Encoder.EncodingType.k4X);

    	encoder1.setMaxPeriod(.1);
    	encoder1.setMinRate(10);
    	encoder1.setDistancePerPulse(5);
    	encoder1.setReverseDirection(false);
    	encoder1.setSamplesToAverage(7);
    	encoder2.setMaxPeriod(.1);
    	encoder2.setMinRate(10);
    	encoder2.setDistancePerPulse(5);
    	encoder2.setReverseDirection(false);
    	encoder2.setSamplesToAverage(7);
    	encoder3.setMaxPeriod(.1);
    	encoder3.setMinRate(10);
    	encoder3.setDistancePerPulse(5);
    	encoder3.setReverseDirection(false);
    	encoder3.setSamplesToAverage(7);
    	encoder4.setMaxPeriod(.1);
    	encoder4.setMinRate(10);
    	encoder4.setDistancePerPulse(5);
    	encoder4.setReverseDirection(false);
    	encoder4.setSamplesToAverage(7);
    	
    	drive.setInvertedMotor(MotorType.kFrontRight, false);	// invert the left side motors
    	drive.setInvertedMotor(MotorType.kRearRight, false);		// you may need to change or remove this to match your robot
    	drive.setInvertedMotor(MotorType.kRearLeft, true);
    	drive.setInvertedMotor(MotorType.kFrontLeft, true);
    }

    public void autonomousInit() {
    	autoLoopCounter = 0;
    	encoder1.reset();
    	//drive.setSafetyEnabled(false);

    }
    
    public void autonomousPeriodic() { //aoutonomus code here
    	System.out.println(encoder1.getDistance());
    	if(encoder1.getDistance() < 700)
    	{
    		drive.mecanumDrive_Cartesian(0.0, -0.5, 0.0, 0.0);
    		//autoLoopCounter++;
    	}else{
    		drive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
    	}
    		
    }
    
    public void teleopInt(){
    	
    }

    public void teleopPeriodic() {
        drive.mecanumDrive_Cartesian(stick.getRawAxis(4)*-1, stick.getY(), stick.getX()*-1, 0);
    	System.out.println(encoder1.getDistance());

        //stick.getTwist();
    }
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
