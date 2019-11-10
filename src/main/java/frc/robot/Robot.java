/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.modules.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import java.io.PrintStream;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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
  CANSparkMax rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
  TalonSRX clawHigh = new TalonSRX(1);
  TalonSRX clawLow = new TalonSRX(2);
  public static final int kGamepadAxisLeftStickX = 1;
	public static final int kGamepadAxisLeftStickY = 2;
	public static final int kGamepadAxisRightStickX = 4;
  public static final int kGamepadAxisRightStickY = 5;
  Joystick Ljoy = new Joystick(0);
  //Define joystick being used at USB port 1 on the Driver Station
  MecanumDrive drivetrain = new MecanumDrive(leftFrontMotor,leftRearMotor,rightFrontMotor,rightRearMotor);
  

  public void teleopPeriodic() 
  {
    //Gettign the raw joystick imput
    /*
    double xSpeed = Ljoy.getRawAxis(kGamepadAxisLeftStickX);
    double ySpeed = Ljoy.getRawAxis(kGamepadAxisLeftStickY);
    double zSpeed = Ljoy.getRawAxis(kGamepadAxisRightStickX);
    */
    double zRaw = Ljoy.getAxis(AxisType.kX);
    double yRaw = Ljoy.getAxis(AxisType.kY);
    double xRaw = Ljoy.getAxis(AxisType.kZ);
    PrintStream printLog = new PrintStream(out);
    printLog.println(zRaw);
    printLog.println(yRaw);
    printLog.println(xRaw);



    //cubing the imput, devide by factor to adjust
    int downscale = 1000;
    xSpeed = (Math.pow(xSpeed,3)/downscale);
    ySpeed = (Math.pow(ySpeed,3)/downscale);
    zSpeed = (Math.pow(zSpeed,3)/downscale);

  

    double dz = .05;

    //Dedzone check and sigin control for application of deadzone
    xSpeed = Math.abs(xSpeed) < dz ? 0.0 : xSpeed - (dz * Math.abs(xSpeed) / xSpeed);
    ySpeed = Math.abs(ySpeed) < dz ? 0.0 : ySpeed - (dz * Math.abs(ySpeed) / ySpeed);
    zSpeed = Math.abs(zSpeed) < dz ? 0.0 : zSpeed - (dz * Math.abs(zSpeed) / zSpeed);

    double speedFactor = .7;
    double turnFactor = .7;

    //Final value passing
    drivetrain.driveCartesian(-xSpeed * speedFactor, ySpeed * speedFactor, -zSpeed * turnFactor);
  }
} 