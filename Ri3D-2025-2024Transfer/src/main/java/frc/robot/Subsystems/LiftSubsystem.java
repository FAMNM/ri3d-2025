package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.liftConstants;

public class LiftSubsystem extends SubsystemBase{
    CANSparkMax liftMotor;
    PIDController pid;
    double position;

    public LiftSubsystem(){
        liftMotor = new CANSparkMax(liftConstants.liftMotor, MotorType.kBrushless);

        liftMotor.setSmartCurrentLimit(liftConstants.liftCurrentLimit);

        pid = new PIDController(liftConstants.liftMotorP, liftConstants.liftMotorI, liftConstants.liftMotorD);
        pid.setTolerance(liftConstants.liftTolerance);
    }

    public void update(double position){
        this.position = position;
        //If the limit switch is triggered, we should not apply a negative speed
        liftMotor.set(pid.calculate(liftMotor.getAbsoluteEncoder().getPosition(), position));
    }

    public boolean atPosition(){
        return Math.abs(position - liftMotor.getAbsoluteEncoder().getPosition()) < liftConstants.liftTolerance;
    }

    public double getPosition(){
        return liftMotor.getEncoder().getPosition();
    }
}

