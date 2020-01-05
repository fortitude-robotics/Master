/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Vector;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem 
{
  private CANSparkMax leftFrontMotor = new CANSparkMax(RobotMap.FRONT_LEFT_MOTOR, MotorType.kBrushless);
  private CANSparkMax rightFrontMotor = new CANSparkMax(RobotMap.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
  private CANSparkMax leftRearMotor = new CANSparkMax(RobotMap.REAR_LEFT_MOTOR, MotorType.kBrushless);
  private CANSparkMax rightRearMotor = new CANSparkMax(RobotMap.REAR_RIGHT_MOTOR, MotorType.kBrushless);
  private MecanumDrive drivetrain = new MecanumDrive(leftFrontMotor,leftRearMotor,rightFrontMotor,rightRearMotor);
  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here no
    setDefaultCommand(new Drive());
  }
  public void setdrivevector(Vector<Double> axis)
  {
    double axisX = (double) axis.elementAt(0);
    double axisY = (double) axis.elementAt(1);
    double axisZ = (double) axis.elementAt(2);

    double xFactor = axisX * RobotMap.SCALEFACTOR;
    double yFactor = axisY * RobotMap.SCALEFACTOR;
    double zFactor = axisZ * RobotMap.SCALEFACTOR;

    drivetrain.driveCartesian(-xFactor,yFactor,-zFactor);
  }
  public String readEncoder()
  {
    int cpr1 = RobotMap.NULL;
    int cpr2 = RobotMap.NULL;
    int cpr3 = RobotMap.NULL;
    int cpr4 = RobotMap.NULL;
    
    CANEncoder LRM = leftRearMotor.getEncoder(EncoderType.kHallSensor, cpr1);
    CANEncoder LFM = leftFrontMotor.getEncoder(EncoderType.kHallSensor, cpr2);
    CANEncoder RRM = rightRearMotor.getEncoder(EncoderType.kHallSensor, cpr3);
    CANEncoder RFM = rightFrontMotor.getEncoder(EncoderType.kHallSensor, cpr4);
    String encVal = "(" + 
    String.format("%.2f",LRM.getVelocity()) +"  "+ String.format("%.2f",leftRearMotor.getAppliedOutput()) +"\t"+
    String.format("%.2f",LFM.getVelocity()) +"  "+ String.format("%.2f",leftFrontMotor.getAppliedOutput()) +"\t"+
    String.format("%.2f",RRM.getVelocity()) +"  "+ String.format("%.2f",rightRearMotor.getAppliedOutput()) +"\t"+
    String.format("%.2f",RFM.getVelocity()) +"  "+ String.format("%.2f",rightFrontMotor.getAppliedOutput()) +"\t";
    System.out.println();
    SmartDashboard.putNumber("left Rear", -LRM.getVelocity());
    SmartDashboard.putNumber("left front", LFM.getVelocity());
    SmartDashboard.putNumber("right rear", -RRM.getVelocity());
    SmartDashboard.putNumber("right front", RFM.getVelocity());
    return encVal;
  }
  public void setSafety()
  {
    drivetrain.setSafetyEnabled(false);
  }
}
