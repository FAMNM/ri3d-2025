// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.event.BooleanEvent;
import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.LiftCommand.liftPosition;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  //Since we gotta use this garbage now
  private final EventLoop m_loop = new EventLoop();

  private final RobotContainer m_robotContainer;

  public static boolean overrideLiftPosition = false;

  public Robot() {
    m_robotContainer = new RobotContainer();

    BooleanEvent setLow = new BooleanEvent(m_loop, () -> OI.getOperatorController().getRawButton(1));
    setLow.ifHigh(() ->m_robotContainer.liftCommand.setPosition(liftPosition.LOW));

    BooleanEvent setMedium = new BooleanEvent(m_loop, () -> OI.getOperatorController().getRawButton(2));
    setMedium.ifHigh(() ->m_robotContainer.liftCommand.setPosition(liftPosition.MEDIUM));

    BooleanEvent setHigh = new BooleanEvent(m_loop, () -> OI.getOperatorController().getRawButton(3));
    setHigh.ifHigh(() ->m_robotContainer.liftCommand.setPosition(liftPosition.HIGH));

    BooleanEvent override = new BooleanEvent(m_loop, () -> OI.getOperatorController().getPOV() == 270);
    override.ifHigh(() -> overrideLiftPosition = true);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    m_loop.poll();
    SmartDashboard.putBoolean("Lift Restriction Overridden", overrideLiftPosition);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    m_robotContainer.driveCommand.schedule();
    m_robotContainer.indexCommand.schedule();
    m_robotContainer.intakeCommand.schedule();
    m_robotContainer.liftCommand.schedule();
  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
