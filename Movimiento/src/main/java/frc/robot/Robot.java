// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the manifest
 * file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final int joystickPort = 0;
  private final int motor1ID = 1;
  private final int motor2ID = 2;
  private Joystick joystick;
  private CANSparkMax motor1, motor2;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    joystick = new Joystick(joystickPort);
    motor1 = new CANSparkMax(motor1ID, MotorType.kBrushless);
    motor2 = new CANSparkMax(motor2ID, MotorType.kBrushless);
  }

  @Override
  public void teleopPeriodic() {
    if (joystick.getRawButton(1)) {
      motor1.set(0.5);
      motor2.set(0.5);
    } else {
      motor1.set(0);
      motor2.set(0);
    }
  }
}
