// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  TalonFX motorLeft = new TalonFX(2);
  TalonFX motorRight = new TalonFX(1);

  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void set(double leftJoy, double rightJoy) {
    double leftSpeed = leftJoy;
    double rightSpeed = rightJoy;

    motorLeft.set(ControlMode.PercentOutput, leftSpeed);
    motorRight.set(ControlMode.PercentOutput, -rightSpeed);
  }

  public void stop() {
    motorLeft.set(ControlMode.PercentOutput, 0);
    motorRight.set(ControlMode.PercentOutput, 0);
  }
}
