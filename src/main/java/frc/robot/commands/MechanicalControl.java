// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class MechanicalControl extends Command {
  public MechanicalControl() {
    _flywheel = fl;
    _joystick = js;
    addRequirements(_flywheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _flywheel.controlFlywheel(_joystick.getRawAxis(Constants.JoystickAxis.YAxis));
    SmartDashboard.putNumber("Velocity: ", _flywheel.getVelocity());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
