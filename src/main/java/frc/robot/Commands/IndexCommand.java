// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Constants.indexConstants;
import frc.robot.Subsystem.IndexSubsystem;
import frc.robot.Subsystem.LiftSubsystem;

public class IndexCommand extends Command {

  IndexSubsystem indexSubsystem;
  LiftSubsystem liftSubsystem;

  public IndexCommand(IndexSubsystem indexSubsystem, LiftSubsystem liftSubsystem) {
    this.indexSubsystem = indexSubsystem;
    this.liftSubsystem = liftSubsystem;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(OI.getOperatorController().getRawButton(3)){
      if(liftSubsystem.atPosition() || Robot.overrideLiftPosition){
        indexSubsystem.setSpeed(indexConstants.indexSpeed);
      }
    }else{
      indexSubsystem.setSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    indexSubsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
