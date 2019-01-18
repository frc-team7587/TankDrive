/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.vision.*;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private SpeedController m_leftFMotor;
  private SpeedController m_rightFMotor;
  private SpeedController m_leftBMotor;
  private SpeedController m_rightBMotor;
  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;
  private VideoSource usbCamera;

  @Override
  public void robotInit() {

    m_leftFMotor = new PWMVictorSPX(0); // port number on the ROBORIO
    m_leftBMotor = new PWMVictorSPX(0);
    m_rightFMotor = new PWMVictorSPX(1);
    m_rightBMotor = new PWMVictorSPX(1);
    m_left = new SpeedControllerGroup(m_leftFMotor, m_leftBMotor);
    m_right = new SpeedControllerGroup(m_rightFMotor, m_rightBMotor);
    m_myRobot = new DifferentialDrive(m_left, m_right);

    m_leftStick = new Joystick(0);
    // m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {

    // drive(-joy.getY(), -joy.getRawAxis(3));

    // m_myRobot.arcadeDrive(-m_leftStick.getY(), m_leftStick.getZ());

    m_myRobot.tankDrive(-m_leftStick.getY(), -m_leftStick.getRawAxis(5));

  }
}
