package frc.robot.Subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.indexConstants;

public class IndexSubsystem extends SubsystemBase {

    SparkMax indexMotor;

    public IndexSubsystem(){
        indexMotor = new SparkMax(indexConstants.indexMotor, MotorType.kBrushless);
    }   

    public void setSpeed(double speed){
        indexMotor.set(speed);
    }
}
