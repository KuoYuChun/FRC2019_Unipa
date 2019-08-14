/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmWithJoystick extends Command {
  public ArmWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(Robot.m_oi.m_stick_control.getRawAxis(1) > 0.3 || Robot.m_oi.m_stick_control.getRawAxis(1) < -0.3){
      Robot.arm.arm(Robot.m_oi.m_stick_control.getRawAxis(1), -0.6);
    }else if(Robot.m_oi.m_stick_control.getRawAxis(5) > 0.3 || Robot.m_oi.m_stick_control.getRawAxis(5) < -0.3){
      Robot.arm.arm(Robot.m_oi.m_stick_control.getRawAxis(5), -0.6);
    }else{
      Robot.arm.arm(0, 0);
    }
    Robot.arm.push(Robot.m_oi.Y.get(), Robot.m_oi.A.get());

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
