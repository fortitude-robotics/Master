/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Vector;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);

  public Vector GetControllerRawAxis()
  {
    Vector axis = new Vector();
    axis.add(driverController.getAxis(AxisType.kX));
    axis.add(driverController.getAxis(AxisType.kY));
    axis.add(driverController.getAxis(AxisType.kZ));
    return axis;
  }

}
