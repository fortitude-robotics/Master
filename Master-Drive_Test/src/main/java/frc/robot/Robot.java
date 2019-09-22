/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.modules.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;

/*
 * Simplest program to drive a robot with mecanum drive using a single Logitech
 * Extreme 3D Pro joystick and 4 drive motors connected as follows:
 *     - PWM 0 - Connected to front left drive motor
 *     - PWM 1 - Connected to rear left drive motor
 *     - PWM 2 - Connected to front right drive motor
 *     - PWM 3 - Connected to rear right drive motor
 */

public class Robot extends TimedRobot 
{
  //Create a robot drive object using PWMs 0, 1, 2 and 3
  CANSparkMax leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
  public static final int kGamepadAxisLeftStickX = 1;
	public static final int kGamepadAxisLeftStickY = 2;
	public static final int kGamepadAxisRightStickX = 4;
  public static final int kGamepadAxisRightStickY = 5;
  Joystick Ljoy;
  Joystick Rjoy;
  //Define joystick being used at USB port 1 on the Driver Station
  MecanumDrive drivetrain(leftFrontMotor,leftRearMotor,rightFrontMotor,rightRearMotor);
  

  public void teleopPeriodic() 
  {
    double xSpeed = Ljoy.getRawAxis(kGamepadAxisLeftStickX);
    double ySpeed = Ljoy.getRawAxis(kGamepadAxisLeftStickY);
    drivetrain.driveCartesian(ySpeed, xSpeed, 0);
  }
}
