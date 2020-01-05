/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HoldPosition;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem 
{
  private TalonSRX Upperfeed = new TalonSRX(1);
  private TalonSRX Lowerfeed = new TalonSRX(1);
  private TalonSRX Lift1 = new TalonSRX(1);
  private TalonSRX Lift2 = new TalonSRX(1);
  

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HoldPosition());
  }
  
  public void liftUp()
  {

  }
  public void liftDown()
  {

  }

  public void feedIn()
  {

  }
  public void feedOut()
  {
    
  }
}
