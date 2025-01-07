package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.intakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    CANSparkMax intakeMotor;

    public IntakeSubsystem(){
        intakeMotor = new CANSparkMax(intakeConstants.intakeMotor, MotorType.kBrushed);
        intakeMotor.setInverted(true);
    }

    public void setSpeed(double speed){
        intakeMotor.set(speed);
    }
}
