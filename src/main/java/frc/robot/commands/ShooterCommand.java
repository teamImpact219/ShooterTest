// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsytem;
import edu.wpi.first.wpilibj.XboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShooterCommand extends Command {
  private final ShooterSubsytem shooter;
  private final XboxController controller = new XboxController(0);
  /** Creates a new shooterCommand. */
  public ShooterCommand(ShooterSubsytem shooterSubsytem) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = shooterSubsytem;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("inside initialize");
    shooter.runShooter();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    System.out.println("inside execute");

    
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("inside end");
    
    shooter.stopShooter();
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println("inside isFinished");
    return false;
  }
}
