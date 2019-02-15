package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Lift implements SubSystem {

    private static double HOLD_POWER = 0.03;

    private CANSparkMax spark7;
    private CANSparkMax spark8;

    private SpeedControllerGroup lift;

    private CANEncoder encoder1;
    //private CANEncoder encoder2;

    private static double cmToEncoderValues = 1;


    public Lift(){
        //Todo: Does the lift own the cameras? y/n

//        spark8 = new CANSparkMax(8, CANSparkMaxLowLevel.MotorType.kBrushless);
//        spark7 = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);

        spark7 = new CANSparkMax(7, MotorType.kBrushless);
        spark8 = new CANSparkMax(8, MotorType.kBrushless);

        lift = new SpeedControllerGroup(spark7,spark8);

        encoder1 = spark7.getEncoder();

    }

    /**
     * This drives teh lift up at the designated speed
     * @param power
     */
    public void liftUp(double power){
        lift.set(power);
    }

    /**
     * Drives the lift down at the specified power
     * @param power
     */
    public void liftDown(double power){
        lift.set(-power);
    }

    /**
     * This method stops the lift
     */
    public void stopLift(){
        lift.set(0);
    }

    /**
     * This method drives the lift up to the specified encoder height
     * @param height
     */
    public void driveUpToEncoder(double height, double power){

        double heightAdjusted = height * cmToEncoderValues;
        //
        while (encoder1.getPosition()<=heightAdjusted){
            liftUp(power);
        }
        stopLift();

    }

    /**
     * This method drives the lift down to the specified height
     * @param height
     */
    public void driveDownToEncoder(double height, double power){

        double heightAdjusted = height * cmToEncoderValues;

        //ToDo: Ramp up/down?
        while (encoder1.getPosition()>=heightAdjusted){
            liftDown(power);
        }
        stopLift();

    }

    /**
     * holds the lift at whatever the current height is
     */
    public void hold(){
        liftUp(HOLD_POWER);
    }

//ToDo: other lift methods?

    @Override
    public void publishStats() {

    }

    @Override
    public void test() {

    }
}
