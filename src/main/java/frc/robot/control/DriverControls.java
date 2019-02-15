package frc.robot.control;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Robot;
//import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.Drivetrain;

public class DriverControls extends PSController {

    public DriverControls() {
        super(0);
    }

    //private Drivetrain drivetrain =

    /**

     */
    private void arcadeDrive(Robot robot){
        double stickX = controller.getX(GenericHID.Hand.kLeft);
        double stickY = controller.getY(GenericHID.Hand.kLeft);

        robot.getDrivetrain().arcadeDiffDrive(stickX,stickY);

    }

}
