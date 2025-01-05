package frc.robot.Subsystem;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveConstants;

public class TankSubsystem extends SubsystemBase{
    SparkMax leftDriveFront;
    SparkMax leftDriveBack;
    SparkMax rightDriveFront;
    SparkMax rightDriveBack;

    //The tank subsystem is responsible for driving the robot.
    public TankSubsystem(){
        leftDriveFront = new SparkMax(driveConstants.leftDriveFront, MotorType.kBrushed);
        leftDriveBack = new SparkMax(driveConstants.leftDriveBack, MotorType.kBrushed);
        rightDriveFront = new SparkMax(driveConstants.rightDriveFront, MotorType.kBrushed);
        rightDriveBack = new SparkMax(driveConstants.rightDriveBack, MotorType.kBrushed);

        SparkMaxConfig config = new SparkMaxConfig();
        config.smartCurrentLimit(driveConstants.driveCurrentLimit);

        //set the back motors to follow the front motors
        config.follow(driveConstants.leftDriveFront);
        leftDriveBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        config.follow(driveConstants.rightDriveFront);
        rightDriveBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        config.disableFollowerMode();
        config.inverted(driveConstants.leftInverted);
        leftDriveFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        config.inverted(driveConstants.rightInverted);
        rightDriveFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    //This method drives the robot.
    public void driveTank(double leftSpeed, double rightSpeed){
        leftDriveFront.set(leftSpeed);
        rightDriveFront.set(rightSpeed);
    }
}
