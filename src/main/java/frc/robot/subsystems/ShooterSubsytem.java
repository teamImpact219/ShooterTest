// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsytem extends SubsystemBase {
  private final XboxController controller = new XboxController(0);
  private final TalonFX shooter  = new TalonFX(10);


  public void runShooter(){
    shooter.set(-.3);
  }

  public void stopShooter(){
    shooter.set(0);
  }



  /** Creates a new ShooterSubsytem. */
  public ShooterSubsytem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
