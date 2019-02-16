package frc.robot.control;

import frc.robot.Robot;

public class OperatorControls extends PSController {


    public OperatorControls() {
        super(1);
    }

    /**
     * This controls the robot and should only be used during TeleOp
     * @param robot
     */
    @Override
    public void giveCommands(Robot robot) {
        super.giveCommands(robot);
    }

    @Override
    protected void processCross(Robot robot) {

    }

    @Override
    protected void processSquare(Robot robot) {

    }

    @Override
    protected void processCircle(Robot robot) {

    }

    @Override
    protected void processTriangle(Robot robot) {

    }

    @Override
    protected void processL1(Robot robot) {

    }

    @Override
    protected void processR1(Robot robot) {

    }

    @Override
    protected void processL2(Robot robot) {

    }

    @Override
    protected void processR2(Robot robot) {

    }

    @Override
    protected void processShare(Robot robot) {

    }

    @Override
    protected void processOptions(Robot robot) {

    }

    @Override
    protected void processNoButtons(Robot robot) {
        robot.getIntake().hold();
        robot.getLift().hold();
    }
}
