/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private SpeedController m_leftMotor;
  private SpeedController m_rightMotor;

  @Override
  public void robotInit() {

    m_leftMotor = new PWMVictorSPX(0);
    m_rightMotor = new PWMVictorSPX(1);

    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);
    
    m_leftStick = new Joystick(0);
    // m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    
    m_myRobot.arcadeDrive(m_leftStick.getY(), m_leftStick.getZ());
    // m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
