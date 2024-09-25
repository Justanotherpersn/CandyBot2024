// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Hammer extends SubsystemBase {
  TalonFX hammerMotor = new TalonFX(3);
  /** Creates a new Hammer. */
  public Hammer() {
    
  }
  /*public void set(double hammerSpeed){
    hammerMotor.set(ControlMode.PercentOutput, hammerSpeed);

  } */
  public void hammerMove(){
    hammerMotor.set(ControlMode.PercentOutput, 50);
  }
  

  public void stop(){
    hammerMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
