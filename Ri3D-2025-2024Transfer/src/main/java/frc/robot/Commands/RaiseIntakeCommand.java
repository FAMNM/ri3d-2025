// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Constants.intakeConstants;
import frc.robot.Subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class RaiseIntakeCommand extends Command {
  IntakeSubsystem intakeSubsystem;
  boolean piece;
  
  public RaiseIntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    piece = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("RUNNING DA PIVOT");
    intakeSubsystem.setPivotSpeed(intakeConstants.pivotSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     intakeSubsystem.setPivotSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

