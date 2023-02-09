package frc.robot.commands.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RomiGyro extends SubsystemBase {
    private SimDouble m_simAngleZ;
    private double m_angleZOffset;

    private SimDouble m_simAngleX;

    private SimDouble m_simAngleY;

    LinearFilter smoothFilter = LinearFilter.singlePoleIIR(0.1, 0.02);

    /**
     * creates values to be used in other functions.
     *  sets our simAngleZ as a boolean to determine the input as T/F.
     */
    private RomiGyro() {
        SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro"); 

        if(gyroSimDevice != null) {
            gyroSimDevice.createBoolean("init", Direction.kOutput, true);
            m_simAngleZ = gyroSimDevice.createDouble("angle_z", Direction.kOutput, 0.0);

            m_simAngleX = gyroSimDevice.createDouble("angle x", Direction.kOutput, 0.0);

            m_simAngleY = gyroSimDevice.createDouble(getName(), Direction.kOutput, 0.0);
        }
    }

    /**
     * calculates the angle based of the gyro
     * 
     * @return the value of angle Z
     */
    public double getAngleZ() {
        if(m_simAngleZ != null) {
            return smoothFilter.calculate(m_simAngleZ.get()) - m_angleZOffset;
        }
        return 0.0;
    }

    /**
     * @return the value of angle x
     */
    public double getAngleX() {
        if(m_simAngleZ != null) {
            return smoothFilter.calculate(m_simAngleX.get()) - m_angleZOffset;
        }
        return 0.0;
    }

    /**
     * @return the value of angle y
     */
    public double getAngleY() {
        if(m_simAngleZ != null) {
            return smoothFilter.calculate(m_simAngleY.get()) - m_angleZOffset;
        }
        return 0.0;
    }

    /**
     * resets the angle until it's null 
     */
    public void reset() {
        if(m_simAngleZ != null) {
            m_angleZOffset = m_simAngleZ.get();
            m_angleZOffset = m_simAngleX.get();
            m_angleZOffset = m_simAngleY.get();
        }
    }
}
