// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.HarvesterSubsystem;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.commands.HarvesterCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final CommandXboxController joystick = new CommandXboxController(0);
  private final CommandXboxController joystick2 = new CommandXboxController(1);
  private final ShooterSubsytem shooter = new ShooterSubsytem();
  private final HarvesterSubsystem harv = new HarvesterSubsystem();
  private final HarvesterCommand harvest = new HarvesterCommand(harv);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    bindJoystickX();
    bindJoysticky();
  }

  private void bindJoystickX() {

    // hold x down to shoot using Command API factorie
    // joystick.x().whileTrue(
    //     shooter.startEnd(
    //         () -> shooter.runShooter(), // Start action
    //         () -> shooter.stopShooter() // End action
    //     )
    //     );
        // toggle on and off b pressing X
        joystick.x().toggleOnTrue(
           shooter.startEnd(
            () -> shooter.runShooter(), // Start action
            () -> shooter.stopShooter() // End action
        )
        );
        // joystick.x().whileTrue( //can run a talon and rev motor, plug in it's at shooter subsstem and harvester subsstem, also go into rev thing and phoenix tuner
        // harv.startEnd(
        //     () -> harv.runShooter(), // Start action
        //     () -> harv.stopShooter() // End action
        // )
        // );
  }


  private void bindJoysticky() {
  //joystick.y().onTrue(harv.increaseShooterCommand());
  // joystick.y().whileTrue(
  //       harv.startEnd(
  //           () -> harv.runShooter(), // Start action
  //           () -> harv.stopShooter() // End action
  //       )
  //       );

    //toggle harvester on and off with the press of a button 
    joystick.y().toggleOnTrue(
      harv.startEnd(
          () -> harv.runShooter(), // Start action
          () -> harv.stopShooter() // End action
      )
      );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
