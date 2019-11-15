/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.drive.*;
import java.util.Vector;
import java.util.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem 
{
  CANSparkMax leftFrontMotor = new CANSparkMax(RobotMap.FRONT_LEFT_MOTOR, MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(RobotMap.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
  CANSparkMax leftRearMotor = new CANSparkMax(RobotMap.REAR_LEFT_MOTOR, MotorType.kBrushless);
  CANSparkMax rightRearMotor = new CANSparkMax(RobotMap.REAR_RIGHT_MOTOR, MotorType.kBrushless);
  MecanumDrive drivetrain = new MecanumDrive(leftFrontMotor,leftRearMotor,rightFrontMotor,rightRearMotor);

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }
  public void setdrivevector(Vector axis)
  {
    double axisX = (double) axis.elementAt(0);
    double axisY = (double) axis.elementAt(1);
    double axisZ = (double) axis.elementAt(2);

    double xSpeed = (Math.pow(axisX,RobotMap.EXPO)/RobotMap.DOWNSCALE);
    double ySpeed = (Math.pow(axisY,RobotMap.EXPO)/RobotMap.DOWNSCALE);
    double zSpeed = (Math.pow(axisZ,RobotMap.EXPO)/RobotMap.DOWNSCALE);

    double xZoned = Math.abs(xSpeed) < RobotMap.DEADZONE ? 0.0 : xSpeed - (RobotMap.DEADZONE * Math.abs(xSpeed) / xSpeed);
    double yZoned = Math.abs(ySpeed) < RobotMap.DEADZONE ? 0.0 : ySpeed - (RobotMap.DEADZONE * Math.abs(ySpeed) / ySpeed);
    double zZoned = Math.abs(zSpeed) < RobotMap.DEADZONE ? 0.0 : zSpeed - (RobotMap.DEADZONE * Math.abs(zSpeed) / zSpeed);

    double xFactor = xZoned * RobotMap.SPEEDFACTOR;
    double yFactor = yZoned * RobotMap.SPEEDFACTOR;
    double zFactor = zZoned * RobotMap.TURNFACTOR;

    drivetrain.driveCartesian(-xFactor,yFactor,-zFactor);
  }
}
