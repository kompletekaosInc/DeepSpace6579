/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive robotDrive = null;
  private final Joystick stick = new Joystick(0);
  private final Timer timer = new Timer();

  private VictorSP intake;
  //private VictorSP lift;
  private VictorSP intakePivot;
  private VictorSP carriageFlywheel;

  private CANSparkMax spark7;
  private CANSparkMax spark8;

  private SpeedControllerGroup lift = null;

  private VictorSP leftDrive1 = null;
  private VictorSP leftDrive2 = null;

  private SpeedControllerGroup leftTB = null;

  private VictorSP rightDrive1 = null;
  private VictorSP rightDrive2 = null;

  private SpeedControllerGroup rightTB = null;

  private CANEncoder encoderSPARK;



//  DoubleSolenoid hatch = new DoubleSolenoid(0, 1);
//  DoubleSolenoid carriage = new DoubleSolenoid(2, 3);
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    try{
    intake = new VictorSP(4);
    //lift = new VictorSP(2);
    intakePivot = new VictorSP(6);
    carriageFlywheel = new VictorSP(5);

    
    spark8 = new CANSparkMax(8, MotorType.kBrushless);
    spark7 = new CANSparkMax(7, MotorType.kBrushless);

    encoderSPARK = spark7.getEncoder();



    lift = new SpeedControllerGroup(spark7,spark8);

    leftDrive1 = new VictorSP(0);
    leftDrive2 = new VictorSP(1);
    leftTB = new SpeedControllerGroup(leftDrive1,leftDrive2);

    rightDrive1 = new VictorSP(2);
    rightDrive2 = new VictorSP(3);
    rightTB = new SpeedControllerGroup(rightDrive1,rightDrive2);

    robotDrive = new DifferentialDrive(leftTB,rightTB);
    }
    catch(Exception e){

    e.printStackTrace();
    }
//    Compressor c = new Compressor(0);
//
//    c.setClosedLoopControl(true);
    //c.setClosedLoopControl(false);



//    exampleDouble.set(DoubleSolenoid.Value.kOff);
//    exampleDouble.set(DoubleSolenoid.Value.kForward);
//    exampleDouble.set(DoubleSolenoid.Value.kReverse);


  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (timer.get() < 2.0) {
      robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      robotDrive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    robotDrive.arcadeDrive(stick.getY(), stick.getX());

    if(stick.getRawButton(2)){
      intake.set(0.7);
    }
    else if(stick.getRawButton(1)){
      intake.set(-.7);
    }
    else if(stick.getRawButton(10)){
      lift.set(1);
    }
    else if(stick.getRawButton(9)){
      lift.set(-0.6);
    }
    else if(stick.getRawButton(8)){
      carriageFlywheel.set(0.3);
    }
    else if(stick.getRawButton(7)){
      carriageFlywheel.set(-0.8);
    }
    else if (stick.getRawButton(11)){
      //intakePivot.set(-0.6);
      lift.set(-0.2);
    }
    else if (stick.getRawButton(12)){
      //intakePivot.set(0.6);
      lift.set(0.4);
    }
    else if (stick.getRawButton(6)){
      //hatch.set(DoubleSolenoid.Value.kForward);

    }
    else if (stick.getRawButton(5)){
      //hatch.set(DoubleSolenoid.Value.kReverse);

    }
    else if (stick.getRawButton(4)){
      //carriage.set(DoubleSolenoid.Value.kForward);

    }
    else if (stick.getRawButton(3)){
      //carriage.set(DoubleSolenoid.Value.kReverse);

    }
    else {
      lift.set(0.03);
      intake.set(0);
      intakePivot.set(0);
      carriageFlywheel.set(0);
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
