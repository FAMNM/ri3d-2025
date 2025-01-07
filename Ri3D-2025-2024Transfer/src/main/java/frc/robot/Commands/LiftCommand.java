// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.liftConstants;
import frc.robot.Subsystems.LiftSubsystem;

public class LiftCommand extends Command {
  /** Creates a new LiftCommand. */
  LiftSubsystem liftSubsystem;

  public enum liftPosition {
    LOW,
    MEDIUM,
    HIGH
  }

  liftPosition position;

  public LiftCommand(LiftSubsystem liftSubsystem) {
    this.liftSubsystem = liftSubsystem;

    //Starts at low
    position = liftPosition.LOW;
  }

  public void setPosition(liftPosition position){
    this.position = position;
  }

  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(position){
      case LOW:
        liftSubsystem.update(liftConstants.low);
        break;
      case MEDIUM:
        liftSubsystem.update(liftConstants.mid);
        break;
      case HIGH:
        liftSubsystem.update(liftConstants.high);
        break;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
