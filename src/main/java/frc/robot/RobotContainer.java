// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ShooterSubsytem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final CommandXboxController joystick = new CommandXboxController(0);
  private final ShooterSubsytem shooter = new ShooterSubsytem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    bindJoystickX();
  }

  private void bindJoystickX() {

    // hold x down to shoot using Command API factorie
    joystick.x().whileTrue(
        shooter.startEnd(
            () -> shooter.runShooter(), // Start action
            () -> shooter.stopShooter() // End action
        ));

    // hold x down to shoot using Command API factorie
    joystick.x().whileTrue(
        shooter.startEnd(
            () -> shooter.runShooter(), // Start action
            () -> shooter.stopShooter() // End action
        ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
