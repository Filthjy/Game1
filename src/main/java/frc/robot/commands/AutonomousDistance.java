package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;

public class AutonomousDistance extends SequentialCommandGroup{
    public AutonomousDistance(RomiDrivetrain drivetrain)
    {
        addCommands(

            new TurnDegrees(drivetrain, 38),
            new TurnDegrees(drivetrain, 38),
            new TurnDegrees(drivetrain, 38),
            new DriveForward(drivetrain, 40.0),
            new TurnDegrees(drivetrain, 38),
            new DriveForward(drivetrain, 20.0)
            

            
        );
    }
}
