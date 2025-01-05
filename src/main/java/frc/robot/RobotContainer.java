// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.TankCommand;
import frc.robot.Subsystem.TankSubsystem;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }

  private TankSubsystem tankSubsystem = new TankSubsystem();

  public TankCommand tankCommand = new TankCommand(tankSubsystem);

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
