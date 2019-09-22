package frc.robot.modules;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Robot;

public class DriveTrain extends RobotModule{

    public DriveTrain(Robot parentRobot){
        super(parentRobot);
    }
    
    public void robotInit(){

    }
    
    public void robotPeriodic(){

    }

    public void autonomousInit(){

    }

    public void autonomousPeriodic(){

    }
    public void disabledInit(){

    }

    public void disabledPeriodic(){

    }

    public void teleopInit(){

    }

    public void teleopPeriodic(){
        //Create instances of the speed controllers which control the motors
    //They can be set to powers between 1.0 and -1.0

        double Speed = -parentRobot.Hardware.getY(Hand.kLeft); //Returns how far up or down the left joystick is from -1.0 to 1.0
        double Turn = stick.getX(Hand.kLeft); //Returns how far left or right the left joystick is from -1.0 to 1.0
        double Strafe = stick.getX(Hand.kRight); //Returns how far left or right the right joystick is from -1.0 to 1.0

        //We use tupples to ensure we power the motors between 1.0 and -1.0
        parentRobot.Hardware.leftFrontMotor.set((Speed + Turn - Strafe > 1) ? 1 : Speed + Turn - Strafe); 
        parentRobot.Hardware.leftRearMotor.set((Speed + Turn + Strafe > 1) ? 1 : Speed + Turn + Strafe);
        parentRobot.Hardware.rightFrontMotor.set((Speed - Turn + Strafe > 1) ? 1 : Speed - Turn + Strafe);
        parentRobot.rightRearMotor.set((Speed - Turn - Strafe < -1) ? -1 : Speed - Turn - Strafe);
    }

    public void testInit(){

    }
    public void testPeriodic(){

    }

}