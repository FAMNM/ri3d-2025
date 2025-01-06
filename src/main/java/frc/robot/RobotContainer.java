// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.IndexCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Subsystem.TankSubsystem;
import frc.robot.Subsystem.IndexSubsystem;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.Subsystem.LiftSubsystem;
import frc.robot.Commands.LiftCommand;

public class RobotContainer {
  public RobotContainer() {
  }
  private TankSubsystem tankSubsystem = new TankSubsystem();
  private LiftSubsystem liftSubsystem = new LiftSubsystem();
  private IndexSubsystem indexSubsystem = new IndexSubsystem();
  private IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  

  public DriveCommand driveCommand = new DriveCommand(tankSubsystem);
  public LiftCommand liftCommand = new LiftCommand(liftSubsystem);
  public IndexCommand indexCommand = new IndexCommand(indexSubsystem, liftSubsystem);
  public IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);



  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
