package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;

public class AutonomousDistance extends SequentialCommandGroup{
    public AutonomousDistance(RomiDrivetrain drivetrain)
    {
        addCommands(
            new DriveForward(drivetrain, 1.0),
            new DriveForward(drivetrain, 1.0)
        );
    }
}
