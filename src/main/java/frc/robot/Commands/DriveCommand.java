// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Subsystem.TankSubsystem;

public class DriveCommand extends Command {

  TankSubsystem tankSubsystem;
  public DriveCommand(TankSubsystem subsystem) {
    tankSubsystem = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftDrive = OI.getDriveController().getLeftY();
    double rightDrive = OI.getDriveController().getRightY();

    //Maintains signs while still applying square factor
    leftDrive = leftDrive < 0 ? -Math.pow(leftDrive, 2) : Math.pow(leftDrive, 2);
    rightDrive = rightDrive < 0 ? -Math.pow(rightDrive, 2) : Math.pow(rightDrive, 2);

    //This can be read like a conditional statement. If leftDrive < 0.05, set it equal to 0, else, keep it the same.
    leftDrive = Math.abs(leftDrive) < 0.05 ? 0 : leftDrive;
    rightDrive = Math.abs(rightDrive) < 0.05 ? 0 : rightDrive;

    tankSubsystem.driveTank(leftDrive, rightDrive);
  }
  

  @Override
  public void end(boolean interrupted) {
    tankSubsystem.driveTank(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
