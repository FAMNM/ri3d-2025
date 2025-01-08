// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.LiftCommand;
import frc.robot.Commands.LiftCommandManual;
import frc.robot.Commands.RunStarCommand;
import frc.robot.Commands.RaiseIntakeCommand;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.LiftSubsystem;
import frc.robot.Subsystems.TankSubsystem;

public class RobotContainer {
  public TankSubsystem tankSubsystem = new TankSubsystem();
  public IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public LiftSubsystem liftSubsystem = new LiftSubsystem();

  public DriveCommand driveCommand = new DriveCommand(tankSubsystem);
  public IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);
  public LiftCommand liftCommand = new LiftCommand(liftSubsystem);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    // Left bumper to raise intake
    
   // new Trigger(() -> OI.getOperatorController().getLeftBumper())
   //     .whileTrue(new RaiseIntakeCommand(intakeSubsystem));

    new Trigger(() -> OI.getOperatorController().getYButton())
        .whileTrue(new LiftCommandManual(liftSubsystem, true));

    new Trigger(() -> OI.getOperatorController().getAButton())
        .whileTrue(new LiftCommandManual(liftSubsystem, false));

        new Trigger(() -> OI.getOperatorController().getBButton())
        .whileTrue(new RunStarCommand(liftSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
