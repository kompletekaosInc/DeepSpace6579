package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain implements SubSystem {

    private VictorSP leftTB1 = new VictorSP(0);
    private VictorSP leftTB2 = new VictorSP(1);
    private SpeedControllerGroup leftTB = new SpeedControllerGroup(leftTB1, leftTB2);

    private VictorSP rightTB1 = new VictorSP(2);
    private VictorSP rightTB2 = new VictorSP(3);
    private SpeedControllerGroup rightTB = new SpeedControllerGroup(rightTB1, rightTB2);

    // init the drivetrain
    private DifferentialDrive robotDrive = new DifferentialDrive(leftTB, rightTB);

    private Compressor c;

    public Drivetrain(){
        c = new Compressor(0);
        c.setClosedLoopControl(true);



        //TODO: Find out what other methods belong to the drivetrain

    }

    /*
     * this is the method for moving the robot, could be used by arcade drive and
     * auto
     *
     * @param leftPower
     *
     * @param rightPower
     */
    public void setPower(double leftPower, double rightPower) {
        // sets the left toughbox
        leftTB.set(-leftPower);
        // sets the right toughbox
        rightTB.set(rightPower);
        //SmartDashboard.putNumber("Power", (rightPower + leftPower) / 2);
    }

    public void arcadeDiffDrive(double stickX, double stickY) {

        //SmartDashboard.getNumber("Stick X: ", stickX);
        //SmartDashboard.getNumber("Stick Y: ", stickY);
        robotDrive.arcadeDrive(stickY, stickX);
    }









    @Override
    public void publishStats() {
        //fill with stats to put on the shuffleboard/smartdash/ etc

    }

    @Override
    public void test() {

    }
}
