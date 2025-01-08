package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.intakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    CANSparkMax intakeMotor;
    CANSparkMax pivotMotor;

    public IntakeSubsystem(){
        intakeMotor = new CANSparkMax(intakeConstants.intakeMotor, MotorType.kBrushed);
        pivotMotor = new CANSparkMax(intakeConstants.pivotMotor, MotorType.kBrushed);
        
        pivotMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
        intakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

        intakeMotor.setInverted(true);
    }

    public void setSpeed(double speed){
        intakeMotor.set(speed);
    }

    public void setPivotSpeed(double speed){
        pivotMotor.set(speed);
    }
}
