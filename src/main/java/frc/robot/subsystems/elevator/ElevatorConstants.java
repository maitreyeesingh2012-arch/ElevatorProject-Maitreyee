package frc.robot.subsystems.elevator;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecondPerSecond;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import badgerutils.motor.MotorConfigUtils;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;

public class ElevatorConstants {
    public static final double KP = 0, KD = 0, KS = 0, KG = 0;
    public static final AngularVelocity MAX_VELOCITY = RotationsPerSecond.of(100);
    public static final AngularAcceleration MAX_ACCELERATION = RotationsPerSecondPerSecond.of(100);
    public static final TalonFXConfiguration MOTOR_CONFIG_CW = new TalonFXConfiguration()
    .withMotorOutput(MotorConfigUtils.createMotorOutputConfig(InvertedValue.Clockwise_Positive, NeutralModeValue.Brake))
    .withCurrentLimits(MotorConfigUtils.createCurrentLimitsConfig(Amps.of(40), Amps.of(60)))
    .withSlot0(MotorConfigUtils.createSlotConfig(KP, KD, KS, 0, KG, GravityTypeValue.Elevator_Static, StaticFeedforwardSignValue.UseClosedLoopSign));
}
