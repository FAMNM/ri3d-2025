// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Subsystem.TankSubsystem;

public class TankCommand extends Command {

  TankSubsystem tankSubsystem;
  public TankCommand(TankSubsystem subsystem) {
    addRequirements(subsystem);
    tankSubsystem = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftDrive = Math.pow(OI.getDriveController().getLeftY(), 2);
    double rightDrive = Math.pow(OI.getDriveController().getRightY(), 2);

    //This can be read like a conditional statement. If leftDrive < 0.05, set it equal to 0, else, keep it the same.
    leftDrive = leftDrive < 0.05 ? 0 : leftDrive;
    rightDrive = rightDrive < 0.05 ? 0 : rightDrive;

    tankSubsystem.driveTank(leftDrive, rightDrive);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tankSubsystem.driveTank(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
