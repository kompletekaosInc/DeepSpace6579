/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.subsystems.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

  //all the subsystems
  private Drivetrain drivetrain;
  private Lift lift;
  private Intake intake;
  private Carriage carriage;
  private Hatch hatch;

  //creating a list of all the subsystems
  private List subSystems = new ArrayList();



/**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    try{
      drivetrain = new Drivetrain();
      lift = new Lift();
      intake = new Intake();
      carriage = new Carriage();
      hatch = new Hatch();

      subSystems.add(drivetrain);
      subSystems.add(lift);
      subSystems.add(intake);
      subSystems.add(carriage);
      subSystems.add(hatch);
    }catch (Exception e){
      System.out.println("Error loading subsystems");
      e.printStackTrace();
    }

    //try/catches involving the driver controls etc
    //ToDo: fill out controls

  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

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

  }


  //Accessor methods
  public Drivetrain getDrivetrain(){return drivetrain;}

  public Carriage getCarriage() {
    return carriage;
  }

  public Hatch getHatch() {
    return hatch;
  }

  public Intake getIntake() {
    return intake;
  }

  public Lift getLift() {
    return lift;
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
