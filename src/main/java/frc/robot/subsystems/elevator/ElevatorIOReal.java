package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXSConfiguration;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.controls.PositionTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import badgerutils.advantagekit.cancoder.CANCoderSignals;
import badgerutils.advantagekit.talonfx.TalonFXSignals;
import badgerutils.motor.MotorGroup;
import edu.wpi.first.units.measure.Angle;

public class ElevatorIOReal implements ElevatorIO {
    private final TalonFX leftMotor = new TalonFX(0);
    private final TalonFX rightMotor = new TalonFX(1);
    private final CANcoder encoder = new CANcoder(2);
    private final TalonFXSignals leftMotorSignals = new TalonFXSignals(leftMotor);
    private final TalonFXSignals rightMotorSignals = new TalonFXSignals(rightMotor);
    private final CANCoderSignals encoderSignals = new CANCoderSignals(encoder);
    private final MotorGroup motorGroup  = new MotorGroup(leftMotor, rightMotor);
    private final MotionMagicTorqueCurrentFOC positionRequest = new MotionMagicTorqueCurrentFOC(0);
    @Override
    public void updateInputs(ElevatorIOInputs inputs){
        inputs.leftMotor = leftMotorSignals.createLoggedTalonFX();
        inputs.rightMotor = rightMotorSignals.createLoggedTalonFX();
        inputs.encoder = encoderSignals.createLoggedCANCoder();

    }
    @Override
    public void setPosition(Angle position){
        positionRequest.withPosition(position); //updates request
        motorGroup.setControl(positionRequest); //applies request

    }
    
    
    }
    

