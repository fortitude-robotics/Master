/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem 
{
  CANSparkMax leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
  MecanumDrive drivetrain = new MecanumDrive(leftFrontMotor,leftRearMotor,rightFrontMotor,rightRearMotor);

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
