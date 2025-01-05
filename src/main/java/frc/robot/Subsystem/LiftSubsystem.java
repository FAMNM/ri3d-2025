package frc.robot.Subsystem;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

    DigitalInput bottomLimitSwitch;
    SparkMax liftMotor;
    

    public LiftSubsystem(){
    }
}
