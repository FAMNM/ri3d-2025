package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.driveConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankSubsystem extends SubsystemBase{
    CANSparkMax leftDriveFront;
    CANSparkMax leftDriveBack;
    CANSparkMax rightDriveFront;
    CANSparkMax rightDriveBack;

    public TankSubsystem(){
        leftDriveFront = new CANSparkMax(driveConstants.leftDriveFront, MotorType.kBrushed);
        leftDriveFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
        leftDriveBack = new CANSparkMax(driveConstants.leftDriveBack, MotorType.kBrushed);
        leftDriveBack.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rightDriveFront = new CANSparkMax(driveConstants.rightDriveFront, MotorType.kBrushed);
        leftDriveFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rightDriveBack = new CANSparkMax(driveConstants.rightDriveBack, MotorType.kBrushed);
        leftDriveBack.setIdleMode(CANSparkMax.IdleMode.kCoast);

        leftDriveFront.setSmartCurrentLimit(driveConstants.driveCurrentLimit);
        rightDriveFront.setSmartCurrentLimit(driveConstants.driveCurrentLimit);

        leftDriveBack.follow(leftDriveFront);
        rightDriveBack.follow(rightDriveFront);
    }

    public void driveTank(double leftSpeed, double rightSpeed){
        leftDriveFront.set(leftSpeed);
        rightDriveFront.set(rightSpeed);
    }
}
