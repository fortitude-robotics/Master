/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  XboxController stick = new XboxController(0);
  
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //Create instances of the speed controllers which control the motors
    //They can be set to powers between 1.0 and -1.0
    CANSparkMax leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax rightFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
    double Speed = -stick.getY(Hand.kLeft); //Returns how far up or down the left joystick is from -1.0 to 1.0
    double Turn = stick.getX(Hand.kLeft); //Returns how far left or right the left joystick is from -1.0 to 1.0
    double Strafe = stick.getX(Hand.kRight); //Returns how far left or right the right joystick is from -1.0 to 1.0

            //We use tupples to ensure we power the motors between 1.0 and -1.0
            leftFrontMotor.set((Speed + Turn - Strafe > 1) ? 1 : Speed + Turn - Strafe); 
            leftRearMotor.set((Speed + Turn + Strafe > 1) ? 1 : Speed + Turn + Strafe);
            rightFrontMotor.set((Speed - Turn + Strafe > 1) ? 1 : Speed - Turn + Strafe);
            rightRearMotor.set((Speed - Turn - Strafe < -1) ? -1 : Speed - Turn - Strafe);
                    
  }

  /*
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    boolean ButtonA = stick.getRawButton(1);
    boolean ButtonB = stick.getRawButton(2);
    boolean ButtonX = stick.getRawButton(3);
    boolean ButtonY = stick.getRawButton(4);
    boolean JoyLeftB = stick.getRawButton(9);
    boolean JoyRightB = stick.getRawButton(10);
    double JoyLeftX = stick.getX(Hand.kLeft);
    double JoyLeftY = stick.getY(Hand.kLeft);
    double JoyRightX = stick.getX(Hand.kRight);
    double JoyRightY = stick.getY(Hand.kRight);
    double lt = stick.getTriggerAxis(Hand.kLeft);
    double rt = stick.getTriggerAxis(Hand.kRight);
    

    /*if (ButtonA){
      System.out.println("A");
    }
    if (ButtonB){
      System.out.println("B");
    }
    if (ButtonX){
      System.out.println("X");
    }
    if (ButtonY){
      System.out.println("Y");
    }
    if (JoyLeftX >= 0.5){
      System.out.println("Left joystick placed right");
    }
    if (JoyLeftX <= -0.5){
      System.out.println("Left joystick placed left");
    }
    if (JoyLeftY <= -0.5){
      System.out.println("Left joystick placed up");
    }
    if (JoyLeftY >= 0.5){
      System.out.println("Left joystick placed down");
    }
    if (JoyRightY <= -0.5){
      System.out.println("Right joystick placed up");
    }
    if (JoyRightY >= 0.5){
      System.out.println("Right joystick placed down");
    }
    if (JoyRightX >= 0.5){
      System.out.println("Right joystick placed right");
    }
    if (JoyRightX <= -0.5){
      System.out.println("Right  joystick placed left");
    }
    if (lt == 1){
      System.out.println("Left trigger pressed");
    }
    if (rt == 1){
      System.out.println("Right trigger pressed");
    }
    if (JoyLeftB){
      System.out.println("Left trigger pressed");
    }
    if (JoyRightB){
      System.out.println("Right trigger pressed");
    }
    exampleSpeedController.set(JoyLeftY * 0.25);
    */
  }
}
