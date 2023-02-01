package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class TurnDegrees extends CommandBase {
    private final RomiDrivetrain m_subsystem;
    private double m_degrees;
    private static final double diameter = 500.5;

    public TurnDegrees(RomiDrivetrain subsystem, double degrees)
    {
        m_subsystem = subsystem;
        m_degrees = degrees;
    }

    // Called when the command is initially scheduled.

  public void initialize() 
    {
        m_subsystem.resetEncoders();
    }

  // Called every time the scheduler runs while the command is scheduled.

  public void execute() 
    {
        m_subsystem.drive(0, 0.5);
    }

  // Called once the command ends or is interrupted.

  public void end(boolean interrupted) {
        m_subsystem.drive(0, 0);
        m_subsystem.resetEncoders();
  }

  // Returns true when the command should end.

  public boolean isFinished() {
    double averageDistance = (Math.abs(m_subsystem.getLeftDistance()) + Math.abs(m_subsystem.getRightDistance())) / 2;
    double angle = (averageDistance/(Math.PI * diameter)*360);
    return angle > m_degrees;
  }

}
