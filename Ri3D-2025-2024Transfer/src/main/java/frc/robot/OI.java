package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static XboxController driveController = new XboxController(0);
    private static XboxController operatorController = new XboxController(1);

    public static XboxController getDriveController(){
        return driveController;
    }

    public static XboxController getOperatorController(){
        return operatorController;
    }
}
