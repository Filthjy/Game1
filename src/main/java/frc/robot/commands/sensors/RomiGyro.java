package frc.robot.commands.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RomiGyro extends SubsystemBase {
    private SimDouble m_simAngleZ;

    private double m_angleZOffset;

    LinearFilter smoothFilter = LinearFilter.singlePoleIIR(0.1, 0.02);


    private RomiGyro() {
        SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro"); 

        if(gyroSimDevice != null) {
            gyroSimDevice.createBoolean("init", Direction.kOutput, true);
            m_simAngleZ = gyroSimDevice.createDouble("angle_z", Direction.kOutput, 0.0);
        }
    }

    public double getAngleZ() {
        if(m_simAngleZ != null) {
            return smoothFilter.calculate(m_simAngleZ.get()) - m_angleZOffset;
        }
        return 0.0;
    }

    public void reset() {
        if(m_simAngleZ != null) {
            m_angleZOffset = m_simAngleZ.get();
        }
    }
}
