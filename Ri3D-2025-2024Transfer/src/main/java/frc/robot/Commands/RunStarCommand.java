// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.liftConstants;
import frc.robot.Subsystems.LiftSubsystem;

public class RunStarCommand extends Command {
  /** Creates a new LiftCommand. */
  LiftSubsystem liftSubsystem;

  //true is up, false is down
  public RunStarCommand(LiftSubsystem liftSubsystem) {
    this.liftSubsystem = liftSubsystem;
  }

  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //System.out.println("run star");
   liftSubsystem.setStarSpeed(0.65);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    liftSubsystem.setStarSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
