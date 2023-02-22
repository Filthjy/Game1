package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveForward extends CommandBase {
    private final RomiDrivetrain m_subsystem;
    private double m_distance;

    public DriveForward(RomiDrivetrain subsystem, double distance)
    {
        m_subsystem = subsystem;
        m_distance = distance;
    }

    // Called when the command is initially scheduled.

  public void initialize() 
    {
        m_subsystem.resetEncoders();
    }

  // Called every time the scheduler runs while the command is scheduled.

  public void execute() 
    {
        m_subsystem.drive(0.5, 0);
    }

  // Called once the command ends or is interrupted.

  public void end(boolean interrupted) {
        m_subsystem.drive(0, 0);
        m_subsystem.resetEncoders();
  }

  // Returns true when the command should end.

  public boolean isFinished() {
    double averageDistance = (m_subsystem.getLeftDistance() + m_subsystem.getRightDistance()) / 2; 
    return averageDistance > m_distance;
  }

}


