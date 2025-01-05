package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static XboxController driverController;
    private static XboxController operatorController;

    public static XboxController getDriveController(){
        return driverController;
    }

    public static XboxController getOperatorController(){
        return operatorController;
    }
}
