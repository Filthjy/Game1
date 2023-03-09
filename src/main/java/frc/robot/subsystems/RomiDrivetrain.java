package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * sets our wheel diameter as a static number. 
 * exstends/imports the subsystem base.
 * The stored numbers will be used in other parts of our code.
 */
public class RomiDrivetrain extends SubsystemBase {
    private final static double wheelDiameter = 2.75591; // 70mm
    private final static double countsPerRotation = 1440;
    /**
     * We use spark to set up 2 channels, one for the right and one for the left motor. 
     */
    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);
    /**
     * sets up our encoders to sense the rotations, coinciding with the parameters above. 
     * using the diameter Its able to find out how far the robots moved.
     */
    private final Encoder m_leftEncoder = new Encoder ( 4,  5);
    private final Encoder m_rightEncoder = new Encoder( 6,  7);

    private final DifferentialDrive m_diffDrive =  new DifferentialDrive(m_leftMotor, m_rightMotor);
    /** 
    *
    * RomiDrivetrain impliments our encoders, and tells the robot how to calculate the distance measured by the encoders.
   */
    public RomiDrivetrain()
    {
        m_leftEncoder.setDistancePerPulse((Math.PI * wheelDiameter)/countsPerRotation);
        m_rightEncoder.setDistancePerPulse((Math.PI * wheelDiameter)/countsPerRotation);

        m_rightMotor.setInverted(true);

    }
    /**
     * defines the spped at wich the robot will move forward or turn.
     * @param xSpeed - speed for our robot, ranging from -1 to 1.
     * @param zRotation - rotation speed for our robot.
     */
    public void drive(double xSpeed, double zRotation)
    {
        m_diffDrive.arcadeDrive(xSpeed, zRotation);
    }
    /**
     * Reset right and left encoders to zero.
     */
    public void resetEncoders()
    {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }
    /**
     * returns our encoder at the top of our RomiDrivetrain.
     * this returns the distance measured by our encoders.
     */
    public double getLeftDistance()
    {
        return m_leftEncoder.getDistance();
    }
    public double getRightDistance()
    {
        return m_rightEncoder.getDistance();
    }
}
