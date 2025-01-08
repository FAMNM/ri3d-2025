// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.liftConstants;
import frc.robot.Subsystems.LiftSubsystem;

public class LiftCommandManual extends Command {
  /** Creates a new LiftCommand. */
  LiftSubsystem liftSubsystem;
  boolean direction;

  //true is up, false is down
  public LiftCommandManual(LiftSubsystem liftSubsystem, boolean direction) {
    this.liftSubsystem = liftSubsystem;
    this.direction = direction;
  }

  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(direction)
    {
      liftSubsystem.setSpeed(0.15);
    }
    else
    {
      liftSubsystem.setSpeed(-0.15);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    liftSubsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
