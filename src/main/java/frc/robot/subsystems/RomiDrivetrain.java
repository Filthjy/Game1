package frc.robot.subsystems;



import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class RomiDrivetrain extends SubsystemBase {
    private final static double wheelDiameter = 2.75591; // 70mm
    private final static double countsPerRotation = 1440;

    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);

    private final Encoder m_leftEncoder = new Encoder ( 4,  5);
    private final Encoder m_rightEncoder = new Encoder( 6,  7);

    private final DifferentialDrive m_diffDrive =  new DifferentialDrive(m_leftMotor, m_rightMotor);
    /** 
    *
    *
   */
    public RomiDrivetrain()
    {
        m_leftEncoder.setDistancePerPulse((Math.PI * wheelDiameter)/countsPerRotation);
        m_rightEncoder.setDistancePerPulse((Math.PI * wheelDiameter)/countsPerRotation);

        m_rightMotor.setInverted(true);

    }

    public void drive(double xSpeed, double zRotation)
    {
        m_diffDrive.arcadeDrive(xSpeed, zRotation);
    }

    public void resetEncoders()
    {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    public double getLeftDistance()
    {
        return m_leftEncoder.getDistance();
    }
    public double getRightDistance()
    {
        return m_rightEncoder.getDistance();
    }
}
