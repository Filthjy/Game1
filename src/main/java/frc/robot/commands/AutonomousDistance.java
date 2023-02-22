package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;

public class AutonomousDistance extends SequentialCommandGroup{
    public AutonomousDistance(RomiDrivetrain drivetrain)
    {
        addCommands(
            new DriveForward(drivetrain, 5.0),
            new TurnDegrees(drivetrain, 70),
            new DriveForward(drivetrain, 5.0),
            new TurnDegrees(drivetrain, 70),
            new DriveForward(drivetrain, 5.0),
            new TurnDegrees(drivetrain, 70),
            new DriveForward(drivetrain, 5.0),
            new TurnDegrees(drivetrain, 70),
            new DriveForward(drivetrain, 5.0),
            new TurnDegrees(drivetrain, 70)
        );
        
    }
}
