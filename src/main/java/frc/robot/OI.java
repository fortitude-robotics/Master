/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Vector;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);

  public Vector<Double> GetControllerRawAxis()
  {
    Vector<Double> axis = new Vector<Double>();
    axis.add(driverController.getX());
    axis.add(driverController.getY());
    axis.add(driverController.getZ());
    return axis;
  }
  public boolean GetL1Bumper()
  {
    return driverController.getRawButton(RobotMap.LEFT_BUMPER_1);
  }
  public boolean GetR1Bumper()
  {
    return driverController.getRawButton(RobotMap.RIGHT_BUMPER_1);
  }

}
