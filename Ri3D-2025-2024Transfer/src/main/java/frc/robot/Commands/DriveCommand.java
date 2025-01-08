// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Constants.driveConstants;
import frc.robot.Subsystems.TankSubsystem;

/** Add your docs here. */
public class DriveCommand extends Command {
    TankSubsystem tankSubsystem;
    
    public DriveCommand(TankSubsystem tankSubsystem){
        this.tankSubsystem = tankSubsystem;
    }

    @Override
    public void execute(){
        double leftDrive = OI.getDriveController().getLeftY();
        double rightDrive = OI.getDriveController().getRightY();

        //Maintains signs while still applying square factor
       // leftDrive = leftDrive < 0 ? -Math.pow(leftDrive, 2) : Math.pow(leftDrive, 2);
       // rightDrive = rightDrive < 0 ? -Math.pow(rightDrive, 2) : Math.pow(rightDrive, 2);

        //This can be read like a conditional statement. If leftDrive < 0.05, set it equal to 0, else, keep it the same.
        leftDrive = Math.abs(leftDrive) < 0.05 ? 0 : leftDrive;
        leftDrive*= driveConstants.driveMultiplier;
        rightDrive = Math.abs(rightDrive) < 0.05 ? 0 : rightDrive;
        rightDrive *= driveConstants.driveMultiplier;
        tankSubsystem.driveTank(leftDrive, rightDrive);
    }

    @Override
    public void end(boolean interrupted){
        tankSubsystem.driveTank(0, 0);
    }

}
