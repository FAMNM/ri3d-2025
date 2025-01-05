package frc.robot.Subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.intakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    SparkMax intakeMotor;

    public IntakeSubsystem(){
        intakeMotor = new SparkMax(intakeConstants.intakeMotor, MotorType.kBrushed);
    }

    public void setSpeed(double speed){
        intakeMotor.set(speed);
    }
}
