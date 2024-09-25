// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hammer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class JoystickDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private final DriveTrain driveTrain;
  private final Hammer hammer;
  private Joystick joystick;

  double leftJoy;
  double rightJoy;
  double hammerSpeed;
  boolean trigger;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickDrive(DriveTrain driveTrain, Joystick joystick, Hammer hammer) {
    this.hammer = hammer;
    this.driveTrain = driveTrain;
    this.joystick = joystick;

    addRequirements(driveTrain);
    addRequirements(hammer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    leftJoy = 0;
    rightJoy = 0;
    trigger = false;
    hammerSpeed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //handles hammer rotation
    //trigger = joystick.getRawButton(6);
    if(joystick.getRawButtonPressed(6)){
      hammer.hammerMove();
    }
    if(joystick.getRawButtonReleased(6)){
      hammer.stop();
    }
   


    //controls drivetrain movement
    leftJoy = joystick.getRawAxis(1);
    rightJoy = joystick.getRawAxis(5);
    driveTrain.set(rightJoy, leftJoy);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
    hammer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
