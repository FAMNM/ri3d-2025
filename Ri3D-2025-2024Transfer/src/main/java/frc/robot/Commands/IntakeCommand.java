// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.OI;
import frc.robot.Constants.intakeConstants;
import frc.robot.Subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class IntakeCommand extends Command {
  IntakeSubsystem intakeSubsystem;
  boolean piece;
  
  public IntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    piece = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(OI.getOperatorController().getRawAxis(3) > intakeConstants.triggerThreshold){ 
      //Prioritizes outtake if both are pressed
      intakeSubsystem.setSpeed(intakeConstants.outtakeSpeed);
      piece = false;
    }else if(OI.getOperatorController().getRawAxis(2) > intakeConstants.triggerThreshold){
      //Secondarily considers intake
      intakeSubsystem.setSpeed(intakeConstants.intakeSpeed);
      piece = true;
    }else if(piece){
      //If neither are pressed, sets to static speed if a piece is present
      intakeSubsystem.setSpeed(intakeConstants.staticSpeed);
    }else{
      //If neither are pressed and a piece is not present, sets to 0
      intakeSubsystem.setSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
