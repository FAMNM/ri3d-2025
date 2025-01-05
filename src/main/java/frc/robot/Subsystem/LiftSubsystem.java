package frc.robot.Subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.liftConstants;

public class LiftSubsystem extends SubsystemBase {

    DigitalInput bottomLimitSwitch;
    SparkMax liftMotor;
    PIDController pid;

    public LiftSubsystem(){
        //Using motor to power lift and limit switch at the bottom
        liftMotor = new SparkMax(liftConstants.liftMotor, MotorType.kBrushless);
        bottomLimitSwitch = new DigitalInput(liftConstants.bottomLimitSwitch);

        //Need PID to hold location
        pid = new PIDController(liftConstants.liftMotorP, liftConstants.liftMotorI, liftConstants.liftMotorD);
        pid.setTolerance(50);

        //Setting current limit
        SparkMaxConfig config = new SparkMaxConfig();
        config.smartCurrentLimit(liftConstants.liftCurrentLimit);
        liftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }


    public void update(double position){
        double speed = pid.calculate(liftMotor.getAbsoluteEncoder().getPosition(), position);
        //If the limit switch is triggered, we should not apply a negative speed
        if(bottomLimitSwitch.get())
            speed = speed < 0 ? 0 : speed;
        liftMotor.set(pid.calculate(liftMotor.getAbsoluteEncoder().getPosition(), position));
    }
}
