package frc.robot.modules;

import frc.robot.Robot;

public abstract class RobotModule{
    Robot parentRobot;
    public RobotModule(Robot parentRobot){
        this.parentRobot = parentRobot;
    }

    @Deprecated
    public RobotModule(){
        // Gosh Dermott... You're not suppored to be using this. Use `RobotModule(TimedRobot parentRobot)` instead
    }

    public abstract void robotInit();
    public abstract void robotPeriodic();

    public abstract void autonomousInit();
    public abstract void autonomousPeriodic();

    public abstract void disabledInit();
    public abstract void disabledPeriodic();

    public abstract void teleopInit();
    public abstract void teleopPeriodic();

    public abstract void testInit();
    public abstract void testPeriodic();
}