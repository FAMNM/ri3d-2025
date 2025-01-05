package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;

public class OI {
    private static XboxController driverController = new XboxController(OIConstants.driveController);
    private static XboxController operatorController = new XboxController(OIConstants.operatorController);

    public static XboxController getDriveController(){
        return driverController;
    }

    public static XboxController getOperatorController(){
        return operatorController;
    }
}
