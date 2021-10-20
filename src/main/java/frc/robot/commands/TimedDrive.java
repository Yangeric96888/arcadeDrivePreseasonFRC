// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TimedDrive extends CommandBase {
  Timer timer;
  private final int time;
  private final DriveTrain _drivetrain;

  /** Creates a new TimedDrive. */
  public TimedDrive(DriveTrain dt, int inputTime) {
    // Use addRequirements() here to declare subsystem dependencies.
    _drivetrain = dt;
    time = inputTime;
    timer = new Timer();
    addRequirements(_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    if (timer.get() <= 10 ){
      _drivetrain.tankDrive(0.8, 0.8);

    }
    else {
      timer.reset();
      _drivetrain.tankDrive(0, 0);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
