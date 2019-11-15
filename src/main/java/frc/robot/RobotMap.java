/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
  public final static int DRIVER_CONTROLLER = 0;

  public final static double SPEEDFACTOR = .7;
  public final static double TURNFACTOR = .7;

  public final static int DOWNSCALE = 1000;
  public final static double EXPO = 3;
  public final static double DEADZONE = .05;
  public final static int FRONT_LEFT_MOTOR = 1;
  public final static int REAR_LEFT_MOTOR = 2;
  public final static int FRONT_RIGHT_MOTOR = 3;
  public final static int REAR_RIGHT_MOTOR = 4;
}
